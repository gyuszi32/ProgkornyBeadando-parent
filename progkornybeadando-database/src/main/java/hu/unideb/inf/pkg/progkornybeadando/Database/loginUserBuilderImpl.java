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
 *A {@link loginUserBuilderImpl} osztály tartalmazza a bejelentkezés
 * során létrejövő adatok lekérdezéseit és beállításait.
 */
public class loginUserBuilderImpl implements loginUserBuilder{
    /**
     *Egy loginUser objektum.
     */
    private loginUser userke;
    /**
     *Az {@link loginUserBuilder} konstruktora.
     */
    public loginUserBuilderImpl() {
        userke = new loginUser();
    }
     /**
     *A metódus segítségével be tudjuk állítani a bejelentkezéshez
     * szükséges felhasználói nevet.
     * @param loguser bejelentkezéshez szükséges név
     * @return Visszaad egy loginUserBuilder objektumot
     */
    @Override
    public loginUserBuilder setLogUser(String loguser) {
        userke.setLogUser(loguser);
        return this;        
    }
    /**
     *A metódus segítségével be tudjuk majd állítani a bejelentkezéshez
     * szükséges jelszót.
     * @param logpassword bejelentkezéshez szükséges jelszó
     * @return Visszaad egy loginUserBuilder objektumot
     */
    @Override
    public loginUserBuilder setLogPassword(String logpassword) {
        userke.setLogPassword(logpassword);
        return this;
    }
    /**
     *A loginUserBuilder végrehajtásáért felelős metódus.
     *@return Visszaad egy loginUser objektumot.
     */
    @Override
    public loginUser build() {
        return userke;
    }
    
}
