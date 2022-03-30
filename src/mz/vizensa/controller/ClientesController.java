/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import mz.vizensa.dao.ClienteDAO;
import mz.vizensa.domain.Cliente;
import mz.vizensa.factory.Help;

/**
 * FXML Controller class
 *
 * @author TOMAS MONDLANE TSM
 */
public class ClientesController implements Initializable {
 
//    @FXML
//    private TextField tfpesquisar;
//    @FXML
//    private TableView<?> tabelaCliente;
//    @FXML
//    private TextField tfnome;
//    @FXML
//    private TextField tfcontacto;
//    @FXML
//    private TextField tfemail;
      @FXML TextField tfnome;
    @FXML TextField tfemail;
    @FXML TextField tfcontacto;
    @FXML TableView<Cliente> tabelaCliente;
   
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lista();
     tabelaCliente.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
    }
  @FXML public void salvar(ActionEvent event){
          Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("salvar Clienbte");
        a.show();
    }
   
    
    
    @FXML
    public void cadastrar(ActionEvent event) throws IOException{
     inserir();
    }
    
    
    public void inserir() {
     //  String email ="";
   
        Cliente cliente;
      
        if(Help.validar_email(tfemail.getText()) || tfemail.getText().isEmpty() && !tfcontacto.getText().isEmpty() && !tfnome.getText().isEmpty()){
         cliente = new Cliente(tfnome.getText(),tfemail.getText(),tfcontacto.getText());
        ClienteDAO clientedao = new ClienteDAO();  
         clientedao.inserir(cliente);
       
             List<Cliente> lista =clientedao.listar();

        ObservableList<Cliente> list = FXCollections.observableArrayList(lista);
      
        tabelaCliente.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cliNome"));
        tabelaCliente.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("cliContacto"));
       tabelaCliente.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cliemail"));
       
      


        tabelaCliente.setItems(list);
        } else
               {
                  tfemail.setStyle("-fx-border-color: red");
                }
    
    }
    
    public void lista(){
             ClienteDAO clientedao = new ClienteDAO();  
       
             List<Cliente> lista =clientedao.listar();

        ObservableList<Cliente> list = FXCollections.observableArrayList(lista);
      
        tabelaCliente.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cliNome"));
        tabelaCliente.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("cliContacto"));
       tabelaCliente.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cliemail"));
       
        tabelaCliente.setItems(list);
    
    }
    
    public static void main(String [] args){
      
//             ClienteDAO clientedao = new ClienteDAO();  
//         List<Cliente> lista = clientedao.listar();
//        System.out.println("Mais a Fundo");
//         for(int i=0; i<lista.size();i++)
//         System.out.println(lista.get(i).toString());
    }
}
