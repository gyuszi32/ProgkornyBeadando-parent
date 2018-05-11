package hu.unideb.inf.pkg.progkornybeadando.model;

/*-
 * #%L
 * progkornybeadando-model
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


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.add;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.balra;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.balrahiv;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.felhiv;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.jobbrahiv;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.lehiv;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author Juhász Gyula
 */
public class Operation_2048Test {
    
    @Test
    public void testbalra(){
        int[][] testMatrix={{2,2,2,2},{2,2,2,2},{2,2,2,2},{2,2,2,2}};
        balra(testMatrix);
        int[][] eredmenyMatrix={{4,4,0,0},{4,4,0,0},{4,4,0,0},{4,4,0,0}};
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                assertTrue(testMatrix[i][j]==eredmenyMatrix[i][j]);
            }
        }
    }
    
    @Test
    public void testbalrahiv(){
        int[][] testMatrix={{2,2,2,2},{2,2,2,2},{2,2,2,2},{2,2,2,2}};
        balrahiv(testMatrix);
        int[][] eredmenyMatrix={{4,4,0,0},{4,4,0,0},{4,4,0,0},{4,4,0,0}};
        int darabszam = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(testMatrix[i][j]==2|| testMatrix[i][j]==4){
                    darabszam++;
                }
            }
        }
        add(eredmenyMatrix);
        int eredmeny = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(eredmenyMatrix[i][j]==2|| eredmenyMatrix[i][j]==4){
                    eredmeny++;
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                assertTrue(testMatrix[i][j]==eredmenyMatrix[i][j]);
            }
        }
        assertTrue(darabszam==eredmeny);
        }
    
    @Test
    public void testjobbrahiv(){
        int[][] testMatrix={{2,2,2,2},{2,2,2,2},{2,2,2,2},{2,2,2,2}};
        jobbrahiv(testMatrix);
        int[][] eredmenyMatrix={{0,0,4,4},{0,0,4,4},{0,0,4,4},{0,0,4,4}};
        int darabszam = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(testMatrix[i][j]==2|| testMatrix[i][j]==4){
                    darabszam++;
                }
            }
        }
        add(eredmenyMatrix);
        int eredmeny = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(eredmenyMatrix[i][j]==2|| eredmenyMatrix[i][j]==4){
                    eredmeny++;
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=2;j<4;j++){
                assertTrue(testMatrix[i][j]==eredmenyMatrix[i][j]);
            }
        }
        
        assertTrue(darabszam==eredmeny);
        }
    
    @Test
    public void testlehiv(){
        int[][] testMatrix={{2,2,2,2},{2,2,2,2},{2,2,2,2},{2,2,2,2}};
        lehiv(testMatrix);
        int[][] eredmenyMatrix={{0,0,0,0},{0,0,0,0},{4,4,4,4},{4,4,4,4}};
        int darabszam = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(testMatrix[i][j]==2|| testMatrix[i][j]==4){
                    darabszam++;
                }
            }
        }
        add(eredmenyMatrix);
        int eredmeny = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(eredmenyMatrix[i][j]==2|| eredmenyMatrix[i][j]==4){
                    eredmeny++;
                }
            }
        }
        for(int i=2;i<4;i++){
            for(int j=0;j<4;j++){
                assertTrue(testMatrix[i][j]==eredmenyMatrix[i][j]);
            }
        }
        
        assertTrue(darabszam==eredmeny);
        }
    
    @Test
    public void testfelhiv(){
        int[][] testMatrix={{2,2,2,2},{2,2,2,2},{2,2,2,2},{2,2,2,2}};
        felhiv(testMatrix);
        int[][] eredmenyMatrix={{4,4,4,4},{4,4,4,4},{0,0,0,0},{0,0,0,0}};
        int darabszam = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(testMatrix[i][j]==2|| testMatrix[i][j]==4){
                    darabszam++;
                }
            }
        }
        add(eredmenyMatrix);
        int eredmeny = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(eredmenyMatrix[i][j]==2|| eredmenyMatrix[i][j]==4){
                    eredmeny++;
                }
            }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                assertTrue(testMatrix[i][j]==eredmenyMatrix[i][j]);
            }
        }
        assertTrue(darabszam==eredmeny);
        }
    }
    

