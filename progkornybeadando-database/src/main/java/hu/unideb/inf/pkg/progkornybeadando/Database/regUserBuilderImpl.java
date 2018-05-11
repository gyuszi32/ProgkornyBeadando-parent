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
public class regUserBuilderImpl implements regUserBuilder {
    private regUser alapocska;

    public regUserBuilderImpl() {
        alapocska= new regUser();
    }
    
    

    @Override
    public regUserBuilder setUserfield(String userfield) {
        alapocska.setUserfield(userfield);
        return this;
    }

    @Override
    public regUserBuilder setPasswordfield(String passwordfield) {
        alapocska.setPasswordfield(passwordfield);
        return this;
    }

    @Override
    public regUserBuilder setPasswordfield2(String passwordfield2) {
        alapocska.setPasswordfield2(passwordfield2);
        return this;
    }

    @Override
    public regUserBuilder setKarfield(String karfield) {
        alapocska.setKarfield(karfield);
        return this;
    }

    @Override
    public regUserBuilder setSzakfield(String szakfield) {
        alapocska.setSzakfield(szakfield);
        return this;
    }

    @Override
    public regUserBuilder setEvfield(String evfield) {
        alapocska.setEvfield(evfield);
        return this;
    }

    @Override
    public regUser build() {
        return alapocska;
    }

}
