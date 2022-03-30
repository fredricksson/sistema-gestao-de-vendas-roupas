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
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static mz.vizensa.controller.NovoProdutoController.telaP;
import mz.vizensa.domain.Caminhos;

/**
 *
 * @author doroteia
 */
public class EditarProdutoController {
    
  @FXML VBox janela;
    @FXML TextField nome;
    @FXML ColorPicker cor;
    @FXML TextField tamanhos;
    @FXML TextField quantidade;
    @FXML TextField preco;
    

    
    
    @FXML public void initialize(){
    
    }
    @FXML public void SalvarAlteracoes(ActionEvent event) throws IOException{
       
     
    }
    
    @FXML public void addTamanhos(ActionEvent event) throws IOException{
     
        mostrarJanela(Caminhos.AddTamanhos, "tamanhos", Boolean.FALSE);
    }
     //remover ultimo tamanho
    @FXML void remTamanhos(ActionEvent event){
    
    }
    
       private void mostrarJanela(String caminho, String title,Boolean maximized) throws IOException{
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
    
}
