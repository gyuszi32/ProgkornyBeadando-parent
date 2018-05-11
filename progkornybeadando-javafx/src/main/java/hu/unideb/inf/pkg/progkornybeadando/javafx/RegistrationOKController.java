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

public class RegistrationOKController implements Initializable {
    @FXML
    private void bejelentkezes(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            Scene scene = new Scene(root);
            Stage stage= new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            URL vmi = this.getClass().getResource("/styles/Styles.css");
            String css=vmi.toExternalForm();
            scene.getStylesheets().add(css);
            stage.setTitle("Bejelentkezés");
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(RegistrationOKController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    @FXML
    private void kilepes(ActionEvent event){
    Platform.exit();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
