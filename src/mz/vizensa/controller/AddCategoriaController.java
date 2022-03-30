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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import static mz.vizensa.controller.NovoProdutoController.*;
import static mz.vizensa.controller.NovoProdutoController.telaP;
import mz.vizensa.dao.CategoryDAO;
import mz.vizensa.dao.ProdutoDAO;
import mz.vizensa.domain.Category;
import mz.vizensa.domain.Produto;
import mz.vizensa.domain.Tamanhos;

/**
 *
 * @author doroteia
 */
public class AddCategoriaController {

    //botao de adiccionar na vertente do cadastro
    @FXML
    Button add;
    @FXML
    Button add2;
    @FXML
    Button salvarProduto;
    @FXML
    TextField textField;
    @FXML
    ComboBox comboBox;
    public String tela;
    ProdutoDAO pd = new ProdutoDAO();
    CategoryDAO cd = new CategoryDAO();

    @FXML
    public void initialize() {
        listarCategoria();
        tela = telaP;
        if (tela.equalsIgnoreCase("produtos")) {
            textField.setVisible(false);
            add2.setVisible(false);
        } else {
            add.setVisible(false);
            salvarProduto.setVisible(false);

        }
    }

    @FXML
    public void addCategoria(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        if (!textField.getText().isEmpty()) {
            cd.inserir(new Category(textField.getText()));
            comboBox.getItems().add(textField.getText());
            a.setContentText("Categoria adiccionada com sucesso!");
            a.show();
        } else {
            a.setContentText("campo categoria esta vazio!!");
            a.setAlertType(Alert.AlertType.ERROR);
            a.show();
        }
        if (tela.equalsIgnoreCase("produtos")) {
            textField.setVisible(false);
            add2.setVisible(false);
        }

    }

    @FXML
    public void salvarProduto(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.NONE);
        if (comboBox.getSelectionModel().isEmpty()) {
            a.setContentText("Seleccione categoria, CASO nao haja adiccione!");
            a.setAlertType(Alert.AlertType.ERROR);

            a.show();
        } else {

            pd.inserir(new Produto(codigo1, nome1, cor1, preco1), tamanhos1, quantidade1);
            pd.inserir_categoria(codigo1, pd.CodigoCategoria(comboBox.getSelectionModel().getSelectedItem().toString()));
           
            //Actualizando a tabela tamanho com novos valors para evitar o erro "too many  conection"
            Tamanhos.pd = new ProdutoDAO();
            Tamanhos.tamanhos = pd.listTamanhos();
            // Fim da actualixacao
            
            a.setContentText("Produto salvo com sucesso!");
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.show();
        }
    }

    @FXML
    public void AdiccionarCategoriaProdutos(ActionEvent event) {
        if (tela.equalsIgnoreCase("produtos")) {
            textField.setVisible(true);
            add2.setVisible(true);

        } else {

        }
    }

    public void listarCategoria() {
        comboBox.getItems().clear();
        List<Category> categorias = cd.listar();

        for (Category categoria : categorias) {
            comboBox.getItems().add(categoria.getCatNome());
        }
    }
}
