package model;

import javax.persistence.*;

@Entity
@Table(name = "produtos")


public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private int idProduto;
    @Column(name = "id_categoria")
    private int idCategoria;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;

    public Produtos() {
    }

    public Produtos(int estoque, double preco, String descricao, String nome, int idCategoria) {
        this.estoque = estoque;
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
        this.idCategoria = idCategoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}
