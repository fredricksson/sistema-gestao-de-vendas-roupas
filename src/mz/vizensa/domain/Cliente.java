/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.domain;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Rectangle;
import static mz.vizensa.domain.Produto.pd;

/**
 *
 * @author doroteia
 */
public class Cliente {
    private int idCliente;
    private String cliNome;
    private String cliContacto;
    private String cliemail;
    public Cliente() {
    }

    public Cliente(String cliNome, String email, String cliContacto) {
        this.cliNome = cliNome;
        this.cliContacto = cliContacto;
        this.cliemail = email;
    }

    public String getCliemail() {
        return cliemail;
    }

    public void setCliemail(String cliemail) {
        this.cliemail = cliemail;
    }
    
    
    

    public Cliente(int idCliente, String cliNome, String cliContacto) {
        this.idCliente = idCliente;
        this.cliNome = cliNome;
        this.cliContacto = cliContacto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliContacto() {
        return cliContacto;
    }

    public void setCliContacto(String cliContacto) {
        this.cliContacto = cliContacto;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", cliNome=" + cliNome + ", cliContacto=" + cliContacto + ", cliemail=" + cliemail + '}';
    }
      
    
    
    
}
