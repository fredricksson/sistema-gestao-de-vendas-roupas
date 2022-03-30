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
public class produto_has_category {
    
    //chaves estrageiras
    private  int produto_codigo;
    private  int category_id;

    public produto_has_category() {
    }

    
    
    public produto_has_category(int produto_codigo, int category_id) {
        this.produto_codigo = produto_codigo;
        this.category_id = category_id;
    }

    public int getProduto_codigo() {
        return produto_codigo;
    }

    public void setProduto_codigo(int produto_codigo) {
        this.produto_codigo = produto_codigo;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    
    
    
}
