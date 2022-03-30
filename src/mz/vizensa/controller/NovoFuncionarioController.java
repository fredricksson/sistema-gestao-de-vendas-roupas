/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import java.text.ParseException;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import mz.vizensa.domain.Funcionario;
import mz.vizensa.domain.Morada;
import mz.vizensa.factory.Help;

/**
 *
 * @author doroteia
 */
public class NovoFuncionarioController {

    @FXML
    ComboBox combo_tipo_funcionario;
    @FXML
    ComboBox combo_genero;
    @FXML
    ComboBox combo_estado_civil;
    @FXML
    TextField contacto_opcional;
    @FXML
    TextField nome;
    @FXML
    TextField apelido;
    @FXML
    TextField nr_bi;
    @FXML
    TextField contacto;
    @FXML
    TextField email;
    @FXML
    TextField cargo;
    @FXML
    TextField salario;
    @FXML
    TextField nr_conta;
    @FXML
    TextField banco;
    @FXML
    TextField autenticavel, avenida, quarteirao, rua;
    @FXML
    DatePicker data_nacimento;
    @FXML
    Button salvar;

    @FXML
    public void initialize() {
        combo_genero.getItems().add("Masculino");
        combo_genero.getItems().add("Femenino");
        combo_tipo_funcionario.getItems().add("Empregado");
        combo_tipo_funcionario.getItems().add("Gerente");
        combo_estado_civil.getItems().add("Solteiro/a");
        combo_estado_civil.getItems().add("Casado/a");
        combo_estado_civil.getItems().add("Divorciado/a");
    }

    @FXML
    void salvar(ActionEvent event) throws ParseException {
        Alert a = new Alert(Alert.AlertType.ERROR);
        boolean erro = false;
        if (nome.getText().isEmpty()) {
            a.setContentText("o campo de nome esta vazio!");
            a.show();
            erro = true;
        } else if (apelido.getText().isEmpty()) {
            a.setContentText("o campo apelido esta vazio!");
            a.show();
            erro = true;
        } else if (nr_bi.getText().isEmpty()) {
            a.setContentText("o campo Nr de B.I esta vazio!");
            a.show();
            erro = true;

        } else if (combo_tipo_funcionario.getSelectionModel().isEmpty()) {

            a.setContentText("o campo Tipo de funcionario nao foi seleccionado");
            a.show();
            erro = true;
        } else if (combo_genero.getSelectionModel().isEmpty()) {
            a.setContentText("o campo Genero nao foi seleccionado");
            a.show();
            erro = true;

        } else if (combo_estado_civil.getSelectionModel().isEmpty()) {
            a.setContentText("o campo estado civil nao foi seleccionado");
            a.show();
            erro = true;
        } else if (data_nacimento.getEditor().getText().isEmpty()) {
            a.setContentText("o campo data nascimento esta vazio!");
            a.show();
            erro = true;
        }
        try {
            if (erro != true) {
                Date data = Help.date_from_string(data_nacimento.getEditor().getText());

                String tipoFuncionario = combo_tipo_funcionario.getSelectionModel().getSelectedItem().toString();
                String genero = combo_genero.getSelectionModel().getSelectedItem().toString();
                String estadoCivil = combo_estado_civil.getSelectionModel().getSelectedItem().toString();
                long nr_conta = Long.parseLong(this.nr_conta.getText());
                float salario = Float.parseFloat(this.salario.getText());

                if (contacto.getText().length() == 9) {
                    if (contacto_opcional.getText().length() == 9) {
                        int contacto = Integer.parseInt(this.contacto.getText());
                        int contacto2 = Integer.parseInt(this.contacto_opcional.getText());

                        if (Help.validar_email(email.getText())) {
                            Funcionario funcionario = new Funcionario(nome.getText(),
                                    apelido.getText(), tipoFuncionario, nr_bi.getText(), genero, estadoCivil, contacto, contacto2,
                                    email.getText(), data, cargo.getText(), salario, nr_conta, new Morada(avenida.getText(), quarteirao.getText(), rua.getText()));
                            funcionario.salvar();
                            a.setAlertType(Alert.AlertType.INFORMATION);

                            a.setContentText("Funcionario salvo com sucesso!");
                            a.show();
                        } else {
                            a.setContentText("Email invalido");
                            a.show();
                        }
                    } else {
                        a.setContentText("contacto opcional  invalido");
                        a.show();
                    }

                } else {
                    a.setContentText("contacto invalido");
                    a.show();
                }

            }
        } catch (NumberFormatException e) {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("os campos de contactos,salario,numero de conta devem ser numericos! ");
            a.show();

        }
    }

}
