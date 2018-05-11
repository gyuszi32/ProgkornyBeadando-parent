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
 *
 * A {@link regUserBuilder} absztrakt interfész objektum létrehozásához.
 */
public interface regUserBuilder {
        /**
     * A metódus a felhasználó nevének beállításáért felelős.
     * @param userfield a felhasználó neve
     * @return Visszaad egy regUserBuilder objektumot. 
     */
    regUserBuilder setUserfield(final String userfield);
        /**
     * A metódus a felhasználó jelszavának beállításáért felelős.
     * @param passwordfield a felhasználó jelszava
     * @return Visszaad egy regUserBuilder objektumot. 
     */
    regUserBuilder setPasswordfield(final String passwordfield);
        /**
     * A metódus a felhasználó megerősítő jelszavának beállításáért felelős.
     * @param passwordfield2 a felhasználó megerősítő jelszava
     * @return Visszaad egy regUserBuilder objektumot. 
     */
    regUserBuilder setPasswordfield2(final String passwordfield2);
         /**
     * A metódus a felhasználó egyetemi karának beállításáért felelős.
     * @param karfield felhasználó egyetemi karja
     * @return Visszaad egy regUserBuilder objektumot. 
     */
    regUserBuilder setKarfield(final String karfield);
         /**
     * A metódus a felhasználó egyetemi szakjának beállításáért felelős.
     * @param szakfield felhasználó egyetemi szakja
     * @return Visszaad egy regUserBuilder objektumot. 
     */
    regUserBuilder setSzakfield(final String szakfield);
         /**
     * A metódus a felhasználó évfolyamának beállításáért felelős.
     * @param evfield felhasználó évfolyama
     * @return Visszaad egy regUserBuilder objektumot. 
     *
     */
    regUserBuilder setEvfield(final String evfield);
    
    /**
     * A regUserBuilder végrehajtásáért felelős metódus.
     *@return Visszaad egy regUser objektumot.
     */
    regUser build();

}
