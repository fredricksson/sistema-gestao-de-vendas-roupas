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
public class Venda {
    
    private int idVenda;
    private Date venData_venda;
    private String venHora_venda;
    private int venQuantidade;
    private float venValor_pago;
   

    public Venda() {
    }

    public Venda( Date venData_venda, String venHora_venda, int venQuantidade, float venValor_pago) {
       
        this.venData_venda = venData_venda;
        this.venHora_venda = venHora_venda;
        this.venQuantidade = venQuantidade;
        this.venValor_pago = venValor_pago;
      
    }

    
    
    
    
    
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getVenData_venda() {
        return venData_venda;
    }

    public void setVenData_venda(Date venData_venda) {
        this.venData_venda = venData_venda;
    }

    public String getVenHora_venda() {
        return venHora_venda;
    }

    public void setVenHora_venda(String venHora_venda) {
        this.venHora_venda = venHora_venda;
    }

    public int getVenQuantidade() {
        return venQuantidade;
    }

    public void setVenQuantidade(int venQuantidade) {
        this.venQuantidade = venQuantidade;
    }

    public float getVenValor_pago() {
        return venValor_pago;
    }

    public void setVenValor_pago(float venValor_pago) {
        this.venValor_pago = venValor_pago;
    }

  
    
    
}
