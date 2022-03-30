/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.domain;

import java.util.Date;

/**
 *
 * @author fred
 */
public class Utilizador extends  Funcionario {
    
    private int idUtilizador;
    private String utiSenha; 
    private String utiUtilizador; 

    public Utilizador(String utiUtilizador, String utiSenha, int funCodigo, String funNome, String funApelido, String funTipoFuncionario, String funNr_bi, String funGenero, String funEstado_civil, int contaco1, int contaco2, String funEmail, Date funData, String funCargo, float funSalario, long funNr_conta, boolean funAutenticavel, Morada morada) {
        super(funCodigo, funNome, funApelido, funTipoFuncionario, funNr_bi, funGenero, funEstado_civil, contaco1, contaco2, funEmail, funData, funCargo, funSalario, funNr_conta, funAutenticavel, morada);
        this.utiUtilizador = utiUtilizador;
        this.utiSenha = utiSenha;
    }
    
    
    
    public Utilizador(String utiSenha, String utiUtilizador) {
        this.utiSenha = utiSenha;
        this.utiUtilizador = utiUtilizador;
        
    }

    
    
    
    public int getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getUtiSenha() {
        return utiSenha;
    }

    public void setUtiSenha(String utiSenha) {
        this.utiSenha = utiSenha;
    }

    public String getUtiUtilizador() {
        return utiUtilizador;
    }

    public void setUtiUtilizador(String utiUtilizador) {
        this.utiUtilizador = utiUtilizador;
    }

    @Override
    public String toString() {
        return "Utilizador{" + "idUtilizador=" + idUtilizador + ", utiSenha=" + utiSenha + ", utiUtilizador=" + utiUtilizador + '}';
    }
      
    
    
}
