/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mz.vizensa.domain.Caminhos;

/**
 *
 * @author doroteia
 */
public class LoginController {
    
    
    @FXML public void initialize(){
    
    }
    
    @FXML public void onClick(ActionEvent event) throws IOException{
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource(Caminhos.PaginaPrincipal));
            Parent home_page_parent = loader.load();

            //InitialController controller = loader.getController();
           // controller.setUser(user);
            
            Scene home_page_scene = new Scene(home_page_parent);
            Stage main_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            main_stage.close();
            main_stage.setScene(home_page_scene);
            main_stage.setTitle("Vizensa");
            main_stage.setResizable(true);
            main_stage.setMaximized(true);
            main_stage.show();
          
            
    
    }
    
    
    
}
