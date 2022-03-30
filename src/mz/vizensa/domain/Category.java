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
public class Category {
    
    private int category_id;
    private String catNome;

    public Category() {
    }

    public Category(String catNome) {
        this.catNome = catNome;
    }

    
    
    
    public Category(int category_id, String catNome) {
        this.category_id = category_id;
        this.catNome = catNome;
    }

    
    
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCatNome() {
        return catNome;
    }

    public void setCatNome(String catNome) {
        this.catNome = catNome;
    }

    @Override
    public String toString() {
        return "Category{" + "category_id=" + category_id + ", catNome=" + catNome + '}';
    }
    
    
}
