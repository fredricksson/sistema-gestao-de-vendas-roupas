/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author doroteia
 */
public class EditarFuncionarioController {
   
    @FXML ComboBox combo_tipo_funcionario;
    @FXML ComboBox combo_genero;
    @FXML ComboBox combo_estado_civil;
    @FXML TextField contacto_opcional;
    @FXML TextField nome;
    @FXML TextField apelido;
    @FXML TextField nr_bi;
    @FXML TextField contacto;
    @FXML TextField email;
    @FXML TextField cargo;
    @FXML TextField salario;
    @FXML TextField nr_conta;
    @FXML TextField banco;
    @FXML DatePicker data_nacimento;
    @FXML Button salvar;
    @FXML Label titulo;
    
    @FXML public void initialize(){
        titulo.setText("Alterar dados de Funcionario");
        salvar.setText("Salvar alteracoes");
    }
    
    @FXML void salvar(ActionEvent event){
    
    }
}
