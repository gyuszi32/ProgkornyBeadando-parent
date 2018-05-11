package hu.unideb.inf.pkg.progkornybeadando.javafx;

/*-
 * #%L
 * progkornybeadando-javafx
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
/**
 *A {@link SuccesController} felelős a menü grafikus felületéért.
 */
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
