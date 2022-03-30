/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import mz.vizensa.domain.Category;
import mz.vizensa.factory.Conexao;

/**
 *
 * @author doroteia
 */
public class CategoryDAO {
    
    private Connection conexao;

    public CategoryDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou" + ex.getMessage());
        }
    }
    
    public void inserir(Category category){
        
        String sql = "INSERT INTO category(catNome) values(?)";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, category.getCatNome());
           
            ps.executeUpdate();
            ps.close();
                
        } catch (SQLException ex) {
        }
        
    }
    
    public List<Category> listar(){
        List<Category> categorias = FXCollections.observableArrayList();
        
        String sql = "select * from category";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            
            while(rs.next()){
                categorias.add(new Category(rs.getString(2)));
            }
            
        } catch (SQLException ex) {
            
        }
                
        return categorias;
    }
    public static void main(String[] args) {
//        CategoryDAO cd = new CategoryDAO();
//       // cd.inserir(new Category("fatos"));
//       // cd.inserir(new Category("acessorios"));
//       
//        System.out.println( cd.listar().get(0).getCatNome());
    }
}
