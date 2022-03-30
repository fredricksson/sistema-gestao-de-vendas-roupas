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
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import mz.vizensa.domain.Historico_E_S;
import mz.vizensa.factory.Conexao;
import static mz.vizensa.factory.Help.date_from_string;

/**
 *
 * @author doroteia
 */
public class Historico_E_SDAO {
    
     private Connection conexao;

    public Historico_E_SDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou" + ex.getMessage());
        }
    }
    
     public void reqistarE_S(Historico_E_S historico){
        
          String sql = "INSERT INTO `historico_e_s`( `data`,`hisHora_entrada`, `hisHora_saida`,"
                  + " `Funcionario_funCodigo`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setDate(1, (java.sql.Date) historico.getData());
            ps.setString(2,  historico.getHisHora());
            ps.setString(3,  historico.getHisSaida());
            ps.setInt(4, historico.getFunCodigo());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MoradaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     //Historico individual
     public List<Historico_E_S> historico_indl(int codigo){
         List<Historico_E_S> lista = FXCollections.observableArrayList();
         String sql ="SELECT * FROM historico_e_s h join funcionario f WHERE f.funCodigo='"+codigo+"'";
          try {

            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Historico_E_S(rs.getString("funNome"),rs.getDate("data"),rs.getString("hisHora_entrada"),rs.getString("hisHora_saida"),rs.getInt("funCodigo")));
                
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
          return lista;
     }
        public List<Historico_E_S> listar(){
         List<Historico_E_S> lista = FXCollections.observableArrayList();
         String sql ="SELECT * FROM historico_e_s h join funcionario f where f.funCodigo = h.Funcionario_funCodigo   ";
          try {

            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Historico_E_S(rs.getString("funNome"),rs.getDate("data"),rs.getString("hisHora_entrada"),rs.getString("hisHora_saida"),rs.getInt("funCodigo")));
                
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
          return lista;
     }
     public static void main(String[] args) throws ParseException {
         
        Historico_E_SDAO hs =  new Historico_E_SDAO();
        //hs.reqistarE_S(new Historico_E_S(date_from_string("3/9/1999"),"13:73","16:28",3));
        System.out.println(hs.listar().toString());
    }
}
