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
import javafx.scene.control.Label;
import mz.vizensa.domain.Funcionario;

/**
 *
 * @author doroteia
 */
public class PerfilFuncionarioController {
    
    @FXML
    Label nome, apelido, dataNascimento,
            genero, estadoCivil, tipoFuncionario, nrBi, contactoOpcional, contacto,
            email, cargo, autenticavel, nr_conta, salario, codigo,avenida,quarteirao,rua;
    public static Funcionario funcionario;
    
    @FXML
    public void initialize() {
        nome.setText(funcionario.getFunNome());
        cargo.setText(funcionario.getFunCargo());
        apelido.setText(funcionario.getFunApelido());
        dataNascimento.setText(funcionario.getFunData().toString());
        tipoFuncionario.setText(funcionario.getFunTipoFuncionario());
        genero.setText(funcionario.getFunGenero());
        nrBi.setText(funcionario.getFunNr_bi());
        contacto.setText(funcionario.getContaco1()+"");
        contactoOpcional.setText(funcionario.getContaco2()+"");
        email.setText(funcionario.getFunEmail());
        codigo.setText(funcionario.getFunCodigo()+"");
        salario.setText(funcionario.getFunSalario()+"");
        autenticavel.setText(funcionario.isFunAutenticavel() ? "Auteticavel":"Nao autenticavel");
        nr_conta.setText(funcionario.getFunNr_conta()+"");
         avenida.setText(funcionario.getMorada().getMorAvenida().isEmpty() ? "vazio" : ""+funcionario.getMorada().getMorAvenida());
         quarteirao.setText(funcionario.getMorada().getMorQuarteirao().isEmpty() ? "vazio" : ""+funcionario.getMorada().getMorQuarteirao());
         rua.setText(funcionario.getMorada().getMorRua().isEmpty() ? "vazio" : ""+funcionario.getMorada().getMorRua());
        
    }
    
    @FXML
    public void imprimir(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("ImprimirFuncionario");
        a.show();
    }
    
    public static void setFuncionario(Funcionario funcionario) {
        PerfilFuncionarioController.funcionario = funcionario;
    }
    
}
