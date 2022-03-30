/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.domain;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import static mz.vizensa.controller.AdicionarItensController.itens;
import mz.vizensa.dao.ProdutoDAO;

/**
 *
 * @author fred
 */
public class Produto {

    private int codigo;
    private String prodNome;
    private String prodCor;
    private float prodPreco;
    private float prodTamanho;
    private Category categoria;
    private Rectangle cor;
    private int quantidadeTotal;
    private String categor;
    private List<Tamanhos> tamanhos;
   public static ProdutoDAO pd = new ProdutoDAO();

    public Produto() {
    }

    public Produto(int codigo, String prodNome, String prodCor, float prodPreco, Category categoria) {
        this.codigo = codigo;
        this.prodNome = prodNome;
        this.prodCor = prodCor;
        this.prodPreco = prodPreco;
        this.categoria = categoria;

    }

    public Produto(int codigo, String prodNome, String prodCor, float prodPreco) {
        this.codigo = codigo;
        this.prodNome = prodNome;
        this.prodCor = prodCor;
        this.prodPreco = prodPreco;
        this.categoria = categoria;

    }
    public Produto(int codigo ,String prodNome, Rectangle prodCor,int quantidadeTotal, float prodPreco) {
        this.codigo = codigo;
        this.prodNome = prodNome;
        this.cor = prodCor;
        this.quantidadeTotal = quantidadeTotal;
        this.prodPreco = prodPreco;
        this.categoria = categoria;

    }
    
    

    public Produto(int codigo, String prodNome, String prodCor, float prodPreco, List<Tamanhos> tamanhos) {
        this.codigo = codigo;
        this.prodNome = prodNome;
        this.prodCor = prodCor;
     
        this.prodPreco = prodPreco;
        this.tamanhos = tamanhos;
    }
    public Produto(int codigo, String prodNome, Rectangle prodCor, float tamanho, float prodPreco, int quantidadeTotal) {
        this.codigo = codigo;
        this.prodNome = prodNome;
        this.cor = prodCor;
        this.quantidadeTotal = quantidadeTotal;
        this.prodTamanho = tamanho;
        this.prodPreco = prodPreco;

    }
       public float getProdTamanho() {
        return prodTamanho;
    }

    public void setProdTamanho(float prodTamanho) {
        this.prodTamanho = prodTamanho;
    }
    public String getCategor() {
        return categor;
    }

    public void setCategor(String categor) {
        this.categor = categor;
    }
    
    public Rectangle getCor() {
        return cor;
    }

    public void setCor(Rectangle cor) {
        this.cor = cor;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public float getProdPreco() {
        return prodPreco;
    }

    public void setProdPreco(float prodPreco) {
        this.prodPreco = prodPreco;
    }

    public Category getCategoria() {
        return categoria;
    }

    public void setCategoria(Category categoria) {
        this.categoria = categoria;
    }

    public List<Tamanhos> getTamanhos() {
        return tamanhos;
    }

    public void setTamanhos(List<Tamanhos> tamanhos) {
        this.tamanhos = tamanhos;
    }

  
    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", prodNome=" + prodNome + ", prodCor=" + prodCor + ", prodPreco=" + prodPreco + ", categoria=" + categoria + ", tamanhos=" + tamanhos + '}';
    }
    
    public  List<Produto> buscarTodos() {
         ArrayList<Produto> list = new ArrayList<>();
        List<Produto> produtos = pd.produto_category();
        for (Produto produto : produtos) {
             Rectangle r = new Rectangle();
             String c = produto.getProdCor().replaceFirst("0x", "");
            
           
             r.setStyle("-fx-fill:#"+c+";");
             System.out.println("estilo: "+r.getStyle());
             r.setWidth(40);
             r.setHeight(30);
     
            Produto p = new Produto(produto.getCodigo(), produto.getProdNome(),r, 54, produto.getProdPreco());
            p.setCategor(produto.getCategoria().getCatNome());
            list.add(p);
            
        }
         return list;
    }
        public static List<Produto> pesquisarPorNome(String name) {
       
         ArrayList<Produto> list = new ArrayList<>();
        List<Produto> produtos = pd.pesquisarPorNome(name);
        for (Produto produto : produtos) {
             Rectangle r = new Rectangle();
             String c = produto.getProdCor().replaceFirst("0x", "");
            
           
             r.setStyle("-fx-fill:#"+c+";");
             System.out.println("estilo: "+r.getStyle());
             r.setWidth(40);
             r.setHeight(30);
     
            Produto p = new Produto(produto.getCodigo(), produto.getProdNome(),r, 54, produto.getProdPreco());
            p.setCategor(produto.getCategoria().getCatNome());
            list.add(p);
            
        }
         return list;
       
    }
            public static List<Produto> allWithCategory(String name) {

        ArrayList<Produto> list = new ArrayList<>();
        List<Produto> produtos = pd.allWithCategory(name);
        for (Produto produto : produtos) {
            Rectangle r = new Rectangle();
            String c = produto.getProdCor().replaceFirst("0x", "");

            r.setStyle("-fx-fill:#" + c + ";");

            r.setWidth(40);
            r.setHeight(30);

            Produto p = new Produto(produto.getCodigo(), produto.getProdNome(), r, 54, produto.getProdPreco());
            p.setCategor(produto.getCategoria().getCatNome());
            list.add(p);

        }
        return list;
    }
          public static List<Produto> pesquisarPorCategoria(String categoria) {
       
         ArrayList<Produto> list = new ArrayList<>();
        List<Produto> produtos = pd.pesquisarPorCategoria(categoria);
        for (Produto produto : produtos) {
             Rectangle r = new Rectangle();
             String c = produto.getProdCor().replaceFirst("0x", "");
            
           
             r.setStyle("-fx-fill:#"+c+";");
             System.out.println("estilo: "+r.getStyle());
             r.setWidth(40);
             r.setHeight(30);
     
            Produto p = new Produto(produto.getCodigo(), produto.getProdNome(),r, 54, produto.getProdPreco());
            p.setCategor(produto.getCategoria().getCatNome());
            list.add(p);
            
        }
         return list;
       
    }
            public static List<Produto> listarItens() {

        ArrayList<Produto> list = new ArrayList<>();
        List<Produto> produtos = itens;
        for (Produto produto : produtos) {
            Rectangle r = new Rectangle();
            String c = produto.getProdCor().replaceFirst("0x", "");

            r.setStyle("-fx-fill:#" + c + ";");

            r.setWidth(40);
            r.setHeight(30);

            Produto p = new Produto(produto.getCodigo(), produto.getProdNome(), r, produto.getProdTamanho(), produto.getProdPreco(), produto.getQuantidadeTotal());

            p.setCategor(produto.getCategoria().getCatNome());
            list.add(p);

        }
        return list;
    }
    public static Produto item(int cod) {

        Produto produtos = pd.pesquisarPorCodigo(cod);
         
        return produtos;
    }


    
}
