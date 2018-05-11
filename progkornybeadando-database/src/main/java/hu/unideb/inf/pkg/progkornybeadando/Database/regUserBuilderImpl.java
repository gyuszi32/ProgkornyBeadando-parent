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
