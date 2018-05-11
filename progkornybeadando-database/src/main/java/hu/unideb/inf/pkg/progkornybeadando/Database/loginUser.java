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
 * A bejelenkezéshez szükséges, a felhasználó adatait tartalmazó osztály.
 * <p>Tartalmazza a felhasználó bejelentkezéshez beírt nevét és jelszavát.</p>
 */
public class loginUser {
    private String logUser;
    private String logPassword;
    /**
     *A {@link loginUser} osztály konstruktora.
     */
    public loginUser() {
    }
    /**
     *A belejelenkezési felhasználónevet adja vissza.
     * @return Visszaadja a bejelentkezési felhasználónevet.
     */
    public String getLogUser() {
        return logUser;
    }
    /**
     *A bejelentkezési felhasználónév állítható be a metódussal.
     * 
     * @param logUser bejelenkezési név
     */
    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }
    /**
     *A belejelenkezéshez szükséges jelszót adja vissza.
     * @return Visszaadja a bejelentkezési jelszót. 
     */
    public String getLogPassword() {
        return logPassword;
    }
    /**
     *A bejelentkezési jelszó állítható be a metódussal.
     * 
     * @param logPassword bejelenkezési jelszó
     */
    public void setLogPassword(String logPassword) {
        this.logPassword = logPassword;
    }

    
    
}
