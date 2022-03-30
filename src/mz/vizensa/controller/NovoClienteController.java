/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import mz.vizensa.dao.ClienteDAO;
import mz.vizensa.domain.Cliente;
import mz.vizensa.factory.Help;

/**
 *
 * @author doroteia
 */
public class NovoClienteController {

    @FXML
    VBox janela;
    @FXML
    TextField nomeCliente;
    @FXML
    TextField email;
    @FXML
    TextField contacto;
    public static float totalPreco;
    public static String nomeCliente1;

    @FXML
    public void salvar(ActionEvent event) {
        ClienteDAO c = new ClienteDAO();
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        if (!nomeCliente.getText().equals("")) {
            if (!email.getText().equalsIgnoreCase("")) {
                if (Help.validar_email(email.getText())) {
                    nomeCliente1 = nomeCliente.getText();
                    c.inserir(new Cliente(nomeCliente.getText(), email.getText(), contacto.getText()));
                    nomeCliente.clear();
                    email.clear();
                    contacto.clear();
                    janela.getScene().getWindow().hide();

                } else {

                    a.setContentText("Email invalido!");
                    a.show();

                }

            } else {
                nomeCliente1 = nomeCliente.getText();
                c.inserir(new Cliente(nomeCliente.getText(), email.getText(), contacto.getText()));
                nomeCliente.clear();
                email.clear();
                contacto.clear();
                
                janela.getScene().getWindow().hide();
            }
        }

    }
}
