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
import mz.vizensa.domain.Empresa;
import mz.vizensa.factory.Conexao;

/**
 *
 * @author doroteia
 */
public class EmpresaDAO {
    
    
        private Connection conexao;

    public EmpresaDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou" + ex.getMessage());
        }
    }
    
    public void inserir(Empresa empresa){
        
        String sql = "INSERT INTO `empresa`( `empNome`, `empTelfone`, `empLogotipo`, `empEmail`) VALUES (?,?,?,?) ";
        
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, empresa.getEmpNome());
                ps.setString(2, empresa.getEmpTelfone());
                ps.setString(3, empresa.getEmpLogotipo());
                ps.setString(4, empresa.getEmmEmail());
                
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
            }
    }
    
    public Empresa buscar(){
        Empresa empresa = new Empresa();
        String sql = "SELECT * FROM `empresa` ";
       
      
            try {
                  PreparedStatement ps = conexao.prepareStatement(sql);
                  ResultSet rs;
                  rs = ps.executeQuery();
                  rs.next();
                  empresa.setEmpNome(rs.getString(2));
                  empresa.setEmpTelfone(rs.getString(3));
                  empresa.setEmpLogotipo(rs.getString(4));
                  empresa.setEmmEmail(rs.getNString(5));
            } catch (SQLException ex) {
            ex.printStackTrace();
            }
            return empresa;
    }
    public static void main(String[] args) {
        EmpresaDAO em = new EmpresaDAO();
       // em.inserir(new Empresa("vizenza","dsd","gmail.com",""));
        System.out.println(em.buscar());
    }
}
