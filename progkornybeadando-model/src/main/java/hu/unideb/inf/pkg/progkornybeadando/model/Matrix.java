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


import java.util.ArrayList;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * A mátrixok reprezentálására szolgáló osztály. 
 */
public class Matrix {
    /**
     * A {@link Matrix} osztály konstruktora.
     **/
    public Matrix() {
    }
    /**
     * A {@link Matrix} osztály loggere.
     */
    private static final Logger logom = LoggerFactory.getLogger(Matrix.class);
    
     /**
      * Visszaad egy matrixot a {@link Matrix} osztályból 2 darab
      * tetszőleges értékkel.      
      * 
     * @param n a mátrix sorainak száma
     * @param m a mátrix oszlopainak száma
     * @return Visszaad egy kezdőmátrixot.
      */
    public static int[][] kezdoMatrix(int n, int m) {
        int[][] aktualisMatrix = new int[n][m];
        add(aktualisMatrix);
        add(aktualisMatrix);
            return aktualisMatrix ;
    }
    /** 
     * Az <code>aktualisMatrix</code> nulla elemei közül, egy
     * tetszőleges nulla érték helyére egy 2-es vagy 4-es érték
     * kerül.
     * <p>Ha az oszlop és a sor indexe újból tetszőlegesen ki lett
     * választva, akkor addig választ ki tetszőleges számokat, amíg
     * nem lesz az egyik különböző.
     * </p>
     * 
     * 
     * @param aktualisMatrix egy egész számokat tartalmazó mátrix
     **/
    public static void add(int aktualisMatrix[][]){
        int nullak = 0;
        ArrayList<Number> indexsor = new ArrayList<>();
        ArrayList<Number> indexoszlop = new ArrayList<>();
        for(int i = 0;i<aktualisMatrix.length;i++){
            for(int j= 0;j<aktualisMatrix.length;j++){
                
                if(aktualisMatrix[i][j] == 0 ){
                    nullak++;
                    indexsor.add(i);
                    indexoszlop.add(j);
                }
            }
        }
        if(nullak!=0){ 
            Random randomGenerator = new Random();
            int index = randomGenerator.nextInt(indexsor.size());
            int valasztottindexsor = (int) indexsor.get(index);
            int valasztottindexoszlop = (int) indexoszlop.get(index);
            while(aktualisMatrix[valasztottindexsor][valasztottindexoszlop]==2 || aktualisMatrix[valasztottindexsor][valasztottindexoszlop]==4 ){
                index = randomGenerator.nextInt(indexsor.size());
                valasztottindexsor=(int) indexsor.get(index);
                valasztottindexoszlop = (int) indexoszlop.get(index);
            }
            aktualisMatrix[valasztottindexsor][valasztottindexoszlop]=Math.random() > 0.2 ? 2 : 4;
        }else{
            logom.warn("Betelt a mátrix!");
        }
    };
    /**
     *Az <code>aktualisMatrix</code> nem nulla elemei egyesével 
     * a sorok végére kerülnek, míg az egész számok
     * a sor elejére kerülnek.
     *
     *
     *
     * @param aktualisMatrix egy egész számokat tartalmazó mátrix
     **/
    public static void bejaras(int aktualisMatrix[][]){
        for(int k=aktualisMatrix.length-1;k>=0;k--){
            for(int l=aktualisMatrix.length-1;l>=0;l--){
                if(l!=0 && aktualisMatrix[k][l]!=0 && aktualisMatrix[k][l-1]==0){
                    aktualisMatrix[k][l-1]+=aktualisMatrix[k][l];
                    aktualisMatrix[k][l]=0;
                }
            }
        }
    }
    /** 
     * Az <code>aktualisMatrix</code>-ban az egymás mellett lévő
     * azonos elemeket összeadja.
     * <p>
     * Az összeadás során a kisebb sorindexű elem helyére kerül
     * az összeg, míg a másik indexű elem értéke kinullázódik
     * </p>
     *
     *
     *
     * @param aktualisMatrix egy egész számokat tartalmazó mátrix
     **/
    public static void osszead(int aktualisMatrix[][]){
        for (int[] aktualisMatrix1 : aktualisMatrix) {
            for (int l = 0; l<aktualisMatrix.length; l++) {
                if (l!=aktualisMatrix.length-1 && aktualisMatrix1[l] == aktualisMatrix1[l+1]) {
                    aktualisMatrix1[l] += aktualisMatrix1[l+1];
                    aktualisMatrix1[l+1] = 0;
                }
            }
        }
    }
    
   /**
    * Az <code>aktualisMatrix</code>-on a matematikai transzponáció
    * hajtódik végre.
    * <p>
    * Azaz, a mátrix transzponálása során, sorainak és oszlopainak
    * a felcserélése történik. </p>
    * 
    * 
    *@param aktualisMatrix egy egész számokat tartalmazó mátrix
    **/
    private static void transzponalt(int aktualisMatrix[][] ) {
        for(int i = 0; i < aktualisMatrix.length; i++){
            for(int j = i+1; j < aktualisMatrix.length ; j++){
                int temp = aktualisMatrix[i][j];
                aktualisMatrix[i][j] = aktualisMatrix[j][i];
                aktualisMatrix[j][i] = temp;
            }
        }
    }
    /**
     *Az <code>aktualisMatrix</code>-t középen elforgatjuk.
     *<p>
     * Azaz a mátrix sorait egyenlően szétosztja,
     * és az azonos távolságban lévő elemeit felcseréli.</p>
     * 
     * @param aktualisMatrix egy egész számokat tartalmazó mátrix
     **/
    private static void kozepforgat(int aktualisMatrix[][]) {
        int hossz = aktualisMatrix.length ;
        for(int i = 0; i < hossz/2; i++){
            for(int j = 0;j < hossz; j++){
                int temp = aktualisMatrix[i][j];
                aktualisMatrix[i][j] = aktualisMatrix[hossz-1 -i][j];
                aktualisMatrix[hossz -1 -i][j] = temp;
            }
        }
    }
    /**
     *Az <code>aktualisMatrix</code>-on matematikai forgatást végez.
     *
     *
     * @param aktualisMatrix egy egész számokat tartalmazó mátrix
     **/
    public static void forgatas(int aktualisMatrix[][] ){
        if(aktualisMatrix == null)
            return;
        if(aktualisMatrix.length != aktualisMatrix[0].length)
            return;
        transzponalt(aktualisMatrix);
        kozepforgat(aktualisMatrix);
    }
}     

