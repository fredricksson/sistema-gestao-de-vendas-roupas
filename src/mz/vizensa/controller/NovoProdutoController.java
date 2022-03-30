/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.controller;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static mz.vizensa.controller.AddTamanhoController.tamanho2;
import mz.vizensa.domain.Caminhos;
import mz.vizensa.factory.Help;
import mz.vizensa.factory.ManipularImagem;

/**
 *
 * @author doroteia
 */
public class NovoProdutoController {

    @FXML
    VBox janela;
    @FXML
    TextField nome;
    @FXML
    ColorPicker cor;
    @FXML
    TextField tamanhos;
    @FXML
    TextField quantidade;
    @FXML
    TextField preco, codigo;
    @FXML ComboBox categoria;
    @FXML
    ImageView foto;
    static String nome1;
    static String cor1;
    static String tamanhos1;
    static int quantidade1;
    static float preco1;
    static int codigo1;
    static String telaP = "produtos";
     File file;
    @FXML
    public void initialize() {
       
    }

    @FXML
    public void salvar(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.NONE);
        telaP = "produtos";
        nome1 = nome.getText();
        cor1 = cor.getValue().toString();
        tamanhos1 = tamanhos.getText();
     ManipularImagem.getImgBytes(ManipularImagem.setImagemDimensao(file.getAbsolutePath(), 200, 200));
        System.out.println(file.getAbsoluteFile());
      //  tamanhos1 = tamanhos.getText();
        

        boolean erro = false;
        if (codigo.getText().isEmpty()) {
              a.setContentText("o campo codigo esta vazio!");
                a.setAlertType(Alert.AlertType.ERROR);
                erro = true;
                a.show();
         
        } else if (nome1.isEmpty()) {
            a.setContentText("O nome do produto nao pode estar vazio!");
            a.setAlertType(Alert.AlertType.ERROR);
            erro = true;
            a.show();

        } else if (cor1.isEmpty()) {
            a.setContentText("A cor do produto nao pode estar vazio!");
            a.setAlertType(Alert.AlertType.ERROR);
            erro = true;
            a.show();
        } else if (tamanhos1.isEmpty()) {
            a.setContentText("O produto deve conter pelo menos um tamanho nao pode estar vazio!");
            a.setAlertType(Alert.AlertType.ERROR);
            erro = true;
            a.show();
        } else if (quantidade.getText().isEmpty()) {
            a.setContentText("o campo Quantidade esta vazio!!");
            a.setAlertType(Alert.AlertType.ERROR);
            erro = true;
            a.show();
        }
          if(!codigo.getText().isEmpty()){
           try {
                codigo1 = Integer.parseInt(codigo.getText());
            } catch (NumberFormatException e) {
                
                a.setContentText("o campo codigo contem um numero invalido!");
                a.setAlertType(Alert.AlertType.ERROR);
                erro = true;
                a.show();
            }
          }
        if(!quantidade.getText().isEmpty()){
        try{
            quantidade1 = Integer.parseInt(quantidade.getText().trim());
        }catch(NumberFormatException e){
               a.setContentText("Quantidade invalida!");
            a.setAlertType(Alert.AlertType.ERROR);
            erro = true;
            a.show();
        }
        }
        if(!preco.getText().isEmpty()){
             try{
            preco1 = Integer.parseInt(quantidade.getText().trim());
        }catch(NumberFormatException e){
               a.setContentText("preco invalido!");
            a.setAlertType(Alert.AlertType.ERROR);
            erro = true;
            a.show();
        }
        
        }
        if (!erro) {
            mostrarJanela(Caminhos.categoria, "Categoria", Boolean.FALSE);
        }
    }

//    @FXML
//    public void addTamanhos(ActionEvent event) throws IOException {
//  
//        AddTamanhos(Caminhos.AddTamanhos, "tamanhos", Boolean.FALSE);
//    }
    @FXML
    public void addTamanho(ActionEvent event) throws IOException {
  
        AddTamanhos(Caminhos.AddTamanhos, "tamanhos", Boolean.FALSE);
    }
    @FXML
    public void addTamanh(MouseEvent event) throws IOException {
  
        AddTamanhos(Caminhos.AddTamanhos, "tamanhos", Boolean.FALSE);
    }
    @FXML
    public void addImage(MouseEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Imagens","*.jpeg","*.png","*.jpg"));
        file = fc.showOpenDialog(new Stage());
        
        if(file != null){
        foto.setImage(new Image("file:///"+file.getAbsolutePath()));
            System.out.println(file.getAbsolutePath());
        }
        
    }
    @FXML
    public void addCategoria(ActionEvent event) throws IOException {
  
        AddTamanhos(Caminhos.AddTamanhos, "tamanhos", Boolean.FALSE);
    }

    //remover ultimo tamanho
    @FXML
    void remTamanhos(ActionEvent event) {
       
       tamanhos.setText( Help.removerTamanho(tamanhos.getText()));
       tamanho2 =  tamanhos.getText();
       if(tamanho2.equalsIgnoreCase(",")){
           tamanho2 = "";
           tamanhos.setText("");
       }
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
    private void AddTamanhos(String caminho, String title, Boolean maximized) throws IOException {
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
         stage.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                
               tamanhos.setText(tamanho2);
            }
        });

    }
}
