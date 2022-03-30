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
import java.text.SimpleDateFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mz.vizensa.domain.Funcionario;
import mz.vizensa.domain.Morada;
import mz.vizensa.factory.Conexao;
import static mz.vizensa.factory.Help.date_from_string;

/**
 *
 * @author doroteia
 */
public class FuncionarioDAO {
    
    private Connection conexao;
    
    public FuncionarioDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou" + ex.getMessage());
        }
    }
    
    public void inserir(Funcionario f) {
         System.out.println(f.getMorada().getMorAvenida());
        String sql
                = "INSERT INTO `funcionario`( `funNome`, `funApelido`, `funTipoFuncionario`, "
                + "`funNr_bi`, `funGenero`, `funEstado_civil`, `funContacto`, `funContacto2`, `funEmail`, "
                + "`funData_nascimento`, `funCargo`, `funSalario`, `funNr_conta`, "
                + "`funAutenticavel`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
           
            ps.setString(1, f.getFunNome());
            ps.setString(2, f.getFunApelido());
            ps.setString(3, f.getFunTipoFuncionario());
            ps.setString(4, f.getFunNr_bi());
            ps.setString(5, "" + f.getFunGenero());
            ps.setString(6, f.getFunEstado_civil());
            ps.setInt(7, f.getContaco1());
            ps.setInt(8, f.getContaco2());
            ps.setString(9, f.getFunEmail());
            ps.setDate(10, (java.sql.Date) f.getFunData());
            ps.setString(11, f.getFunCargo());
            ps.setFloat(12, f.getFunSalario());
            ps.setLong(13, f.getFunNr_conta());// podera eventualmente ocorrer erro( erro de compatibilidade)
            ps.setBoolean(14, f.isFunAutenticavel());
            ps.executeUpdate();
            
            int cod = BuscarFuncionarios().get(BuscarFuncionarios().size()-1).getFunCodigo();
            MoradaDAO md = new MoradaDAO();
            md.inserir(f.getMorada(),cod++ );
           
            ps.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro na insercao");
        }
        
    }
    
    public ObservableList<Funcionario> BuscarFuncionarios() {
        ObservableList<Funcionario> f = FXCollections.observableArrayList();
        MoradaDAO md = new MoradaDAO();
        String sql = "select * from funcionario where visivel=true";
        try {
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Morada morada = new Morada();
                Funcionario fu = new Funcionario(rs.getInt("funCodigo"), rs.getString("funNome"),
                        rs.getString("funApelido"),
                        rs.getString("funTipoFuncionario"), rs.getString("funNr_bi"), rs.getString("funGenero"), rs.getString("funEstado_civil"),
                        rs.getInt("funContacto"), rs.getInt("funContacto2"), rs.getString("funEmail"),  rs.getDate("funData_nascimento"),
                        rs.getString("funCargo"), rs.getFloat("funSalario"), rs.getLong("funNr_conta"), rs.getBoolean("funAutenticavel"),md.BuscaPorCodigoFunc(rs.getInt("funCodigo")));
                
                f.add(fu);
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
      
        return f;
    }
    
    public void remover(int codigo){
       
        String sql = "UPDATE `funcionario` SET `visivel`= false WHERE funCodigo =? ";
             try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
   
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("erro: Apagar funcionario");
        }
   
    }
    
    public void editar(Funcionario f){
    
        String sql = "UPDATE `funcionario` SET `funNome`=?,`funApelido`=?,`funTipoFuncionario`=?,"
                + "`funNr_bi`=?,`funGenero`=?,`funEstado_civil`=?,`funContacto`=?"
                + ",`funContacto2`=?,`funEmail`=?,`funData_nascimento`=?,`funCargo`=?,"
                + "`funSalario`=?,`funNr_conta`=?,`funAutenticavel`=? WHERE funCodigo = '"+f.getFunCodigo()+"'";
        
        try{
          PreparedStatement ps = conexao.prepareStatement(sql);  
            
           
            ps.setString(1, f.getFunNome());
            ps.setString(2, f.getFunApelido());
            ps.setString(3, f.getFunTipoFuncionario());
            ps.setString(4, f.getFunNr_bi());
            ps.setString(5, "" + f.getFunGenero());
            ps.setString(6, f.getFunEstado_civil());
            ps.setInt(7, f.getContaco1());
            ps.setInt(8, f.getContaco2());
            ps.setString(9, f.getFunEmail());
            ps.setDate(10, (java.sql.Date) f.getFunData());
            ps.setString(11, f.getFunCargo());
            ps.setFloat(12, f.getFunSalario());
            ps.setLong(13, f.getFunNr_conta());// podera eventualmente ocorrer erro( erro de compatibilidade)
            ps.setBoolean(14, f.isFunAutenticavel());
           
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e){
         
            System.out.println(  e.getMessage());
        }
    }
    
    public static void main(String[] args) throws ParseException {
        FuncionarioDAO f = new FuncionarioDAO();
       
       // System.out.println(f.BuscarFuncionarios().get(0).getMorada().getMorAvenida());   
     
        f.editar(new Funcionario(7,"celso3","narciso","gerente","111222bi","d","solteiro",12333,1233,"@gmail",date_from_string("12/07/1999")
               ,"cargo",23.4f,222,false,new Morada("Alto mae","12","ewe")));
    }
}
