/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import static hu.unideb.inf.pkg.progkornybeadando.Database.Validation.peldanyka;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * A {@link TempXML} osztályban lévő metódusok, a bejelentkezés és a regisztáció
 * során a feldolgozástban játszanak fontos szerepet.
 * <p>
 * Az olvasást segítő metódusokon kívűl, fontos megemlíteni még, hogy ebben az
 * osztályban található az a tempXML metódus, mely előállítja az adatbázis
 * számára nélkülözhetetlen segéd XML-t.</p>
 */
public class TempXML {

    /**
     * A TempXML osztály konstruktora.
     */
    TempXML() {
    }
    /**
     *A TempXML osztály egyetlen pédánya.
     */
    private static TempXML xml;

    /**
     * A {@link getxml} lekéri az egyetlen egy példányát a TempXML objektumnak.
     *
     * @return TempXML objektumot ad vissza.
     */
    public static TempXML getxml() {
        if (xml == null) {
            xml = new TempXML();
        }
        return xml;
    }
    /**
     * Az XML egyetlen egy példánya.
     */
    public static TempXML xmlke = TempXML.getxml();
    /**
     * A regUser objektum egy példánya.
     */
    public static regUser adat;
    /**
     *A regisztráció során hibát jelző változó.
     */
    private boolean hibaVan = false;
    /**
     *A bejelentkezés során hibát jelző változó.
     */
    private boolean hibaVan2 = false;
    /**
     *A felhasználó neveket tartalmazó lista.
     */
    List<String> felhasznalo_nevek = new ArrayList<>();

    /**
     * A {@link setHibaVan} metódus beállítja a hibaVan változó értékét.
     *
     * @param hibaVan alapértelmezett értéke false
     */
    public void setHibaVan(boolean hibaVan) {
        this.hibaVan = hibaVan;
    }

    /**
     * A {@link isHibaVan} metódus lekéri a hibaVan változó értékét.
     *
     * @return Visszaadja a hibaVan változót.
     */
    public boolean isHibaVan() {
        return hibaVan;
    }

    /**
     * A regisztációs adatokat tudjuk lekérdezni a {@link setAdat} metódus
     * segítségével.
     *
     * @param adat regUser objektum
     */
    public void setAdat(regUser adat) {
        this.adat = adat;
    }
    /**
    * A seged.xml tartalmat tartalmazó fájl.
    */
    public File segedfajl;
    /**
     * A {@link tempXML} metódus készíti el a seged.xml dokumentumokat.
     * <p>
     * Az XML dokumentumokat csomópontok segítségével állítjuk elő, melyben
     * minden egyes csomópont esetében megmondjuk, hogy milyen szerepet tölt be
     * az XML dokumentumban. A segéd XML fájl fontos szerepet tölt be az
     * adatbázis előállítása során.</p>
     */
    public void tempXML() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element Projekt = doc.createElement("Projekt");
            doc.appendChild(Projekt);

            Element adatok = doc.createElement("Adatok");
            Projekt.appendChild(adatok);

            Element felhasznalok = doc.createElement("Felhasznalok");
            adatok.appendChild(felhasznalok);

            Element felhasznaloelem = doc.createElement("Felhasznalo");
            Attr id = doc.createAttribute("id");
            id.setValue(adat.getUserfield());
            felhasznaloelem.setAttributeNode(id);
            felhasznalok.appendChild(felhasznaloelem);

            Element jelszoelem = doc.createElement("Jelszo");
            jelszoelem.appendChild(doc.createTextNode(adat.getPasswordfield()));
            felhasznaloelem.appendChild(jelszoelem);

            Element jelszo2elem = doc.createElement("Jelszo2");
            jelszo2elem.appendChild(doc.createTextNode(adat.getPasswordfield2()));
            felhasznaloelem.appendChild(jelszo2elem);

            Element Kar = doc.createElement("Kar");
            Kar.appendChild(doc.createTextNode(adat.getKarfield()));
            felhasznaloelem.appendChild(Kar);

            Element Szak = doc.createElement("Szak");
            Szak.appendChild(doc.createTextNode(adat.getSzakfield()));
            felhasznaloelem.appendChild(Szak);

            Element Ev = doc.createElement("Evfolyam");
            Ev.appendChild(doc.createTextNode(adat.getEvfield()));
            felhasznaloelem.appendChild(Ev);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();

            DOMSource forras = new DOMSource(doc);
            InputStream in = getClass().getClassLoader().getResourceAsStream("xml/seged.xml");
            File tempFile = File.createTempFile("vmi3", ".xml");
            tempFile.deleteOnExit();
            FileOutputStream out = new FileOutputStream(tempFile);
            byte[] buffer = new byte[10 * 1024];
            segedfajl = tempFile;
            for (int length; (length = in.read(buffer)) != -1;) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
            out.close();

            //StreamResult eredmeny = new StreamResult(new File("target/classes/xml/seged.xml"));
            StreamResult eredmeny = new StreamResult(tempFile);
            t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            t.transform(forras, eredmeny);
        } catch (TransformerException | ParserConfigurationException | IOException ex) {
            Logger.getLogger(TempXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * A {@link readXML} metódus segítségével olvasunk ki felhasználókat a
     * regisztráció során.
     * <p>
     * A felhasználó csomópont alapján olvassa ki az adatokat az XML
     * dokumentumból.</p>
     */
    public void readXML() {
        try {
            hibaVan = false;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputStream in = getXMLjar();
            //InputStream in = getClass().getClassLoader().getResourceAsStream("xml/database.xml");
            Document doc = db.parse(in);
            doc.getDocumentElement().normalize();
            NodeList n1 = doc.getElementsByTagName("Felhasznalo");
            peldanyka.valid_reg(n1);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(TempXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * A {@link readLoginXML} metódus segítségével olvasunk ki felhasználókat az
     * adatbázisból a bejelentkezés során.
     * <p>
     * A metódus a XML fájlt bejárja a megadott csomópontok segítségével.</p>
     */
    public void readLoginXML() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputStream in = getXMLjar();
            //InputStream in = getClass().getClassLoader().getResourceAsStream("xml/database.xml");
            // File bement=new File("target/classes/xml/database.xml");
            Document doc = db.parse(in);
            doc.getDocumentElement().normalize();
            NodeList n1 = doc.getElementsByTagName("Jelszo");
            NodeList n2 = doc.getElementsByTagName("Felhasznalo");
            peldanyka.valid_log(n1, n2);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(TempXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    /**
     *Az aktuális jar fájl beállításait kérdezi le az xml/database.xml fájlhoz.
     * 
     * <p>A metódus megvizsgálja a jarban található összes directoryt, majd
     * ha megegyezőt talált az xml/database.xml-el akkor mélymásolással egy 
     * InputStreamként kezeli.</p>
     * @return Visszadja legfrissebb jar fájlt.
     */
    private InputStream getXMLjar() {
        InputStream result = null;
        try {
            String vmi=TempXML.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String classes = vmi.substring(vmi.length()-8,vmi.length()-1);
            String tempjarName;
            if("classes".equals(classes)){
                String ujvmi=vmi.substring(0,vmi.length()-8);
                tempjarName=ujvmi+"progkornybeadando-javafx-1.0.jar";
            }else{
                tempjarName=vmi;
            }
            String jarName=tempjarName;
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
     *A {@link clone} metódus valósítja meg a másolást.
     * <p>A metódus Inputstreamet vár bemenetként, 
     * amit mélymásolás segítségével egy ByteArrayInputStreambe másol.
     * Magyarul mélymásolás történik.</p>
     * @param input objektum
     * @return Visszaad egy InputStream objektumot.
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
