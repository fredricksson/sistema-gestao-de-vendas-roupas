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
import mz.vizensa.domain.Cliente;
import mz.vizensa.factory.Conexao;

/**
 *
 * @author doroteia
 */
public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO() {
        try {
            this.conexao = Conexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao conectou" + ex.getMessage());
        }
    }

    public void inserir(Cliente cliente) {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTE ");
        sql.append("(`cliNome`, `cliEmail`, `cliContacto`) ");
        sql.append(" values(?,?,?)");

        try {
            PreparedStatement ps = conexao.prepareStatement(sql.toString());
            ps.setString(1, cliente.getCliNome());
            ps.setString(2, cliente.getCliemail());
            ps.setString(3, cliente.getCliContacto());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
        }

    }

    public List<Cliente> listar() {
        List<Cliente> clientes = FXCollections.observableArrayList();
        String sql = "select * from cliente";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                clientes.add(new Cliente(rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;

    }
    

    public static void main(String[] args) {
        ClienteDAO cd = new ClienteDAO();
 
    }
}
