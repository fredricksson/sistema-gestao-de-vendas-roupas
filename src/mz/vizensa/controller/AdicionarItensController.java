/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import static mz.vizensa.controller.NovoClienteController.totalPreco;
import mz.vizensa.dao.CategoryDAO;
import mz.vizensa.domain.Category;
import mz.vizensa.domain.Produto;
import mz.vizensa.domain.Tamanhos;

/**
 *
 * @author doroteia
 */
public class AdicionarItensController {

    @FXML
    VBox janela;
    @FXML
    TextField pesquisa, quantidade;
    @FXML
    ComboBox combo_categoria;
    @FXML
    ComboBox combo_tamanho;
    @FXML
    TableView<Produto> tabelaProdutos;
    @FXML
    TableView<Tamanhos> tabelaTamanhos;
    public static List<Produto> itens = new ArrayList<>();
    CategoryDAO cd = new CategoryDAO();
    public static int quantidade1;

    @FXML
    public void initialize() {
       
        preencherCategoria();
        listarProdutos();
        pesquisarProduto();
        preenherTamanhos();
          tabelaProdutos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
         tabelaTamanhos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    public void pesquisarPorCategoria(ActionEvent event) {
        pesquisa.clear();

        if (combo_categoria.getSelectionModel().getSelectedIndex() != -1) {
            pesquisaCategorica();
        }
    }

    @FXML
    public void adicionarItem(ActionEvent event) {
        if (tabelaProdutos.getSelectionModel().getSelectedIndex() != -1) {
            preenherItens();

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Seleccione um item");
            a.show();
        }

    }

    @FXML
    public void concluir(ActionEvent event
    ) {
//        System.out.println(itens.get(0).getProdNome());
        janela.getScene().getWindow().hide();
    }

    public void listarProdutos() {
        ObservableList<Produto> list = FXCollections.observableArrayList(new Produto().buscarTodos());
          System.out.println(list.get(0).buscarTodos());
        tabelaProdutos.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tabelaProdutos.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("prodNome"));
        tabelaProdutos.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("prodPreco"));
        tabelaProdutos.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("cor"));
        tabelaProdutos.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("categor"));;

        tabelaProdutos.setItems(list);

    }

    public void InserirCategorias() {
        List<Category> categorias = cd.listar();

        for (Category categoria : categorias) {
            combo_categoria.getItems().add(categoria.getCatNome());
        }
    }

    private void preenherTamanhos() {
        tabelaProdutos.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Produto>() {

                    @Override
                    public void changed(ObservableValue<? extends Produto> observable, Produto oldValue, Produto newValue) {
                        try {
                            try {
                                int cod = tabelaProdutos.getSelectionModel().getSelectedItem().getCodigo();
                                ObservableList<Tamanhos> listT = FXCollections.observableArrayList(Tamanhos.Todostamanhos(cod));
                                tabelaTamanhos.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("tamanho"));
                                tabelaTamanhos.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
                                tabelaTamanhos.setItems(listT);
                                combo_tamanho.getItems().clear();
                                for (Tamanhos listT1 : listT) {
                                    combo_tamanho.getItems().add(listT1.getTamanho());
                                }

                            } catch (NullPointerException e) {

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                });

    }

    private void pesquisarProduto() {
        pesquisa.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                combo_categoria.getSelectionModel().clearSelection();
                TextField text = (TextField) event.getSource();
                if (text.getLength() > 1) {
                    tabelaTamanhos.getItems().clear();
                    String name = pesquisa.getText();
                    ObservableList<Produto> oList = FXCollections.observableArrayList(Produto.pesquisarPorNome(name));
                    tabelaProdutos.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("codigo"));
                    tabelaProdutos.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("prodNome"));
                    tabelaProdutos.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("prodPreco"));
                    tabelaProdutos.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("cor"));
                    tabelaProdutos.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("categor"));;
                    tabelaProdutos.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("categor"));
                    tabelaProdutos.setItems(oList);
                } else if (text.getLength() < 1) {
                    listarProdutos();
                }
            }
        });
    }

    private void pesquisaCategorica() {
        tabelaTamanhos.getItems().clear();
        ObservableList<Produto> oList = FXCollections.observableArrayList(Produto.allWithCategory(combo_categoria.getSelectionModel().getSelectedItem().toString()));
        tabelaProdutos.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tabelaProdutos.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("prodNome"));
        tabelaProdutos.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("prodPreco"));
        tabelaProdutos.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("cor"));
        tabelaProdutos.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("categor"));;
        tabelaProdutos.setItems(oList);
    }

    public void preencherCategoria() {

        
        List<Category> categorias = cd.listar();
        for (Category categoria : categorias) {
            combo_categoria.getItems().add(categoria.getCatNome());
        }
        
    }

    private void preenherItens() {
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setContentText("Seleccione tamanho");

        try {
            try {
                try {
                    quantidade1 = Integer.parseInt(quantidade.getText());
                    int cod = tabelaProdutos.getSelectionModel().getSelectedItem().getCodigo();
                    Produto p = Produto.item(cod);
                    p.setQuantidadeTotal(quantidade1);
                    totalPreco += quantidade1;
                    if (combo_tamanho.getSelectionModel().getSelectedIndex() == -1) {
                        a1.show();
                    } else {

                        p.setProdTamanho(Float.parseFloat(combo_tamanho.getSelectionModel().getSelectedItem().toString()));

                        itens.add(p);
                        quantidade.clear();
                        Alert a = new Alert(Alert.AlertType.INFORMATION);
                        a.setContentText("item adicionado");
                        a.show();
                    }
                } catch (NumberFormatException e) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Digite QUANTIDADE valida!");
                    a.show();
                }
            } catch (NullPointerException e) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
