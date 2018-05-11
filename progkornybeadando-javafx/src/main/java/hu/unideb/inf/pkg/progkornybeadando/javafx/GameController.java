package hu.unideb.inf.pkg.progkornybeadando.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.slf4j.LoggerFactory;
import static hu.unideb.inf.pkg.progkornybeadando.model.Matrix.kezdoMatrix;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.balrahiv;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.felhiv;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.jobbrahiv;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.lehiv;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.vege1;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.vege2;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.vege3;
import static hu.unideb.inf.pkg.progkornybeadando.model.Operation_2048.vege4;
import javafx.stage.StageStyle;

public class GameController implements Initializable {

    @FXML
    private Label label0;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;
    @FXML
    private Label label9;
    @FXML
    private Label label10;
    @FXML
    private Label label11;
    @FXML
    private Label label12;
    @FXML
    private Label label13;
    @FXML
    private Label label14;
    @FXML
    private Label label15;
    
 
    public int aktualisMatrix[][]=kezdoMatrix(4,4);
    ArrayList<Label> labels=new ArrayList<>();
    private static final org.slf4j.Logger logom = LoggerFactory.getLogger(GameController.class);
    private void labelhozzadas(){
        for(int i=0;i<16;i++){
                labels.add(label0);
                labels.add(label1);
                labels.add(label2);
                labels.add(label3);
                labels.add(label4);
                labels.add(label5);
                labels.add(label6);
                labels.add(label7);
                labels.add(label8);
                labels.add(label9);
                labels.add(label10);
                labels.add(label11);
                labels.add(label12);
                labels.add(label13);
                labels.add(label14);
                labels.add(label15);       
        }
    }
    private void konfiguracio(){
        label0.setText("" + aktualisMatrix[0][0] + "");
        label1.setText("" + aktualisMatrix[0][1] + "");
        label2.setText("" + aktualisMatrix[0][2] + "");
        label3.setText("" + aktualisMatrix[0][3] + "");
        label4.setText("" + aktualisMatrix[1][0] + "");
        label5.setText("" + aktualisMatrix[1][1] + "");
        label6.setText("" + aktualisMatrix[1][2] + "");
        label7.setText("" + aktualisMatrix[1][3] + "");
        label8.setText("" + aktualisMatrix[2][0] + "");
        label9.setText("" + aktualisMatrix[2][1] + "");
        label10.setText("" + aktualisMatrix[2][2] + "");
        label11.setText("" + aktualisMatrix[2][3] + "");
        label12.setText("" + aktualisMatrix[3][0] + "");
        label13.setText("" + aktualisMatrix[3][1] + "");
        label14.setText("" + aktualisMatrix[3][2] + "");
        label15.setText("" + aktualisMatrix[3][3] + "");
        labelhatter();
        jatekVege();
        vesztes();
        
     }
    private void labelhatter(){
        for(int i=0;i<16;i++){
                if(null == labels.get(i).getText()){
                    labels.get(i).setStyle("-fx-background-color: #ffffff");
                }else switch (labels.get(i).getText()) {
                case "2":
                    labels.get(i).setStyle("-fx-background-color: #ebf5fb ");
                    break;
                case "4":
                    labels.get(i).setStyle("-fx-background-color: #d6eaf8");
                    break;
                case "8":
                    labels.get(i).setStyle("-fx-background-color: #aed6f1");
                    break;
                case "16":
                    labels.get(i).setStyle("-fx-background-color:  #85c1e9 ");
                    break;
                case "32":
                    labels.get(i).setStyle("-fx-background-color: #5dade2 ");
                    break;
                case "64":
                    labels.get(i).setStyle("-fx-background-color:  #3498db ");
                    break;
                case "128":
                    labels.get(i).setStyle("-fx-background-color: #2e86c1 ");
                    break;
                case "256":
                    labels.get(i).setStyle("-fx-background-color: #2874a6 ");
                    break;
                case "512":
                    labels.get(i).setStyle("-fx-background-color: #d61111");
                    break;
                case "1024":
                    labels.get(i).setStyle("-fx-background-color: #1b4f72 ");
                    break;
                case "2048":
                    labels.get(i).setStyle("-fx-background-color: #f39c12");
                    break;
                default:
                    labels.get(i).setStyle("-fx-background-color: #ffffff");
                    break;
            }
        }
    }
    @FXML
    private void fel(ActionEvent e){
        felhiv(aktualisMatrix);
        konfiguracio();
      }
    @FXML
    private void le(ActionEvent e){
        lehiv(aktualisMatrix);
        konfiguracio();
        
    }
    @FXML
    private void balra(ActionEvent e){
        balrahiv(aktualisMatrix);
        konfiguracio();
    }
    @FXML
    private void jobbra(ActionEvent e){
        jobbrahiv(aktualisMatrix);
        konfiguracio();
    }
    @FXML 
    private void gombNyomas(KeyEvent event){
            switch (event.getCode()) {
            case LEFT:balrahiv(aktualisMatrix);
                konfiguracio();
                break;
            case RIGHT:jobbrahiv(aktualisMatrix);
                konfiguracio();
                break;
            case UP:felhiv(aktualisMatrix);
                konfiguracio();
                break;
            case DOWN:lehiv(aktualisMatrix);
                konfiguracio();
                break;
            default:
                break;
            }
        }
    @FXML
    private void jatekVege(){
            for(int i=0;i<16;i++){
            if(labels.get(i).getText().equals("2048")){
                try {
                    logom.info("Játék vége: Ön nyert!");
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/end.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) label0.getScene().getWindow();
                    stage.setScene(scene);
                    URL vmi = this.getClass().getResource("/styles/Styles.css");
                    String css=vmi.toExternalForm();
                    scene.getStylesheets().add(css);

                    stage.setTitle("Ön nyert!");
                    stage.setResizable(false);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
            }
        }
    }
    @FXML
    private void vesztes(){
        if(vege1==true && vege2==true && vege3==true &&vege4==true){
            logom.info("Játék vége: Ön vesztett!");
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/loseend.fxml"));
                Scene scene = new Scene(root);
                Stage stage= new Stage(StageStyle.DECORATED);
                stage.setScene(scene);
                URL vmi = this.getClass().getResource("/styles/Styles.css");
                String css=vmi.toExternalForm();
                scene.getStylesheets().add(css);
                stage.setTitle("Ön vesztett!");
                stage.setResizable(false);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
}
            
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelhozzadas();    
        konfiguracio();        
        
    }
}
        
