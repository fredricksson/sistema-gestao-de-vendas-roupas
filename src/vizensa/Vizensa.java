/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vizensa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mz.vizensa.domain.Caminhos;

/**
 *
 * @author doroteia
 */
public class Vizensa extends Application {
    
 @Override
 public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Caminhos.PaginaInicial));
        Scene scene = new Scene(root);
        stage.setScene(scene);
       // stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.setTitle("");
        stage.centerOnScreen();
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
