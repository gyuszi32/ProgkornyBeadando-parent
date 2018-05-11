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


import static hu.unideb.inf.pkg.progkornybeadando.Database.TempXML.xmlke;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import hu.unideb.inf.pkg.progkornybeadando.Database.Validation;
import hu.unideb.inf.pkg.progkornybeadando.Database.loginUser;
import hu.unideb.inf.pkg.progkornybeadando.Database.loginUserBuilder;
import hu.unideb.inf.pkg.progkornybeadando.Database.loginUserBuilderImpl;
import javax.xml.parsers.ParserConfigurationException;
import org.slf4j.LoggerFactory;

public class LoginController implements Initializable {
    @FXML
    private TextField USER;
    @FXML
    private PasswordField PASSWORD;
    @FXML
    private Label hiba2;
    private Validation valid= Validation.getPeldany();    
    
    private loginUser construct(){
        loginUserBuilder builder=new loginUserBuilderImpl();
        return builder.setLogUser(USER.getText()).setLogPassword(PASSWORD.getText()).build();
    }
    
    
    private static final org.slf4j.Logger logom = LoggerFactory.getLogger(LoginController.class);
    @FXML
    private void kilepes(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/start.fxml"));
            Scene scene = new Scene(root);
            Stage stage= new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            URL vmi = this.getClass().getResource("/styles/Styles.css");
            String css=vmi.toExternalForm();
            scene.getStylesheets().add(css);
            stage.setTitle("Kezdőlap");
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void bejelentkezes(ActionEvent event){
       
       
        
        try {
            valid.setLogadatok(construct());
            xmlke.readLoginXML();
            if(valid.isHibaVan2()==false){
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/succes.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage= new Stage(StageStyle.DECORATED);
                    stage.setScene(scene);
                    URL vmi = this.getClass().getResource("/styles/Styles.css");
                    String css=vmi.toExternalForm();
                    scene.getStylesheets().add(css);
                    stage.setTitle("Gratulálunk!");
                    stage.setResizable(false);
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                    logom.info("Sikeres bejelentkezés!");
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                hiba2.setVisible(true);
                logom.warn("Nincs ilyen felhasználó, vagy nem érvényes jelszó!");
                valid.setHibaVan2(false);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
