package hu.unideb.inf.pkg.progkornybeadando.javafx;



import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(final Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/start.fxml"));
        Scene scene = new Scene(root);
        URL vmi = this.getClass().getResource("/styles/Styles.css");
        String css=vmi.toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Kezdőlap");
        
        stage.setResizable(false);
        stage.maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
                stage.setMaximized(false);
        });
        stage.show();
        }
    public static void main(String[] args) {
        launch(args);
    }
}
