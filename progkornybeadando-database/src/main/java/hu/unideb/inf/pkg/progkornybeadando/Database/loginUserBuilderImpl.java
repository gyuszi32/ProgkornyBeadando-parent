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
public class loginUserBuilderImpl implements loginUserBuilder{
    
    private loginUser userke;

    public loginUserBuilderImpl() {
        userke = new loginUser();
    }
    
    @Override
    public loginUserBuilder setLogUser(String loguser) {
        userke.setLogUser(loguser);
        return this;        
    }

    @Override
    public loginUserBuilder setLogPassword(String logpassword) {
        userke.setLogPassword(logpassword);
        return this;
    }

    @Override
    public loginUser build() {
        return userke;
    }
    
}
