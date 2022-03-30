/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.domain;

import java.util.ArrayList;
import java.util.List;
import mz.vizensa.dao.ProdutoDAO;

/**
 *
 * @author doroteia
 */
public class Tamanhos {

    private int Quantidade;
    private float tamanho;
    private int codigo;

    public Tamanhos() {
    }
    public static ProdutoDAO pd = new ProdutoDAO();
    public static List<Tamanhos> tamanhos = pd.listTamanhos();

    public Tamanhos(int Quantidade, float tamanho, int codigo) {
        this.Quantidade = Quantidade;
        this.tamanho = tamanho;
        this.codigo = codigo;
    }

    public Tamanhos(float tamanho, int Quantidade) {
        this.Quantidade = Quantidade;
        this.tamanho = tamanho;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static List<Tamanhos> Todostamanhos(int cod) {
        ArrayList<Tamanhos> list = new ArrayList<>();

        for (Tamanhos tamanh : tamanhos) {
            if (tamanh.getCodigo() == cod) {
                list.add(new Tamanhos(tamanh.getTamanho(), tamanh.getQuantidade()));
            }
        }
        return list;
    }

}
