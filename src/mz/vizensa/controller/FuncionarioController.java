/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mz.vizensa.domain.Caminhos;
import mz.vizensa.domain.Funcionario;

/**
 *
 * @author doroteia
 */
public class FuncionarioController {

    @FXML
    VBox janela;
    @FXML
    TableView<Funcionario> listaFuncionarios;
    static ObservableList<Funcionario> list;

    @FXML
    public void initialize() {
        BuscarTodos();
    }

    //chama tela de adiccionar Funcionario
    @FXML
    public void adicionarFuncionario(ActionEvent event) throws IOException {
        adicionarFuncionario();

    }

    //chama tela de editar Funcionario

    @FXML
    public void editarFuncionario(ActionEvent event) throws IOException {

    }

    //chama tela de remover Funcionario

    @FXML
    public void removerFuncionario(ActionEvent event) {

    }

    //chama tela de salario Funcionario

    @FXML
    public void salario(ActionEvent event) throws IOException {
        mostrarJanela(Caminhos.Salario, "Salario", Boolean.FALSE);
    }

    //chama tela de RegistoEntrada_saida

    @FXML
    public void registoEntrada_saida(ActionEvent event) throws IOException {
        mostrarJanela(Caminhos.Registo_login_logout, "Registo de entradas e saidas", Boolean.FALSE);
    }

    @FXML
    public void autenticar(ActionEvent event) throws IOException {
        mostrarJanela(Caminhos.Autenticar, "Autenticar", Boolean.FALSE);
    }

    private void mostrarJanela(String caminho, String title, Boolean maximized) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
        Parent parent = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(janela.getScene().getWindow());
        stage.setMaximized(maximized);
        stage.setResizable(false);
        stage.show();
    }

    public void BuscarTodos() {

        list = FXCollections.observableArrayList(new Funcionario().todos());

        listaFuncionarios.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("info"));
        listaFuncionarios.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("funCodigo"));
        listaFuncionarios.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("funNome"));
        listaFuncionarios.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("funApelido"));
        listaFuncionarios.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("funTipoFuncionario"));
        listaFuncionarios.setItems(list);
        for (Funcionario list1 : list) {

            list1.getInfo().setOnAction((ActionEvent event) -> {
                try {
                    PerfilFuncionarioController.setFuncionario(list1);
                    mostrarJanela(Caminhos.perfilFuncionario, list1.getFunNome() + " PerfilFuncionario", Boolean.FALSE);
                } catch (IOException ex) {
                    Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        }

    }

    public void adicionarFuncionario() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Caminhos.NovoFuncionario));
        Parent parent = loader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(janela.getScene().getWindow());
        stage.setResizable(false);
        stage.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                BuscarTodos();
            }
        });
        stage.show();
    }
}
