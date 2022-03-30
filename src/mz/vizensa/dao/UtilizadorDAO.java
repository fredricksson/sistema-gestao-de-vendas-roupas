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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mz.vizensa.domain.Funcionario;
import mz.vizensa.domain.Morada;
import mz.vizensa.domain.Utilizador;
import mz.vizensa.factory.Conexao;

/**
 *
 * @author doroteia
 */
public class UtilizadorDAO {

    private Connection conexao;

    public UtilizadorDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou" + ex.getMessage());
        }
    }

    public void inserir(Utilizador utilizador, int funcionario_funCodigo) {
        String sql = "INSERT INTO `utilizador`( `utiSenha`, `utiUtilizador`, `Funcionario_funCodigo`) VALUES (?,?,?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, utilizador.getUtiSenha());
            ps.setString(2, utilizador.getUtiUtilizador());
            ps.setInt(3, funcionario_funCodigo);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MoradaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ObservableList<Utilizador> BuscarUtilizadores() {
        ObservableList<Utilizador> utilizadores = FXCollections.observableArrayList();

        String sql = "SELECT * FROM utilizador u JOIN funcionario f "
                + "WHERE u.Funcionario_funCodigo = f.funCodigo";
        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                MoradaDAO md = new MoradaDAO();
                Morada morada = new Morada();
                Utilizador utilizador = new Utilizador(rs.getString("utiUtilizador"),rs.getString("utiSenha"),
                        rs.getInt("funCodigo"), rs.getString("funNome"),
                        rs.getString("funApelido"),
                        rs.getString("funTipoFuncionario"), rs.getString("funNr_bi"), 
                        rs.getString("funGenero"), rs.getString("funEstado_civil"),
                        rs.getInt("funContacto"), rs.getInt("funContacto2"), 
                        rs.getString("funEmail"), rs.getDate("funData_nascimento"),
                        rs.getString("funCargo"), rs.getFloat("funSalario"), 
                        rs.getLong("funNr_conta"), rs.getBoolean("funAutenticavel"),
                        md.BuscaPorCodigoFunc(rs.getInt("funCodigo")));
                utilizador.setIdUtilizador(rs.getInt("idUtilizador"));
                utilizadores.add(utilizador);
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return utilizadores;
    }
    public static void main(String[] args) {
        UtilizadorDAO ud = new UtilizadorDAO();
        System.out.println(ud.BuscarUtilizadores().toString());
    }
}
