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
public interface regUserBuilder {
    regUserBuilder setUserfield(final String userfield);
    regUserBuilder setPasswordfield(final String passwordfield);
    regUserBuilder setPasswordfield2(final String passwordfield2);
    regUserBuilder setKarfield(final String karfield);
    regUserBuilder setSzakfield(final String szakfield);
    regUserBuilder setEvfield(final String evfield);
    
    regUser build();

}
