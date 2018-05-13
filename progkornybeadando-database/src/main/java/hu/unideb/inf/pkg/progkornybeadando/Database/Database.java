package hu.unideb.inf.pkg.progkornybeadando.Database;

/*-
 * #%L
 * progkornybeadando-database
 * %%
 * Copyright (C) 2018 Debreceni Egyetem, Informatika Kar
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 1 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-1.0.html>.
 * #L%
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * A {@link Database} osztály felelős a database.xml dokumentum előállításáért.
 * <p>
 * Ez az osztály tartalmaz az XML feldolgozáshoz szükséges alapvető metódusokat,
 * mint például az {@link ir} vagy {@link konkatenal} metódusokat.</p>
 */
public class Database {

    /**
     * A {@link Database} osztály konstruktora.
     */
    public Database() {
    }

    /**
     * A {@link konkatenal} metódus felelős az XML dokumentumok konkatenálásáért
     * stringek segítségével.
     * <p>
     * A metódus az XML dokumentumok megadott target-ja alapján összefésüli a
     * két XML fájlt. Előbb az adatbázis XML dokumentumát lebontja, majd
     * újjáépíti a másik XML dokumentum alapján.
     * </p>
     * 
     * @param kifejezesek kifejezés az XML-ből
     * @param fajlok konkatenálásra szánt fájlok
     * @return Visszaad egy Document objektumot.
     */
    private static Document konkatenal(String kifejezesek, File... fajlok) {
        try {
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();
            XPathExpression sokkifejezes = xpath.compile(kifejezesek);
            return konkatenal(sokkifejezes, fajlok);

        } catch (XPathExpressionException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * A {@link konkatenal} metódus felelős az XML dokumentumok
     * konkatenálásáért,XPathExpression segítségével.
     * <p>
     * A metódus az XML dokumentumok megadott target-ja alapján összefésüli a
     * két XML fájlt. Előbb az adatbázis XML dokumentumát lebontja, majd
     * újjáépíti a másik XML dokumentum alapján.
     * </p>
     * @param kifejezesek az XML egy targetjének a neve
     * @param fajlok a konkatenálni kívánt fájlok
     * @return Egy Document objektumot ad vissza.
     */
    private static Document konkatenal(XPathExpression kifejezesek, File... fajlok) {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilderFactory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document base = docBuilder.parse(fajlok[0]);
            Node results = (Node) kifejezesek.evaluate(base, XPathConstants.NODE);
            if (results == null) {
                throw new IOException(fajlok[0] + ": nincs csomópont");
            }
            for (int i = 1; i < fajlok.length; i++) {
                Document konkatenal = docBuilder.parse(fajlok[i]);
                Node kovetkezoEredmeny = (Node) kifejezesek.evaluate(konkatenal, XPathConstants.NODE);
                while (kovetkezoEredmeny.hasChildNodes()) {
                    Node gyerek = kovetkezoEredmeny.getFirstChild();
                    kovetkezoEredmeny.removeChild(gyerek);
                    gyerek = base.importNode(gyerek, true);
                    results.appendChild(gyerek);
                }
            }
            return base;
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Az {@link ir} metódus hozza létre a database.xml-t.
     * <p>
     * A metódus létrehoz egy segéd fájlt az adatbázis jar filen belüli
     * működéséhez. </p>
     * @param doc a konkatenálást tartalmazó dokumentum
     */
    private void ir(Document doc) {
        try {
            File seged = new File("database.xml");
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource forras = new DOMSource(doc);
            StreamResult eredmeny = new StreamResult(seged);
            t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            t.transform(forras, eredmeny);
            jarkeszites(seged.getAbsolutePath());
            seged.delete();
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * A {@link konkatenalXML} metódusban történik a végső database.xml
     * előállítása.
     * <p>
     * A konkatenálás során streamek feldolgozása történik, ahol lekéri a jar
     * fájl mindenkori adatait és létrehoz egy segéd fájlt, amely a konkatenálás
     * során szükséges. A megadott targetek alapján
     * </p>
     */
    public void konkatenalXML() {
        try {
            FileOutputStream out2;
            InputStream in2 = getXMLjar();
            //InputStream in2 = getClass().getClassLoader().getResourceAsStream("xml/database.xml");
            File fajl2 = File.createTempFile("vmi1", ".xml");
            fajl2.deleteOnExit();
            out2 = new FileOutputStream(fajl2);
            byte[] buffer2 = new byte[10 * 1024];
            for (int length2; (length2 = in2.read(buffer2)) != -1;) {
                out2.write(buffer2, 0, length2);
            }
            in2.close();
            out2.flush();
            out2.close();
            Document doc = konkatenal("/Projekt/Adatok/Felhasznalok", TempXML.xmlke.segedfajl, fajl2);
            ir(doc);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * A metódus futtatási időben felülírja a jar fájlt.
     * <p>
     * Ahhoz, hogy a regisztráció kontroller és a login kontroller megfelelően
     * működjön, futtatási időben kell módosítani a jar fájlt. Ezt legkönnyebben
     * a régi jar felülírásával történhet.</p>
     *
     * @param parameter az új fájlt elérése
     */
    public void jarkeszites(String parameter) {
        try {
            //String jarName = "/home/tzk/NetBeansProjects/ProgkornyBeadando-parent/progkornybeadando-javafx/target/progkornybeadando-javafx-1.0.jar";
            //System.out.println(jarName);
            String vmi = TempXML.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String classes = vmi.substring(vmi.length() - 8, vmi.length() - 1);
            String tempjarName;
            if ("classes".equals(classes)) {
                String ujvmi = vmi.substring(0, vmi.length() - 8);
                tempjarName = ujvmi + "progkornybeadando-javafx-1.0.jar";
            } else {
                tempjarName = vmi;
            }
            String jarName = tempjarName;
            String fileName = parameter;
            File jarFile = new File(jarName);
            File tempJarFile = new File(jarName + ".tmp");
            JarFile jar = new JarFile(jarFile);

            boolean jarUpdated = false;

            try {
                Manifest jarManifest = jar.getManifest();
                JarOutputStream tempJar = new JarOutputStream(new FileOutputStream(tempJarFile));

                byte[] buffer = new byte[1024];
                int bytesRead;
                try {
                    FileInputStream file = new FileInputStream(fileName);
                    try {
                        JarEntry entry = new JarEntry("xml/database.xml");
                        tempJar.putNextEntry(entry);
                        while ((bytesRead = file.read(buffer)) != -1) {
                            tempJar.write(buffer, 0, bytesRead);
                        }
                    } finally {
                        file.close();
                    }
                    for (Enumeration entries = jar.entries(); entries.hasMoreElements();) {
                        JarEntry entry = (JarEntry) entries.nextElement();
                        if (!entry.getName().equals("xml/database.xml")) {

                            InputStream entryStream = jar.getInputStream(entry);
                            tempJar.putNextEntry(entry);

                            while ((bytesRead = entryStream.read(buffer)) != -1) {
                                tempJar.write(buffer, 0, bytesRead);
                            }
                        }
                    }

                    jarUpdated = true;
                } catch (IOException ex) {
                    tempJar.putNextEntry(new JarEntry("stub"));
                } finally {
                    tempJar.close();
                }
            } finally {
                jar.close();
                if (!jarUpdated) {
                    tempJarFile.delete();
                }
            }
            if (jarUpdated) {
                jarFile.delete();
                tempJarFile.renameTo(jarFile);
            }
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Az aktuális jar fájl beállításait kérdezi le az xml/database.xml fájlhoz.
     *
     * <p>
     * A metódus megvizsgálja a jarban található összes directoryt, majd ha
     * megegyezőt talált az xml/database.xml-el akkor mélymásolással egy
     * InputStreamként kezeli.</p>
     * @return Visszaadja a módosított jart.
     */
    private InputStream getXMLjar() {
        InputStream result = null;
        try {
            String vmi = TempXML.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String classes = vmi.substring(vmi.length() - 8, vmi.length() - 1);
            String tempjarName;
            if ("classes".equals(classes)) {
                String ujvmi = vmi.substring(0, vmi.length() - 8);
                tempjarName = ujvmi + "progkornybeadando-javafx-1.0.jar";
            } else {
                tempjarName = vmi;
            }
            String jarName = tempjarName;
            File jarFile = new File(jarName);
            JarFile jar = new JarFile(jarFile);
            for (Enumeration entries = jar.entries(); entries.hasMoreElements();) {
                JarEntry entry = (JarEntry) entries.nextElement();
                if (entry.getName().equals("xml/database.xml")) {
                    // Get an input stream for the entry.
                    result = clone(jar.getInputStream(entry));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TempXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * A {@link clone} metódus valósítja meg a másolást.
     * <p>
     * A metódus Inputstreamet vár bemenetként, amit mélymásolás segítségével
     * egy ByteArrayInputStreambe másol. Magyarul mélymásolás történik.</p>
     *
     * @param input egy InputStream objektum
     * @return Visszaad egy InputSteam objektumot.
     */
    private static InputStream clone(InputStream input) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = input.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();

            InputStream is1 = new ByteArrayInputStream(baos.toByteArray());
            return is1;
        } catch (IOException ex) {
            Logger.getLogger(TempXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
