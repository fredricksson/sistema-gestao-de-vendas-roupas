/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

/**
 *
 * @author doroteia
 */
public class SalarioController {
    
    
    @FXML
    ComboBox combo_mes;
    
    
     @FXML public void initialize(){
       combo_mes.getItems().add("Janeiro");
       combo_mes.getItems().add("fevereiro");
       combo_mes.getItems().add("Marco");
       combo_mes.getItems().add("Maio");
       combo_mes.getItems().add("Junho");
       combo_mes.getItems().add("Julho");
       combo_mes.getItems().add("Agosto");
       combo_mes.getItems().add("Setembro");
       combo_mes.getItems().add("Outubro");
       combo_mes.getItems().add("Novembro");
       combo_mes.getItems().add("Dezembro");
    }
    
     @FXML public void confirmarPagamento(ActionEvent event){
           Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("ImprimirVendas");
        a.show();
     }
    
}
