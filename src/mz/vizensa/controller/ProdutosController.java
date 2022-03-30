/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static mz.vizensa.controller.FuncionarioController.list;
import static mz.vizensa.controller.NovoProdutoController.telaP;
import mz.vizensa.dao.CategoryDAO;
import mz.vizensa.dao.ProdutoDAO;
import mz.vizensa.domain.Caminhos;
import mz.vizensa.domain.Category;
import mz.vizensa.domain.Funcionario;
import mz.vizensa.domain.Produto;
import mz.vizensa.domain.Tamanhos;

/**
 *
 * @author doroteia
 */
public class ProdutosController {

    @FXML
    VBox janela;
    @FXML
    TableView<Produto> tabelaProduto;
    @FXML
    TableView<Tamanhos> TabelaTamanhos;
     @FXML
     TextField pesquisar;
    @FXML
    ComboBox comboCategoria;
    CategoryDAO cd = new CategoryDAO();
    ProdutoDAO produtodao= new ProdutoDAO();

    @FXML
    public void initialize() {
        Listar();
         pesquisarProduto();
        InserirCategorias();
        preenherTamanhos();
        pesquisar_por_Categoria();
        tabelaProduto.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TabelaTamanhos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
    }

    //chama tela de Adiccionar Produtos
    @FXML
    void adicionarProdutos(ActionEvent event) throws IOException {
        AdicionarProdut();

    }

    //Chama tela de edicao
    @FXML
    void editarProduto(ActionEvent event) throws IOException {
        mostrarJanela(Caminhos.EditarProdutos, "EditarProduto", Boolean.FALSE);
    }

    //chama tela de excluir
    @FXML
    void excluirProduto(ActionEvent event) {
apagar();
Listar();
    }

    //chama tela se stock
    @FXML
    void Stock(ActionEvent event) {
    }

    //botao pra listar todos produtos
    @FXML
    void listarTodosProdutos(ActionEvent event) {
        Listar();
    }

    //chama tela de adicao de categoria
    @FXML
    void adicionarCategoria(ActionEvent event) throws IOException {
        telaP = "";
        mostrarJanela(Caminhos.categoria, "Categoria", Boolean.FALSE);

    }
    
      private void pesquisarProduto() {
        pesquisar.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                TextField text = (TextField) event.getSource();
                if (text.getLength() > 1) {
                    String name = pesquisar.getText();
                    
                    ObservableList<Produto> oList = FXCollections.observableArrayList(Produto.pesquisarPorNome(name));
                    tabelaProduto.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("codigo"));
                    tabelaProduto.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("prodNome"));
                    tabelaProduto.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("prodPreco"));
                    tabelaProduto.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("cor"));
                    tabelaProduto.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("categor"));;
                    // tabelaProdutos.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("categor"));
                    tabelaProduto.setItems(oList);
                } else if (text.getLength() < 1) {
                    Listar();
                }
            }
        });
    }

    private void preenherTamanhos() {
        tabelaProduto.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Produto>() {

                    @Override
                    public void changed(ObservableValue<? extends Produto> observable, Produto oldValue, Produto newValue) {
                        try {
                            
                       
                        int cod =tabelaProduto.getSelectionModel().getSelectedItem().getCodigo();
                        ObservableList<Tamanhos> listT = FXCollections.observableArrayList(Tamanhos.Todostamanhos(cod));
                        TabelaTamanhos.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("tamanho"));
                        TabelaTamanhos.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
                        TabelaTamanhos.setItems(listT);
                        
                         } catch (Exception e) {
                             Alert a = new Alert(Alert.AlertType.WARNING);
                             a.show();
                         }
                    }  

                });

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

    private void AdicionarProdut() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Caminhos.NovoProduto));
        Parent parent = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("NovoProduto");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(janela.getScene().getWindow());

        stage.setResizable(false);

        stage.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Listar();
                InserirCategorias();
            }
        });

        stage.show();

    }

    public void Listar() {
        
        ObservableList<Produto> list = FXCollections.observableArrayList(new Produto().buscarTodos());
        
        tabelaProduto.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tabelaProduto.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("prodNome"));
        tabelaProduto.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("prodPreco"));
        tabelaProduto.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("quantidadeTotal"));
        tabelaProduto.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("cor"));
        tabelaProduto.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("categor"));

        tabelaProduto.setItems(list);
    }

    public void InserirCategorias() {
        List<Category> categorias = cd.listar();

        for (Category categoria : categorias) {
            comboCategoria.getItems().add(categoria.getCatNome());
        }
    }
    
    public void apagar(){
    
          tabelaProduto.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Produto>() {

                    @Override
                    public void changed(ObservableValue<? extends Produto> observable, Produto oldValue, Produto newValue) {
                        try {
                            
                       
                        int cod =tabelaProduto.getSelectionModel().getSelectedItem().getCodigo();
                          produtodao.remover(cod); 
                        
                         } catch (Exception e) {
                             Alert a = new Alert(Alert.AlertType.WARNING);
                             a.show();
                         }
                    }  

                });
    
    }
    private  void pesquisar_por_Categoria(){
        comboCategoria.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            
                            CategoryDAO cd = new CategoryDAO();
       
                            System.out.println(comboCategoria.getSelectionModel().getSelectedItem());
        for(int i=0; i<cd.listar().size();i++){
           
           if(comboCategoria.getSelectionModel().getSelectedItem().equals(cd.listar().get(i).getCatNome())){
            
                  // ObservableList<Produto> oList = FXCollections.observableArrayList(Produto.pesquisarPorNome(name));
                    ObservableList<Produto> oList = FXCollections.observableArrayList(Produto.pesquisarPorCategoria(cd.listar().get(i).getCatNome()));
                    tabelaProduto.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("codigo"));
                    tabelaProduto.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("prodNome"));
                    tabelaProduto.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("prodPreco"));
                   
                    tabelaProduto.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("categor"));
                    tabelaProduto.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("cor"));
                    // tabelaProdutos.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("categor"));
                    tabelaProduto.setItems(oList);
                
           }  
         
          }
            }
        });
        
        
        
    
     
         
    }
    
       @FXML public void menu(ActionEvent event) throws IOException{
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource(Caminhos.PaginaPrincipal));
            Parent home_page_parent = loader.load();

            //InitialController controller = loader.getController();
           // controller.setUser(user);
            
            Scene home_page_scene = new Scene(home_page_parent);
            Stage main_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            main_stage.close();
            main_stage.setScene(home_page_scene);
            main_stage.setTitle("Vizensa");
            main_stage.setResizable(true);
            main_stage.setMaximized(true);
            main_stage.show();
          
            
    
    }
    
  public static void main(String [] args){
    
       CategoryDAO cd = new CategoryDAO();
       
        for(int i=0; i<cd.listar().size();i++){
            System.out.println(cd.listar().get(i).getCatNome());
       }
      System.out.println("Mondlane");
  
    }
}
 