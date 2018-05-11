/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.pkg.progkornybeadando.Database;
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
