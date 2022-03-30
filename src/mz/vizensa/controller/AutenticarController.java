/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import mz.vizensa.dao.FuncionarioDAO;
import mz.vizensa.domain.Funcionario;

/**
 *
 * @author doroteia
 */
public class AutenticarController {
    
    FuncionarioDAO fd = new FuncionarioDAO();
    @FXML
    ComboBox combo_nomeFuncionario;
   

    @FXML
    public void initialize() {
      List<Funcionario> funcionarios = fd.BuscarFuncionarios();
      
        for (Funcionario funcionario : funcionarios) {
            combo_nomeFuncionario.getItems().add(funcionario.getFunNome()+" "+funcionario.getFunCodigo());   
        }
    }

    @FXML
    public void autenticar(ActionEvent event) {
             Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("autenticar");
        a.show();
    }

    @FXML
    public void desautenticar(ActionEvent event) {
                 Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("desautenticar");
        a.show();
    }
}
