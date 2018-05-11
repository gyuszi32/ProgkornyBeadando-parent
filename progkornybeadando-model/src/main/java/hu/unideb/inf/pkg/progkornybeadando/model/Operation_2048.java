package hu.unideb.inf.pkg.progkornybeadando.model;


import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.add;
import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.bejaras;
import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.osszead;
import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.forgatas;


public class Operation_2048 {
    
    
    public static boolean vege1=false;
    public static boolean vege2=false;
    public static boolean vege3=false;
    public static boolean vege4=false;
    
    public static void balra(int aktualisMatrix[][]){
        bejaras(aktualisMatrix);
        bejaras(aktualisMatrix);
        bejaras(aktualisMatrix);
        osszead(aktualisMatrix);
        bejaras(aktualisMatrix);
        bejaras(aktualisMatrix);
        bejaras(aktualisMatrix);
        
    }
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

    

