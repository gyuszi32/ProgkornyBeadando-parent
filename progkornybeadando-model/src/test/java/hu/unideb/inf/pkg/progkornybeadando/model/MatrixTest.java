package hu.unideb.inf.pkg.progkornybeadando.model;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.add;;
import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.bejaras;
import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.forgatas;
import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.kezdoMatrix;
import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.osszead;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Juhász Gyula
 */
public class MatrixTest {
    

        
    @Test
    public void testkezdoMatrix0(){
    int [][] aktualisMatrix0=kezdoMatrix(8,8);
    assertTrue(aktualisMatrix0.length==8);
    assertTrue(aktualisMatrix0[0].length==8);
    }
    
    @Test
    public void testkezdoMatrix(){
    int darab=0;
    int [][] aktualisMatrix0= kezdoMatrix(8,8);
    for(int i=0;i<8;i++){
        for(int j=0;j<8;j++){
            if(aktualisMatrix0[i][j]!=0){
                darab++;
            }
        }
    }
    assertTrue(darab==2);
    }

    @Test
    public void testadd(){
        int[][] testMatrix = new int[4][4];
        int nullak=0;
        for(int i = 0;i<4;i++){
            for(int j= 0;j<4;j++){                
                if(testMatrix[i][j] == 0 ){
                    nullak++;
                }
            }
        }
        assertTrue(nullak==16);
        add(testMatrix);
        int nullak2=0;
        for(int i = 0;i<4;i++){
            for(int j= 0;j<4;j++){                
                if(testMatrix[i][j] == 0 ){
                    nullak2++;
                }
            }
        }
        assertTrue(nullak2==15);
    }
    
    @Test
    public void testbejaras(){
        int[][] testMatrix = new int[4][4];
        int nullak=0;
        for(int i = 0;i<4;i++){
            for(int j= 0;j<4;j++){                
                if(testMatrix[i][j] == 0 ){
                    nullak++;
                }
            }
        }
        assertTrue(nullak==16);
        bejaras(testMatrix);
        int nullak2=0;
        for(int i = 0;i<4;i++){
            for(int j= 0;j<4;j++){                
                if(testMatrix[i][j] == 0 ){
                    nullak2++;
                }
            }
        }
        assertTrue(nullak2==nullak);        
    }
    
     
    @Test
    public void testosszead(){
       int testMatrix[][] = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        {13, 14, 16, 16 }};
       osszead(testMatrix);
       int eredmenyMatrix[][]={{1,2,3,4},
                                {5,6,7,8},
                                {9,10,11,12},
                                {13,14,32,0}};
       for(int i=0;i<4;i++){
           for(int j=0;j<4;j++){
               assertTrue(testMatrix[i][j]==eredmenyMatrix[i][j]);
           }
       }
           }
    
    @Test
    public void testforgatas(){
           int testMatrix[][] = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        {13, 14, 15, 16 }};
           forgatas(testMatrix);
           
           int eredmenyMatrix[][]={{4,8,12,16},
                                   {3,7,11,15},
                                   {2,6,10,14},
                                   {1,5,9,13}};
           for(int i=0;i<4;i++){
           for(int j=0;j<4;j++){
               assertTrue(testMatrix[i][j]==eredmenyMatrix[i][j]);
           }
       }
    }
}
