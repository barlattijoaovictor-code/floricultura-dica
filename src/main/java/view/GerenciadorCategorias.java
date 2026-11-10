package view;

import dao.CategoriasDao;
import model.Categorias;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.util.List;

public class GerenciadorCategorias {
    public static void cadastrarCategorias() {
        // conexao banco
        EntityManager em = JPAUtil.getEntityManager();
        CategoriasDao categoriasDao = new CategoriasDao(em);

        String descricao = JOptionPane.showInputDialog("Qual a descrição?");

        // instanciar a classe
        Categorias categorias = new Categorias(descricao);

        em.getTransaction().begin(); // inicializa transação
        categoriasDao.cadastrar(categorias); // cadastro no banco
        em.getTransaction().commit(); // valida
        em.close(); //encerra
    }
    public static String consultarCategorias() {
        // conexao banco
        EntityManager em = JPAUtil.getEntityManager();
        CategoriasDao categoriasDao = new CategoriasDao(em);

        List<Categorias> todosRegistros = categoriasDao.buscarTodos();
        int tam = todosRegistros.size(); // total de registros
        String consulta = "ID - DESCRIÇÃO\n";
        for (int i = 0; i < tam; i++) {
            consulta += todosRegistros.get(i).getIdCategoria() + " - " +
                    todosRegistros.get(i).getDescricao() + "\n";
        }
        return consulta;
    }

    public static void alterarCategorias(int id) {
        // conexao banco
        EntityManager em = JPAUtil.getEntityManager();
        CategoriasDao categoriasDao = new CategoriasDao(em);

        Categorias categorias = categoriasDao.buscarPorId(id);
        String descricao = JOptionPane.showInputDialog("Digite a descrição");

        em.getTransaction().begin(); // inicia
        categorias.setDescricao(descricao); // altera
        em.getTransaction().commit(); // valida
        em.close(); // fecha
    }

    public static void excluirCategorias(int id) {
        // conexao banco
        EntityManager em = JPAUtil.getEntityManager();
        CategoriasDao categoriasDao = new CategoriasDao(em);

        Categorias categorias = categoriasDao.buscarPorId(id);

        em.getTransaction().begin(); // iniciar
        categoriasDao.excluir(categorias);
        em.getTransaction().commit(); // validar
        em.close();
    }


}


