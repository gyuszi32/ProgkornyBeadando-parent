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
 * @author Juhász Gyula
 */
public class regUser {
    
    private String userfield;
    private String passwordfield;
    private String passwordfield2;
    private String karfield;
    private String szakfield;
    private String evfield;
    
    public regUser(){
    
    }

    @Override
    public String toString() {
        return "alap{" + "userfield=" + userfield + ", passwordfield=" + passwordfield + ", passwordfield2=" + passwordfield2 + ", karfield=" + karfield + ", szakfield=" + szakfield + ", evfield=" + evfield + '}';
    }

    public String getUserfield() {
        return userfield;
    }

    public void setUserfield(String userfield) {
        this.userfield = userfield;
    }

    public String getPasswordfield() {
        return passwordfield;
        
    }

    public void setPasswordfield(String passwordfield) {
        this.passwordfield = passwordfield;
    }

    public String getPasswordfield2() {
        return passwordfield2;
    }

    public void setPasswordfield2(String passwordfield2) {
        this.passwordfield2 = passwordfield2;
    }

    public String getKarfield() {
        return karfield;
    }

    public void setKarfield(String karfield) {
        this.karfield = karfield;
    }

    public String getSzakfield() {
        return szakfield;
    }

    public void setSzakfield(String szakfield) {
        this.szakfield = szakfield;
    }

    public String getEvfield() {
        return evfield;
    }

    public void setEvfield(String evfield) {
        this.evfield = evfield;
    }
    
    
}
