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



import static hu.unideb.inf.pkg.progkornybeadando.Database.Database.konkatenalXML;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.NodeList;
import static hu.unideb.inf.pkg.progkornybeadando.Database.TempXML.adat;


/**
 *A {@link Validation} osztály felelős az érvényes felhasználónevekért,
 * illetve jelszavakért.
 */
public class Validation {
    public static loginUser logadatok;
    
    private  TempXML xml=TempXML.getxml();
    List<String> felhasznalo_nevek=new ArrayList<>();
    List<String> jelszavak=new ArrayList();
    List<String> user_nevek=new ArrayList();
    
    /**
     *A {@link Validation} osztály konstruktora.
     * 
     */
    private Validation() {
    }
    private static Validation peldany;
    /**
     * A {@link getPeldany} visszaadja a Validation példány egyetlen példányát.
     * <p>
     * Skeletont hoztunk létre a felhasználó adatainak megosztására.</p>
     * @return Egy Validation objektummal tér vissza.
     */
    public static Validation getPeldany()
    {
        if(peldany == null)
            peldany = new Validation();
        return peldany;
    }
    /**
     *Az egyetlen Validation objektum.
     */
    public static Validation peldanyka= Validation.getPeldany();
    /**
     *A bejelentkezéshez szükséges adatokat tudjuk beállítani.
     * @param logadatok egy loginUser objektum
     */
    public void setLogadatok(loginUser logadatok) {
        this.logadatok = logadatok;
    }
   
    public boolean hibaVan2=false;

    /**
     *A hibaVan2 változó lekérdezése történik a metódussal.
     * @return Visszaadja a hiba értékét.
     */
    public boolean isHibaVan2() {
        return hibaVan2;
    }
    /**
     *A hibaVan2 változó beállítása történik a metódussal.
     * @param hibaVan2 hibát jelző változó
     */
    public void setHibaVan2(boolean hibaVan2) {
        this.hibaVan2 = hibaVan2;
    }
    /**
     *A regisztráció érvényességét jelző metódus.
     * <p>A {@link valid_reg} metódus biztosítja számunkra, hogy
     * nem az XML dokumentumban összeférhetetlenségek történjenek.Egy felhasználó név
     * egyediségét és hosszát, a jelszavak megegyezését és hosszáért ellenőrzi.Ha 
     * ezek közül valamelyik nem teljesül, akkor egy változó segítségével kommunikál a kontrollerrel.
     * Ha sikeres volt az ellenőrzés, akkor létrejön egy segéd XML és létrejön az adatbázis. 
     * </p>
     * @param n1 az XML dokumentum egy csomópontja
     */
    public void valid_reg(NodeList n1){       
        for(int i = 0; i< n1.getLength();i++){
            String felhasznalo_id = n1.item(i).getAttributes().getNamedItem("id").getNodeValue();
            felhasznalo_nevek.add(felhasznalo_id);
            if(felhasznalo_nevek.get(i).equals(adat.getUserfield())){
                xml.setHibaVan(true);
            }
        }
        if(adat.getUserfield().length()<5 || adat.getPasswordfield().length()<5 ){
            xml.setHibaVan(true);
        }else{
            if(adat.getPasswordfield().equals(adat.getPasswordfield2()) && xml.isHibaVan()==false){
                xml.tempXML();
                konkatenalXML();
            }else{
                xml.setHibaVan(true);
            }
        }
    }
    
    /**
     *A {@link valid_log} metódus felelős a bejelentkezés ellenőrzéséért.
     * <p>
     * Leellenőrzi, hogy az adatbáziban szerepel-e az adott felhasználó, illetve
     * ha szerepel akkor megegyezik-e a hozzá tartozó jelszava. Ha bármelyik nem sikerül
     * egy változó segítségével értesíti a kontrollert.
     * </p>
     * @param n1    az XML egy csomópontja
     * @param n2    az XML egy másik csomópontja
     */
    public void valid_log(NodeList n1,NodeList n2){
            for(int i = 0; i< n1.getLength();i++){
            jelszavak.add(n1.item(i).getTextContent());
            String fel_id = n2.item(i).getAttributes().getNamedItem("id").getNodeValue();
            user_nevek.add(fel_id);
            if(user_nevek.get(i).equals(logadatok.getLogUser()) && jelszavak.get(i).equals(logadatok.getLogPassword())){
                hibaVan2=false;            
                break;
            }else{
                hibaVan2=true;
            }
          
        }
    }
      
}
