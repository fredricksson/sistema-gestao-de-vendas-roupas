/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import java.io.IOException;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static mz.vizensa.controller.NovoClienteController.nomeCliente1;
import static mz.vizensa.controller.NovoClienteController.totalPreco;
import mz.vizensa.domain.Caminhos;
import mz.vizensa.domain.Produto;

/**
 *
 * @author doroteia
 */
public class CaixaController {

    @FXML
    VBox janela;
    @FXML
    Label total;
    @FXML
    Label troco;
    @FXML
    TextField valorRecebido, nomeCliente;
    @FXML
    TableView<Produto> tabelaItens;
    float t;

    @FXML
    public void initialize() {
      
        t = totalPreco;
        ListarItens();
         
        valorRecebido.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {

                    float valor_recebido = Float.parseFloat(newValue);
                    String g = t - valor_recebido + " MT";
                    String g1 = g.replace(".", ",");
                    troco.setText(g1);

                } catch (NumberFormatException e) {
                    String g = t + " MT";
                    String g1 = g.replace(".", ",");

                    troco.setText(g);
                }
            }
        });

    }

    @FXML
    public void onClickCliente(ActionEvent event) throws IOException {
        if (nomeCliente.getText().equalsIgnoreCase("Sem Nome")) {
            novoCliente();
        }
    }

    @FXML
    public void adicionarItens(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Caminhos.AdicionarItens));
        Parent parent = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("NovoProduto");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(janela.getScene().getWindow());

       // stage.setResizable(false);

        stage.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                ListarItens();
                total.setText(totalPreco + "");
                t = totalPreco;

            }
        });

        stage.show();

    }

    //campo de calcular trocos
    @FXML
    public void confirmarVenda(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Confirmar venda");
        a.show();
    }

    //campo de calcular trocos
    @FXML
    public void ExcuirProduto(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("eXCUIR");
        a.show();
    }

    //campo de calcular trocos
    @FXML
    public void cancelarVenda(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("CANCELAR VENDA");
        a.show();
    }

    public void ListarItens() {

        ObservableList<Produto> list = FXCollections.observableArrayList(Produto.listarItens());

        tabelaItens.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tabelaItens.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("prodNome"));
        tabelaItens.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cor"));
        tabelaItens.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("prodPreco"));
        tabelaItens.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("prodTamanho"));
        tabelaItens.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("quantidadeTotal"));

        tabelaItens.setItems(list);
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
        stage.setResizable(true);
        stage.show();
    }

    private void novoCliente() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Caminhos.NovoCliente));
        Parent parent = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(janela.getScene().getWindow());

        stage.setResizable(true);
        stage.show();
        stage.setOnHiding((WindowEvent event) -> {
            nomeCliente.setText(nomeCliente1);

        });

        stage.show();

    }
}
