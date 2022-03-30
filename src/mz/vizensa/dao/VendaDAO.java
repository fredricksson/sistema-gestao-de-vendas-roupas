/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.dao;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javafx.collections.FXCollections;
import mz.vizensa.domain.Category;
import mz.vizensa.domain.Historico_venda;
import mz.vizensa.domain.Venda;
import mz.vizensa.factory.Conexao;
import static mz.vizensa.factory.Help.date_from_string;


/**
 *
 * @author doroteia
 */
public class VendaDAO {
    
       private Connection conexao;

    public VendaDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou" + ex.getMessage());
        }
    }
    
    public void registar_venda(Venda venda) throws ParseException{
    
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `venda` ");
        sql.append("( `venData_venda`, `venHora_venda`, ");
        sql.append("`venQuantidade`, `venValor_pago`) ");
        sql.append("VALUES (?,?,?,?)");
        
           try {
               PreparedStatement ps = conexao.prepareStatement(sql.toString());
               
               ps.setDate(1, (java.sql.Date) venda.getVenData_venda());
               ps.setString(2, venda.getVenHora_venda());
               ps.setInt(3, venda.getVenQuantidade());
               ps.setFloat(4, venda.getVenValor_pago());
              
               
               ps.executeUpdate();
               ps.close();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
        
                
   }
    
    public List<Historico_venda> historico_vendas(){
        List<Historico_venda> historico = FXCollections.observableArrayList();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM funcionario f , ");
        sql.append("produto p , cliente c , venda vv ");
        sql.append("JOIN venda_compra vc WHERE f.funCodigo=vc.Funcionario_codigo ");
        sql.append("and p.codigo = vc.produto_codigo ");
        sql.append("and c.idCliente= vc.cliente_codigo ");
        sql.append("and vv.idVenda = vc.venda_codigo ");
        
         try {
            PreparedStatement ps = conexao.prepareStatement(sql.toString());
            ResultSet rs;
            rs = ps.executeQuery();
             System.out.println("brm");
            while(rs.next()){
        
                historico.add(new Historico_venda(rs.getString("funNome"),rs.getString("cliNome"),
                rs.getDate("venData_venda"),rs.getString("venHora_venda"),rs.getString("prodNome"),
                rs.getString("prodCor"),rs.getInt("venQuantidade"),rs.getFloat("venValor_Pago")));
            }
         
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                 
          return  historico;             
    }
    public List<Historico_venda> historico_vendas(int cliCod){
        List<Historico_venda> historico = FXCollections.observableArrayList();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM funcionario f , ");
        sql.append("produto p , cliente c , venda vv ");
        sql.append("JOIN venda_compra vc WHERE f.funCodigo=vc.Funcionario_codigo ");
        sql.append("and p.codigo = vc.produto_codigo ");
        sql.append("and '"+cliCod+"'= c.idCliente ");
        sql.append("and vv.idVenda = vc.venda_codigo ");
        
         try {
            PreparedStatement ps = conexao.prepareStatement(sql.toString());
            ResultSet rs;
            rs = ps.executeQuery();
             System.out.println("brm");
            while(rs.next()){
        
                historico.add(new Historico_venda(rs.getString("funNome"),rs.getString("cliNome"),
                rs.getDate("venData_venda"),rs.getString("venHora_venda"),rs.getString("prodNome"),
                rs.getString("prodCor"),rs.getInt("venQuantidade"),rs.getFloat("venValor_Pago")));
            }
         
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                 
          return  historico;             
    }
    public List<Historico_venda> hist_vend_fun(int funCod){
        List<Historico_venda> historico = FXCollections.observableArrayList();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM funcionario f , ");
        sql.append("produto p , cliente c , venda vv ");
        sql.append("JOIN venda_compra vc WHERE f.funCodigo= 1 ");
        sql.append("and p.codigo = vc.produto_codigo ");
        sql.append("and c.idCliente= vc.cliente_codigo ");
        sql.append("and vv.idVenda = vc.venda_codigo ");
        
         try {
            PreparedStatement ps = conexao.prepareStatement(sql.toString());
            ResultSet rs;
            rs = ps.executeQuery();
            int i = 0;
            while(rs.next()){
                
                historico.add(new Historico_venda(rs.getString("funNome"),rs.getString("cliNome"),
                rs.getDate("venData_venda"),rs.getString("venHora_venda"),rs.getString("prodNome"),
                rs.getString("prodCor"),rs.getInt("venQuantidade"),rs.getFloat("venValor_Pago")));
            }
         
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                 
          return  historico;             
    }
    
    
    public static void main(String[] args) throws ParseException {
         VendaDAO vd = new VendaDAO();
       //  vd.registar_venda(new Venda(date_from_string("12/07/2000"),"15:12",12,14f));
         System.out.println(vd.historico_vendas(1));
    }
    
}
