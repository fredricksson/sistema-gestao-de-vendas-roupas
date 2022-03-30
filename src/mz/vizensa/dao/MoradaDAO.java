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
import java.util.logging.Level;
import java.util.logging.Logger;
import mz.vizensa.domain.Morada;
import mz.vizensa.factory.Conexao;

/**
 *
 * @author doroteia
 */
public class MoradaDAO {
    
    
      private Connection conexao;
    
    public MoradaDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou" + ex.getMessage());
        }
    }
    
    public void inserir(Morada morada,int idFuncionario){
           String sql = "INSERT INTO `morada`(`morAvenida`, `morQuarteirao`,`morRua`,  `Funcionario_funCodigo`) VALUES (?,?,?,?)";
            
        
        try {
               PreparedStatement ps = conexao.prepareStatement(sql);
              ps.setString(1, morada.getMorAvenida());  
              ps.setString(2, morada.getMorQuarteirao());
              ps.setString(3, morada.getMorRua());
              ps.setInt(4,idFuncionario );
              
              ps.executeUpdate();
              ps.close();
          } catch (SQLException ex) {
            System.out.println("erro morada insercao");
          }
    
    }
    
    public Morada BuscaPorCodigoFunc(int codFunc){
          Morada morada = null;
          String sql = "select * from morada where Funcionario_funCodigo ='"+codFunc+"'";
          try {
            
              
              PreparedStatement ps = conexao.prepareStatement(sql);
              ResultSet rs;
              rs = ps.executeQuery();
              while (rs.next()) {
               morada = new Morada(rs.getString("morAvenida"),rs.getString("morQuarteirao"),rs.getString("morRua"));
              }
          } catch (SQLException ex) {
              Logger.getLogger(MoradaDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          return morada;
    }
    public static void main(String[] args) {
      //  MoradaDAO md =new MoradaDAO();
      //  md.inserir(new Morada("mahota","12","weer"), 1);
               
    }
}
