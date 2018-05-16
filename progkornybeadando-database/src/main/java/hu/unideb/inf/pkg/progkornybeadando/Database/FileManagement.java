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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *A {@link FileManagement} oszályban fáljkezelési metódusok találhatóak.
 * <p>
 * Többek között, itt található a fájl betötlés, a fájl mentés metódusa, 
 * illetve az a metódus, mely segítségével ellenőrizzük, hogy létezik-e a 
 * felhasználó home könyvtárában az adott mappa és fájl.</p>
 */
public class FileManagement {
    
    /**
     *A felhasználó home könyvtárának elérési útját tartalmazza.
     * <p>Ez különböző operációs rendszereken más.</p>
     */
    static final String homeUt=System.getProperty("user.home");
    /**
     *A home könyvtás és a megadott stringet összekonkatenálja 
     * elérési úttá.
     */
    static final Path eleresiUt=Paths.get(homeUt, "adatbazis_2048");
    /**
     * A fájlba mentés metódusa.
     * @param file egy tetszőleges fájl
     * @param nev  a fájl neve
     * @return Visszatérése az alapértelmezett mentéssel.
     **/
    public static boolean mentes(File file, String nev) 
    {
        return mentes(file,nev,false);
    }
    /**
     *A fájlba mentés metódusa.
     * <p>
     * Ez a metódus felelős a mentésért adott bemenet esetén, amely 
     * vagy hozzáfűzi vagy felülírja az adott fájlt.
     * </p>
     * @param file egy tetszőleges fájl
     * @param nev a fájl neve
     * @param hozzafuz hozzáfűzz-e vagy felülírja
     * @return Visszatér azzal, hogy sikeres volt-e vagy nem.
     */
    public static boolean mentes(File file, String nev, boolean hozzafuz)
    {
        String cel= Paths.get(eleresiUt.toString(), nev).toString();
        try {
            FileOutputStream out=new FileOutputStream(cel, hozzafuz);
            
            byte[] adatok = Files.readAllBytes(file.toPath());
            out.write(adatok);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    /**
     *A metódus a fájl betöltéséért felelős.
     * @param nev a fájl neve
     * @return Az adatokat tartalmazó streammel tér vissza.
     * @throws java.io.FileNotFoundException ha nincs ilyen fájl
     */
    public static InputStream betoltes(String nev) throws FileNotFoundException
    {
        File cel = Paths.get(eleresiUt.toString(), nev).toFile();
        InputStream in = new FileInputStream(cel);
        return in;
    }
    /**
     *A metódus a fájl létrehozását ellenőrzi.
     * <p>
     * Ha az adott elérési úton már létezik a megadott mappa illetve fájl,
     * akkor már nem hozza létre újra a megadott mappát.
     * Ha nem létezik, akkor létrehozza az elérési utat a mappával és fájlal.</p>
     * @return Visszatérése során igaz értékkel tér vissza, ha sikeres volt az ellenőrzés.
     */
    public static boolean ellenorzes()
    {
        try {
            if(Files.notExists(eleresiUt)) Files.createDirectory(eleresiUt);
            
            Path ut= Paths.get(eleresiUt.toString(), "database.xml");
            
            if(Files.notExists(ut)) 
            {
                Files.createFile(ut);
                InputStream in2 = FileManagement.class.getClassLoader().getResourceAsStream("xml/database.xml");
                FileOutputStream out2=new FileOutputStream(ut.toFile(), false);
                byte[] adatok = new byte[in2.available()];
                in2.read(adatok);
                out2.write(adatok);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
}
