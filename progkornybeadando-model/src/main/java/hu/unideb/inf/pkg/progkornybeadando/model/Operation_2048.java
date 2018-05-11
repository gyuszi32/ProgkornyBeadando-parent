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



import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.add;
import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.bejaras;
import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.osszead;
import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.forgatas;

/**
 * 
 * A 2048 műveleteit reprezentáló osztály.
 */
public class Operation_2048 {

    /**
     *A {@code Operaiton_2048} osztály konstruktora.
     **/
    public Operation_2048() {
    }
    
    /**
     *A <code>vege1</code> változó az baloldali
     * mozgás lehetőségét jelzi.
     * <p>
     * Ha lehetséges baloldali összeadás a játék során,
     * akkor hamis értéket kap, ellenkező esetben
     * igaz értéket kap.
     * </p>
     **/
    public static boolean vege1=false;
    /**
     *A <code>vege2</code> változó a jobboldali
     * mozgás lehetőségét jelzi.
     * <p>
     * Ha lehetséges jobboldali összeadás a játék során,
     * akkor hamis értéket kap, ellenkező esetben
     * igaz értéket kap.
     * </p>
     **/
    public static boolean vege2=false;
    /**
     *A <code>vege3</code> változó a lefele
     * mozgás lehetőségét jelzi.
     * <p>
     * Ha lehetséges lefelé összeadni a játék során,
     * akkor hamis értéket kap, ellenkező esetben
     * igaz értéket kap.
     * </p>
     **/
    public static boolean vege3=false;
    /**
     *A <code>vege4</code> változó a felfelé
     * mozgás lehetőségét jelzi.
     * <p>
     * Ha lehetséges felfelé történő összeadás a játék során,
     * akkor hamis értéket kap, ellenkező esetben
     * igaz értéket kap.
     * </p>
     **/
    public static boolean vege4=false;
    
    /**
     * A metódus az <code>aktualisMatrix</code> elemeinek
     * összeadására szolgál.
     * <p>
     * Az összeadás során a bal oldalra kerülnek a
     * mátrixban az értékes elemek.
     * </p>
     *
     * 
     * @param aktualisMatrix egész számokat tartalmazó mátrix
     **/
    public static void balra(int aktualisMatrix[][]){
        bejaras(aktualisMatrix);
        bejaras(aktualisMatrix);
        bejaras(aktualisMatrix);
        osszead(aktualisMatrix);
        bejaras(aktualisMatrix);
        bejaras(aktualisMatrix);
        bejaras(aktualisMatrix);
        
    }
        /**
     * A metódus az <code>aktualisMatrix</code> elemeit
     * összeadja, majd egy új nem nulla elemet ad hozzá.
     * 
     * <p>
     * Az összeadás során a bal oldalra kerülnek a
     * mátrixban az értékes elemek.
     * </p>
     *
     * 
     * @param aktualisMatrix egész számokat tartalmazó mátrix
     **/
    public static void balrahiv(int aktualisMatrix[][]){
        int[][] seged = new int[aktualisMatrix.length][];
        for(int i = 0; i < aktualisMatrix.length; i++){
            seged[i] = new int[aktualisMatrix[i].length];
            System.arraycopy(aktualisMatrix[i], 0, seged[i], 0, aktualisMatrix[i].length);
        }
        balra(aktualisMatrix);
        boolean azonosak=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(aktualisMatrix[i][j]!=seged[i][j]){
                    azonosak=false;
                }
            }
        }
        if(azonosak){
            vege1=true;
        }else{
            add(aktualisMatrix);
            vege1=false;
            vege2=false;
            vege3=false;
            vege4=false;        
        }
}
     /**
     * A metódus az <code>aktualisMatrix</code> elemeit
     * összeadja, majd egy új nem nulla elemet ad hozzá.
     * 
     * <p>
     * Az összeadás során a jobb oldalra kerülnek a
     * mátrixban az értékes elemek.
     * </p>
     *
     * 
     * @param aktualisMatrix egész számokat tartalmazó mátrix
     **/
    public static void jobbrahiv(int aktualisMatrix[][]){
        int[][] seged = new int[aktualisMatrix.length][];
        for(int i = 0; i < aktualisMatrix.length; i++){
            seged[i] = new int[aktualisMatrix[i].length];
            System.arraycopy(aktualisMatrix[i], 0, seged[i], 0, aktualisMatrix[i].length);
        }
        forgatas(aktualisMatrix);
        forgatas(aktualisMatrix);
        balra(aktualisMatrix);
        forgatas(aktualisMatrix);
        forgatas(aktualisMatrix);
        boolean azonosak=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(aktualisMatrix[i][j]!=seged[i][j]){
                    azonosak=false;
                }
            }
        }
        if(azonosak){
            vege2=true;
        }else{
            add(aktualisMatrix);
            vege1=false;
            vege2=false;
            vege3=false;
            vege4=false;
        }
    }
     /**
     * A metódus az <code>aktualisMatrix</code> elemeit
     * összeadja, majd egy új nem nulla elemet ad hozzá.
     * 
     * <p>
     * Az összeadás során az elemek a alsó üres sorokba kerülnek. 
     * </p>
     *
     * 
     * @param aktualisMatrix egész számokat tartalmazó mátrix
     */
    public static void lehiv(int aktualisMatrix[][]){
        int[][] seged = new int[aktualisMatrix.length][];
        for(int i = 0; i < aktualisMatrix.length; i++){
            seged[i] = new int[aktualisMatrix[i].length];
            System.arraycopy(aktualisMatrix[i], 0, seged[i], 0, aktualisMatrix[i].length);
        }
        forgatas(aktualisMatrix);
        forgatas(aktualisMatrix);
        forgatas(aktualisMatrix);
        balra(aktualisMatrix);
        forgatas(aktualisMatrix);
        boolean azonosak=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(aktualisMatrix[i][j]!=seged[i][j]){
                    azonosak=false;
                }
            }
        }
        if(azonosak){
            vege3=true;
        }else{
            add(aktualisMatrix);
            vege1=false;
            vege2=false;
            vege3=false;
            vege4=false;
        }
    }
         /**
     * A metódus az <code>aktualisMatrix</code> elemeit
     * összeadja, majd egy új nem nulla elemet ad hozzá.
     * 
     * <p>
     * Az összeadás során az elemek a felső üres sorokba kerülnek. 
     * </p>
     *
     * 
     * @param aktualisMatrix egész számokat tartalmazó mátrix
     */
    public static void felhiv(int aktualisMatrix[][]){
        int[][] seged = new int[aktualisMatrix.length][];
        for(int i = 0; i < aktualisMatrix.length; i++){
            seged[i] = new int[aktualisMatrix[i].length];
            System.arraycopy(aktualisMatrix[i], 0, seged[i], 0, aktualisMatrix[i].length);
        }    
        forgatas(aktualisMatrix);
        balra(aktualisMatrix);
        forgatas(aktualisMatrix);
        forgatas(aktualisMatrix);
        forgatas(aktualisMatrix);
        boolean azonosak=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(aktualisMatrix[i][j]!=seged[i][j]){
                    azonosak=false;
                }
            }
        }
        if(azonosak){
            vege4=true;
        }else{
            add(aktualisMatrix);
            vege1=false;
            vege2=false;
            vege3=false;
            vege4=false;
        }
    }
}

    

