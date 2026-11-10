package model;


import javax.persistence.*;

@Entity
@Table (name = "pedidos_produtos")

public class PedidoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_pedido_produto")
    private int idPedidoProduto;
    @Column (name = "id_produto")
    private int idProduto;
    @Column (name = "id_pedido")
    private int idPedido;
    private double precoUnitario;
    private int qtde;

    public PedidoProduto() {
    }

    public PedidoProduto(int idProduto, int idPedido, double precoUnitario, int qtde) {
        this.idProduto = idProduto;
        this.idPedido = idPedido;
        this.precoUnitario = precoUnitario;
        this.qtde = qtde;
    }

    public int getIdPedidoProduto() {
        return idPedidoProduto;
    }

    public void setIdPedidoProduto(int idPedidoProduto) {
        this.idPedidoProduto = idPedidoProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
}
