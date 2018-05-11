package hu.unideb.inf.pkg.progkornybeadando.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.slf4j.LoggerFactory;

public class SuccesController implements Initializable {

    private static final org.slf4j.Logger logom = LoggerFactory.getLogger(SuccesController.class);
    @FXML
    private void ujjatek(ActionEvent event){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/game.fxml"));
            Scene scene = new Scene(root);
            Stage stage= new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.setTitle("Menü");
            URL vmi = this.getClass().getResource("/styles/Styles.css");
            String css=vmi.toExternalForm();
            scene.getStylesheets().add(css);
            stage.show();
            stage.setResizable(false);
            ((Node)(event.getSource())).getScene().getWindow().hide();
            logom.info("Kezdődjön a játék!");
        } catch (IOException ex) {
            Logger.getLogger(SuccesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void szabaly(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/rules.fxml"));
            Scene scene = new Scene(root);
            Stage stage= new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.setTitle("Szabály");
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SuccesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void kilepes(ActionEvent event){
        Platform.exit();
        logom.info("Sikeres kilépés!");
    }
    @FXML
    private void vissza(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/succes.fxml"));
            Scene scene = new Scene(root);
            Stage stage= new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.setTitle("Menu");
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SuccesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
