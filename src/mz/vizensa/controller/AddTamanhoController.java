/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author doroteia
 */
public class AddTamanhoController {
    @FXML TextField tamanho;
    @FXML AnchorPane pane;
    public static String tamanho2="";
    
    @FXML public void addTamanho(ActionEvent event){
        tamanho2 +=tamanho.getText()+",";
        tamanho.setText("");
        
    }
}
