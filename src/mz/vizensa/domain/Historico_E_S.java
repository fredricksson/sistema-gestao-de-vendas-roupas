/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.domain;

import java.util.Date;

/**
 * historico de entrada e saida
 * @author Fredricksson and Francisco
 */
public class Historico_E_S {
    
    private String nomeFunc;
    
    private Date data;
    private int idHistorico;
    private String hisHora;// hora de entrada
    private String hisSaida;
    private int funCodigo;

    public Historico_E_S() {
    }

    public Historico_E_S(String nomeFunc,Date data, String hisHora, String hisSaida,int funCodigo) {
        this.data = data;
        this.nomeFunc = nomeFunc;
        this.hisHora = hisHora;
        this.hisSaida = hisSaida;
        this.funCodigo = funCodigo;
    }

    public Historico_E_S(Date data, String hisHora, String hisSaida, int funCodigo) {
        this.data = data;
        this.hisHora = hisHora;
        this.hisSaida = hisSaida;
        this.funCodigo = funCodigo;
    }



    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public String getHisHora() {
        return hisHora;
    }

    public void setHisHora(String hisHora) {
        this.hisHora = hisHora;
    }

    public String getHisSaida() {
        return hisSaida;
    }

    public void setHisSaida(String hisSaida) {
        this.hisSaida = hisSaida;
    }

    public int getFunCodigo() {
        return funCodigo;
    }

    public void setFunCodigo(int funCodigo) {
        this.funCodigo = funCodigo;
    }

    @Override
    public String toString() {
        return "Historico_E_S{" + "nomeFunc=" + nomeFunc + ", data=" + data + ", idHistorico=" + idHistorico + ", hisHora=" + hisHora + ", hisSaida=" + hisSaida + ", funCodigo=" + funCodigo + "\n"+'}';
    }
    
    
}

