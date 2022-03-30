/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.domain;

/**
 *
 * @author doroteia
 */
public class Morada {
    
    private int idMorada;
    private String morAvenida;
    private String morQuarteirao;
    private String morRua;

    public Morada() {
    }

    public Morada(String morAvenida, String morQuarteirao, String morRua) {
        this.morAvenida = morAvenida;
        this.morQuarteirao = morQuarteirao;
        this.morRua = morRua;
    }

    
    
    public Morada(int idMorada, String morAvenida, String morQuarteirao, String morRua) {
        this.idMorada = idMorada;
        this.morAvenida = morAvenida;
        this.morQuarteirao = morQuarteirao;
        this.morRua = morRua;
    }

    public int getIdMorada() {
        return idMorada;
    }

    public void setIdMorada(int idMorada) {
        this.idMorada = idMorada;
    }

    public String getMorAvenida() {
        return morAvenida;
    }

    public void setMorAvenida(String morAvenida) {
        this.morAvenida = morAvenida;
    }

    public String getMorQuarteirao() {
        return morQuarteirao;
    }

    public void setMorQuarteirao(String morQuarteirao) {
        this.morQuarteirao = morQuarteirao;
    }

    public String getMorRua() {
        return morRua;
    }

    public void setMorRua(String morRua) {
        this.morRua = morRua;
    }
     
    
    
}
