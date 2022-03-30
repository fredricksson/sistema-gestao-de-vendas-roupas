/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 *
 * @author doroteia
 */
public class DetalhesVendaController {
    
    @FXML Label nomeFuncionario,nomeCliente
            ,dataVenda,horaVenda,contactoCliente,emailCliente,
            totalPago;
    
     @FXML
    public void initialize() {

    }

    @FXML
    public void imprimir(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("ImprimirVendas");
        a.show();

    }
    
}
