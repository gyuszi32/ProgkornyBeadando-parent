package hu.unideb.inf.pkg.progkornybeadando.model;

import java.util.ArrayList;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Matrix {
    private static final Logger logom = LoggerFactory.getLogger(Matrix.class);
     
    public static int[][] kezdoMatrix(int n, int m) {
        int[][] aktualisMatrix = new int[n][m];
        add(aktualisMatrix);
        add(aktualisMatrix);
            return aktualisMatrix ;
    }
    
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
    
   
    private static void transzponalt(int aktualisMatrix[][] ) {
        for(int i = 0; i < aktualisMatrix.length; i++){
            for(int j = i+1; j < aktualisMatrix.length ; j++){
                int temp = aktualisMatrix[i][j];
                aktualisMatrix[i][j] = aktualisMatrix[j][i];
                aktualisMatrix[j][i] = temp;
            }
        }
    }

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

    public static void forgatas(int aktualisMatrix[][] ){
        if(aktualisMatrix == null)
            return;
        if(aktualisMatrix.length != aktualisMatrix[0].length)
            return;
        transzponalt(aktualisMatrix);
        kozepforgat(aktualisMatrix);
    }
}     

