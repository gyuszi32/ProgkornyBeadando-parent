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
public interface loginUserBuilder {
    loginUserBuilder setLogUser(final String loguser);
    loginUserBuilder setLogPassword(final String logpassword);
    
    loginUser build();
}
