package view;

import dao.ClientesDao;
import model.Clientes;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.util.List;

public class GerenciadorClientes {

    public static void cadastrarClientes() {

        // conexao banco
        EntityManager em = JPAUtil.getEntityManager();
        ClientesDao clientesDao = new ClientesDao(em);

        String nome = JOptionPane.showInputDialog("Digite o nome:");
        String email = JOptionPane.showInputDialog("Digite o email:");
        String telefone = JOptionPane.showInputDialog("Digite o telefone:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF:");

        // instanciar a classe
        Clientes clientes = new Clientes(nome, email, telefone, cpf);

        em.getTransaction().begin(); // inicia transação
        clientesDao.cadastrar(clientes); // cadastra no banco
        em.getTransaction().commit(); // confirma
        em.close(); // encerra
    }


    public static String consultarClientes() {

        // conexao banco
        EntityManager em = JPAUtil.getEntityManager();
        ClientesDao clientesDao = new ClientesDao(em);

        List<Clientes> todosRegistros = clientesDao.buscarTodos();

        int tam = todosRegistros.size();

        String consulta = "ID - NOME - EMAIL - TELEFONE - CPF\n";

        for (int i = 0; i < tam; i++) {

            consulta += todosRegistros.get(i).getIdCliente() + " - " +
                    todosRegistros.get(i).getNome() + " - " +
                    todosRegistros.get(i).getEmail() + " - " +
                    todosRegistros.get(i).getTelefone() + " - " +
                    todosRegistros.get(i).getCpf() + "\n";
        }

        em.close();

        return consulta;
    }


    public static void alterarClientes(int id) {

        // conexao banco
        EntityManager em = JPAUtil.getEntityManager();
        ClientesDao clientesDao = new ClientesDao(em);

        Clientes clientes = clientesDao.buscarPorId(id);

        String nome = JOptionPane.showInputDialog("Digite o nome:");
        String email = JOptionPane.showInputDialog("Digite o email:");
        String telefone = JOptionPane.showInputDialog("Digite o telefone:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF:");

        em.getTransaction().begin();

        clientes.setNome(nome);
        clientes.setEmail(email);
        clientes.setTelefone(telefone);
        clientes.setCpf(cpf);

        em.getTransaction().commit();

        em.close();
    }


    public static void excluirClientes(int id) {

        // conexao banco
        EntityManager em = JPAUtil.getEntityManager();
        ClientesDao clientesDao = new ClientesDao(em);

        Clientes clientes = clientesDao.buscarPorId(id);

        em.getTransaction().begin();

        clientesDao.excluir(clientes);

        em.getTransaction().commit();

        em.close();
    }
}