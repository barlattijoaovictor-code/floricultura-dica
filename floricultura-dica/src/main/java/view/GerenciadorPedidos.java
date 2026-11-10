package view;


import dao.PedidosDao;
import dao.ProdutosDao;

import model.Pedidos;
import model.Produtos;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GerenciadorPedidos {
    public static void cadastrarPedidos() {
        // conexao banco
        EntityManager em = JPAUtil.getEntityManager();
        PedidosDao pedidosDao = new PedidosDao(em);

        Date dataPedido;
        String resultado = JOptionPane.showInputDialog(null, "Digite a data");

        try {
            dataPedido = new SimpleDateFormat("yyyy/MM/dd").parse(resultado);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }

        // Status do pedido
        String status = JOptionPane.showInputDialog("Digite o status:");

// Valor total
        double valorTotal = Double.parseDouble(
                JOptionPane.showInputDialog("Digite o valor total:")
        );

// Endereço de entrega
        String enderecoEntrega = JOptionPane.showInputDialog(
                "Digite o endereço de entrega:"
        );

// ID do cliente
        int idCliente = Integer.parseInt(
                JOptionPane.showInputDialog("Digite o ID do cliente:")
        );

        // instanciar a classe
        Pedidos pedidos = new Pedidos(dataPedido,
                status,
                valorTotal,
                enderecoEntrega,
                idCliente);

        em.getTransaction().begin(); // inicializa transação
        pedidosDao.cadastrar(pedidos); // cadastro no banco
        em.getTransaction().commit(); // valida
        em.close(); //encerra
    }

    public static String consultarPedidos() {
        EntityManager em = JPAUtil.getEntityManager();
        PedidosDao pedidosDao = new PedidosDao(em);


        List<Pedidos> todosRegistros = pedidosDao.buscarTodos();
        int tam = todosRegistros.size(); //tamanho da lista
        String consulta = "ID \t DATA \t STATUS \t PREÇO \t ENDEREÇO \t IDCLIENTE \n";

        for (int i = 0; i < tam; i++) {
            Pedidos pedidos = pedidosDao.buscarPorId(todosRegistros.get(i).getIdPedido());
            consulta += todosRegistros.get(i).getIdPedido() + " \t " +
                    todosRegistros.get(i).getDataPedido() + " \t " +
                    todosRegistros.get(i).getStatus() + " \t " +
                    todosRegistros.get(i).getValorTotal() + " \t " +
                    todosRegistros.get(i).getEnderecoEntrega() + " \t " +
                    todosRegistros.get(i).getIdCliente() + "\n";


        }
        return consulta;
    }

    public static void excluirPedidos(int id) {
        // conexao banco
        EntityManager em = JPAUtil.getEntityManager();
        PedidosDao pedidosDao = new PedidosDao(em);

        Pedidos pedidos = pedidosDao.buscarPorId(id);

        em.getTransaction().begin(); // iniciar
        pedidosDao.excluir(pedidos);
        em.getTransaction().commit(); // validar
        em.close();
    }



}
