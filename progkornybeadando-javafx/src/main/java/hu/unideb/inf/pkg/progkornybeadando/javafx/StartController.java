package hu.unideb.inf.pkg.progkornybeadando.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class StartController implements Initializable {
    
    
    @FXML
    private void bejelentkezes(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            Scene scene = new Scene(root);
            Stage stage= new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.setTitle("Bejelentkezés");
            URL vmi = this.getClass().getResource("/styles/Styles.css");
            String css=vmi.toExternalForm();
            scene.getStylesheets().add(css);
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(StartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    @FXML
    private void regisztracio(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/registration.fxml"));
            Scene scene = new Scene(root);
            Stage stage= new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            URL vmi = this.getClass().getResource("/styles/Styles.css");
            String css=vmi.toExternalForm();
            scene.getStylesheets().add(css);
            stage.setTitle("Regisztráció");
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(StartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
