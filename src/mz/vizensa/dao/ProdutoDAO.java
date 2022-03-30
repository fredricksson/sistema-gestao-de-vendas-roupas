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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import mz.vizensa.domain.Category;
import mz.vizensa.domain.Produto;
import mz.vizensa.domain.Tamanhos;
import mz.vizensa.factory.Conexao;
import mz.vizensa.factory.Help;

/**
 *
 * @author doroteia
 */
public class ProdutoDAO {

    private Connection conexao;

    public ProdutoDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou" + ex.getMessage());
        }
    }

    public void inserir(Produto produto,String tamanho,int quantidade) {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `produto` ");
        sql.append("(`codigo`, `prodNome`, `prodCor`, `prodPreco`) ");
        sql.append("VALUES (?,?,?,?) ");

        try {
            PreparedStatement ps = conexao.prepareStatement(sql.toString());

            ps.setInt(1, produto.getCodigo());
            ps.setString(2, produto.getProdNome());
            ps.setString(3, produto.getProdCor());
            ps.setFloat(4, produto.getProdPreco());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
             System.out.println("produto erro");
        }
        
        

        //Inserindo os tamanhos
        List<Tamanhos> tamanhos = new ArrayList<>();
        List<Float> t = Help.tamanhos(tamanho);
        for (Float t1 : t) {
           tamanhos.add( new Tamanhos( quantidade, t1, produto.getCodigo()));
        }
        
       
        for (int i = 0; i < tamanhos.size(); i++) {
            String sql2 = "Insert INTO tamanhos (`quantidade`, `tamanho`, `produto_codigo`) values ('" + tamanhos.get(i).getQuantidade() + "','" + tamanhos.get(i).getTamanho() + "','" + produto.getCodigo() + "' )";

            try {
                PreparedStatement ps2 = conexao.prepareStatement(sql2.toString());
                ps2.executeUpdate();
                ps2.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("tamanhos erro");
            }
        }

    }
    
    public void editarProduto (int codigo){
    
      //egf   
        
     }
    
     public List<Produto> allWithCategory(String name) {

        ArrayList<Produto> produto = new ArrayList<>();

        try {
            PreparedStatement stm = conexao.prepareStatement("SELECT * FROM produto p , category c JOIN produto_has_category pc WHERE p.codigo=pc.Produto_codigo and pc.category_category_id= c.category_id and c.catNome = ?");
            stm.setString(1, name);
            ResultSet rs;
            rs = stm.executeQuery();
            while (rs.next()) {

                produto.add(new Produto(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), new Category(rs.getString("catNome"))));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar as produtos: " + e.getMessage());
        }
        return produto;
    }
     
     public Produto pesquisarPorCodigo(int cod) {
        Produto produto = null;

        try {
            PreparedStatement stm = conexao.prepareStatement("SELECT * FROM produto p , category c JOIN produto_has_category pc "
                    + "WHERE p.codigo=pc.Produto_codigo and pc.category_category_id= c.category_id and p.codigo = ?");
            stm.setInt(1, cod);
            ResultSet rs;
            rs = stm.executeQuery();
            while (rs.next()) {

                produto = new Produto(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), new Category(rs.getString("catNome")));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar as produtos: " + e.getMessage());
        }
        return produto;
    }

     public List<Produto> pesquisarPorNome(String name)  {
        ArrayList<Produto> produto = new ArrayList<>();
       
          
        try {
             PreparedStatement stm = conexao.prepareStatement("SELECT * FROM produto p , category c JOIN produto_has_category pc "
                + "WHERE p.codigo=pc.Produto_codigo and pc.category_category_id= c.category_id and p.prodNome LIKE  ?");
            stm.setString(1,"%"+ name+"%");
             ResultSet rs;
            rs = stm.executeQuery();
            while (rs.next()) {
                
            produto.add(new Produto(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getFloat(4), new Category(rs.getString("catNome"))));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar as produtos: " + e.getMessage());
        } 
        return produto;
    }
     
      public List<Produto> pesquisarPorCategoria(String categoria)  {
        ArrayList<Produto> produto = new ArrayList<>();
       
          
        try {
             PreparedStatement stm = conexao.prepareStatement("SELECT * FROM produto p , category c JOIN produto_has_category pc WHERE p.codigo=pc.Produto_codigo and "
                     + "pc.category_category_id= c.category_id and c.catNome LIKE ?");
            stm.setString(1,"%"+ categoria+"%");
             ResultSet rs;
            rs = stm.executeQuery();
            while (rs.next()) {
                
            produto.add(new Produto(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getFloat(4), new Category(rs.getString("catNome"))));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar as produtos: " + e.getMessage());
        } 
        return produto;
    }
      
      
     
    public void inserir_categoria(int proCod, int catCod) {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `produto_has_category` ");
        sql.append("(`Produto_codigo`, `category_category_id`) ");
        sql.append("VALUES (?,?) ");

        try {
            PreparedStatement ps = conexao.prepareStatement(sql.toString());

            ps.setInt(1, proCod);

            ps.setInt(2, catCod);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
      ex.printStackTrace();
            System.out.println("erro categoria inserir Produto_has_category");
        }

    }
    
    
    public List<Tamanhos> listTamanhos(){
     String sql = "select * from tamanhos ";
     ArrayList<Tamanhos> tamanhos = new ArrayList<>();
         try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ResultSet rs;
            rs = ps.executeQuery();
  
            while (rs.next()) {
                tamanhos.add(new Tamanhos(rs.getInt(2),rs.getFloat(3),rs.getInt(4)));}
         }catch(SQLException e){
         
         }
        return tamanhos;  
    }
      
    
    public void remover(int codigo){
       
        String sql = "UPDATE `produto` SET `visibilidade`= 0 WHERE codigo =?" ;
             try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
   
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro: produto eliminar");
        }
   
    }

    public List<Produto> listar() {
      
        List<Produto> produtos = FXCollections.observableArrayList();
        String sql = "select * from produto where visibilidade = 1";
         List<Tamanhos> tamanhos = new ArrayList<>(); 
      
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
  
            while (rs.next()) {
                
                List<Tamanhos> tamanhoSeparado = new ArrayList<>();
                
                for(int i = 0; i < tamanhos.size(); i++){
                    if(tamanhos.get(i).getCodigo() == rs.getInt(1)){
                        tamanhoSeparado.add(tamanhos.get(i));
                    }
                }
                produtos.add(new Produto(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), tamanhoSeparado)
                );
             
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return produtos;

    }
    
    public int CodigoCategoria(String nome) {
      
        int cod=0;
        String sql = "SELECT category_id  FROM `category` where catNome = ? ";
      
      
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ResultSet rs;
            rs = ps.executeQuery();
  
            while (rs.next()) {
                cod = rs.getInt("category_id");
                
             
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return cod;

    }

    public List<Produto> produto_category() {

        List<Produto> produtos = FXCollections.observableArrayList();
        String sql ="SELECT * FROM produto p , category c JOIN produto_has_category pc WHERE visibilidade = 1 and p.codigo=pc.Produto_codigo and pc.category_category_id= c.category_id";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                produtos.add(new Produto(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4), new Category(rs.getString("catNome"))
                ));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return produtos;

    }

    public static void main(String[] args) {
      
        ProdutoDAO pd = new ProdutoDAO();
       
        //pd.inserir(new Produto(3,"calca","amaerla",34f,4,343f));
        //pd.inserir_categoria(3, 1);
        System.out.println(pd.CodigoCategoria("acessorios"));
        List<Produto> p =  pd.produto_category();
        for(int i = 0 ; i < p.size() ; i++){
            System.out.println(p.get(i).getProdNome());
            System.out.println("=====Tamanhos====");
             for(int j = 0 ; j < p.get(i).getTamanhos().size();j++){
               //  System.out.println("Quantidade: "+p.get(i).getTamanhos().get(j).getQuantidade());
                System.out.println("Tamanho: "+p.get(i).getProdNome());
             
             }
             System.out.println("=========");
        }
//        for (int i = 0; i < pd.listar().size(); i++) {
//               System.out.println(pd.listar().get(i).getProdNome());
//               System.out.println("=====Tamanhos====");
//               for(int j =0 ; j< pd.listar().get(i).getTamanhos().size(); j++){
//                 System.out.println("Quantidade"+pd.listar().get(i).getTamanhos().get(j).getQuantidade());
//                 System.out.println("Tamanho"+pd.listar().get(i).getTamanhos().get(j).getTamanho());
//               }
//               
//              System.out.println("=========="); 
//        }
   
    }

}
  
    
