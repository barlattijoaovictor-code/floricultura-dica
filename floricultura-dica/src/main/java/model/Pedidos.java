package model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table (name = "pedidos")

public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_pedido")
    private int idPedido;
    @Column (name = "id_cliente")
    private int idCliente;
    private Date dataPedido;
    private String status;
    private double valorTotal;
    private String enderecoEntrega;

    public Pedidos() {
    }

    public Pedidos(Date dataPedido, String status, double valorTotal, String enderecoEntrega, int idCliente) {
        this.dataPedido = dataPedido;
        this.status = status;
        this.valorTotal = valorTotal;
        this.enderecoEntrega = enderecoEntrega;
        this.idCliente = idCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
}
