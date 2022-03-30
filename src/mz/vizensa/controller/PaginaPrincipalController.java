/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mz.vizensa.domain.Caminhos;

/**
 *
 * @author doroteia
 */
public class PaginaPrincipalController {
    
    @FXML AnchorPane janela;
    @FXML Button sair;
    
    @FXML public void initialize(){
    
    }
    //Carrega a tela do caixa
    @FXML public void caixa() throws IOException{
        mostrarJanela(Caminhos.Caixa,"Caixa");
    }
    //Carrega a tela de produtos
    @FXML public void produtos(ActionEvent event) throws IOException{
       mostrarJanela(Caminhos.produtos,"Produtos");
    }
    //Carrega a tela de Funcionario
    @FXML public void funcionarios(ActionEvent event) throws IOException{
       mostrarJanela(Caminhos.Funcionarios,"Funcionarios");
    }
    //Carrega a tela de vendas
    @FXML public void vendas(ActionEvent event) throws IOException{
        mostrarJanela(Caminhos.Vendas, "Vendas");
    }
    //Carrega a tela de clientes
    @FXML public void clientes(ActionEvent event) throws IOException{
        mostrarJanela(Caminhos.Clientes, "Clientes");
    
    }
    //Sair do Programa
    @FXML public void sair(ActionEvent event) throws IOException{
        System.exit(0);
    }
    
    
      private void mostrarJanela(String caminho, String title) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
        Parent parent = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(janela.getScene().getWindow());
        stage.setMaximized(true);
        //stage.setResizable(false);
        stage.show();
    }
    
}
