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

/**
 *A regisztráció adatait tartalamazó osztály.
 * <p>
 * A {@link regUser} osztály tartalmazza többek között a 
 * felhasználó felhasználónevét, a jelszavát, a megerősítő jelszavát,
 * az egyetemi karát, az egyetemi szakját, és az évfolyamát.</p>
 */
public class regUser {
    /**
     *A felhasználó neve.
     */
    private String userfield;
    /**
     *A felhasználó jelszava.
     */
    private String passwordfield;
    /**
     *A felhasználó megerősítő jelszava.
     */
    private String passwordfield2;
    /**
     *A felhasználó egyetemi karja.
     */
    private String karfield;
    /**
     *A felhasználó egyetemi szak.
     */
    private String szakfield;
    /**
    *A felhasználó évfolyama.
    */
    private String evfield;
    /**
     *A {@link regUser} osztály konstruktora.
     */
    public regUser(){    
    }

    @Override
    public String toString() {
        return "alap{" + "userfield=" + userfield + ", passwordfield=" + passwordfield + ", passwordfield2=" + passwordfield2 + ", karfield=" + karfield + ", szakfield=" + szakfield + ", evfield=" + evfield + '}';
    }
    /**
     *A metódus a felhasználó nevét adja vissza.
     * @return Visszaadja a felhasználó nevét.
     */
    public String getUserfield() {
        return userfield;
    }
    /**
     * A metódus a felhasználó nevének beállításáért felelős.
     * @param userfield a felhasználó neve 
     */
    public void setUserfield(String userfield) {
        this.userfield = userfield;
    }
   /**
     *A metódus a felhasználó jelszavát adja vissza.
     * @return Visszaadja a felhasználó jelszavát.
     */
    public String getPasswordfield() {
        return passwordfield; 
    }
    /**
     * A metódus a felhasználó jelszavának beállításáért felelős.
     * @param passwordfield a felhasználó jelszava 
     */
    public void setPasswordfield(String passwordfield) {
        this.passwordfield = passwordfield;
    }
       /**
     *A metódus a felhasználó megerősítő jelszavát adja vissza.
     * @return Visszaadja a felhasználó megerősítő jelszavát.
     */
    public String getPasswordfield2() {
        return passwordfield2;
    }
    /**
     * A metódus a felhasználó megerősítő jelszavának beállításáért felelős.
     * @param passwordfield2 a felhasználó megerősítő jelszava 
     */
    public void setPasswordfield2(String passwordfield2) {
        this.passwordfield2 = passwordfield2;
    }
   /**
     *A metódus a felhasználó egyetemi karát adja vissza.
     * @return Visszaadja a felhasználó egyetemi karát.
     */
    public String getKarfield() {
        return karfield;
    }
     /**
     * A metódus a felhasználó egyetemi karának beállításáért felelős.
     * @param karfield felhasználó egyetemi karja 
     */
    public void setKarfield(String karfield) {
        this.karfield = karfield;
    }
   /**
     *A metódus a felhasználó egyetemi szakját adja vissza.
     * @return Visszaadja a felhasználó egyetemi szakját.
     */
    public String getSzakfield() {
        return szakfield;
    }
     /**
     * A metódus a felhasználó egyetemi szakjának beállításáért felelős.
     * @param szakfield felhasználó egyetemi szakja 
     */
    public void setSzakfield(String szakfield) {
        this.szakfield = szakfield;
    }
   /**
     *A metódus a felhasználó évfolyamát adja vissza.
     * @return Visszaadja a felhasználó évfolyamát.
     */
    public String getEvfield() {
        return evfield;
    }
     /**
     * A metódus a felhasználó évfolyamának beállításáért felelős.
     * @param evfield felhasználó évfolyama 
     */
    public void setEvfield(String evfield) {
        this.evfield = evfield;
    }
    
    
}
