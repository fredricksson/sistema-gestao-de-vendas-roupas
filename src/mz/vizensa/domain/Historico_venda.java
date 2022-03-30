/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.domain;

import java.util.Date;

/**
 *
 * @author doroteia
 */
public class Historico_venda {
    private String funNome;
    private String cliNome;
    private Date data;
    private String hora;
    private String prodNome;
    private String prodCor;
    private int prodQuantidande;
    private Float prodPreco;

    public Historico_venda(String funNome, String cliNome, Date data, String hora, String prodNome, String prodCor, int prodQuantidande, Float prodPreco) {
        this.funNome = funNome;
        this.cliNome = cliNome;
        this.data = data;
        this.hora = hora;
        this.prodNome = prodNome;
        this.prodCor = prodCor;
        this.prodQuantidande = prodQuantidande;
        this.prodPreco = prodPreco;
    }

    public String getFunNome() {
        return funNome;
    }

    public void setFunNome(String funNome) {
        this.funNome = funNome;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getProdNome() {
        return prodNome;
    }

    public void setProdNome(String prodNome) {
        this.prodNome = prodNome;
    }

    public String getProdCor() {
        return prodCor;
    }

    public void setProdCor(String prodCor) {
        this.prodCor = prodCor;
    }

    public int getProdQuantidande() {
        return prodQuantidande;
    }

    public void setProdQuantidande(int prodQuantidande) {
        this.prodQuantidande = prodQuantidande;
    }

    public float getProdPreco() {
        return prodPreco;
    }

    public void setProdPreco(Float prodPreco) {
        this.prodPreco = prodPreco;
    }

    @Override
    public String toString() {
        return "Historico_venda{" + "funNome=" + funNome + ", cliNome=" + cliNome + ", data=" + data + ", hora=" + hora + ", prodNome=" + prodNome + ", prodCor=" + prodCor + ", prodQuantidande=" + prodQuantidande + ", prodPreco=" + prodPreco + "\n"+'}';
    }
    
    
    
    
}
