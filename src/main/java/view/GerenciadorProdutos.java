package view;

import dao.CategoriasDao;
import dao.ProdutosDao;
import model.Categorias;
import model.Produtos;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.util.List;

public class GerenciadorProdutos {
    public static void cadastrarProdutos() {
        EntityManager em = JPAUtil.getEntityManager();
        ProdutosDao produtosDao = new ProdutosDao(em);

        // atributos
        String nome = JOptionPane.showInputDialog("Digite o  produto");
        String descricao = JOptionPane.showInputDialog("Digite a descrição do produto");
        int qtde = Integer.parseInt(JOptionPane.showInputDialog(
                "Qual a quantidade em estoque?"));
        double preco = Double.parseDouble(JOptionPane.showInputDialog(
                "Informe o preço unitário"));
        String consulta = GerenciadorCategorias.consultarCategorias();
        int idCategoria = Integer.parseInt(JOptionPane.showInputDialog(
                consulta + "\nEscolha a categoria desejado"));
        // instanciar a classe Produto
        Produtos produto = new Produtos(qtde, preco, descricao, nome, idCategoria);

        em.getTransaction().begin(); // inicializar a transacao
        produtosDao.cadastrar(produto);
        em.getTransaction().commit(); // validação
        em.close();


    }

    public static String consultarProdutos() {
        EntityManager em = JPAUtil.getEntityManager();
        ProdutosDao produtosDao = new ProdutosDao(em);
        CategoriasDao categoriasDao = new CategoriasDao(em);

        List<Produtos> todosRegistros = produtosDao.buscarTodos();
        int tam = todosRegistros.size(); //tamanho da lista
        String consulta = "ID \t NOME \t QTDE \t PREÇO \t TIPO \n";

        for (int i = 0; i < tam; i++) {
            Categorias categorias = categoriasDao.buscarPorId(todosRegistros.get(i).getIdCategoria());
            consulta += todosRegistros.get(i).getIdCategoria() + " \t " +
                    todosRegistros.get(i).getNome() + " \t " +
                    todosRegistros.get(i).getEstoque() + " \t " +
                    todosRegistros.get(i).getPreco() + " \t " +
                    categorias.getDescricao() + "\n";

        }
        return consulta;
    }

    public static void excluirProdutos(int id) {
        // conexao banco
        EntityManager em = JPAUtil.getEntityManager();
        ProdutosDao produtosDao = new ProdutosDao(em);

        Produtos produtos = produtosDao.buscarPorId(id);

        em.getTransaction().begin(); // iniciar
        produtosDao.excluir(produtos);
        em.getTransaction().commit(); // validar
        em.close();
    }

    public static void alterarProdutos(int id) {
        // conexao banco
        EntityManager em = JPAUtil.getEntityManager();
        ProdutosDao produtosDao = new ProdutosDao(em);

        Produtos produtos = produtosDao.buscarPorId(id);
        String nome = JOptionPane.showInputDialog("Digite o  produto");
        int qtde = Integer.parseInt(JOptionPane.showInputDialog(
                "Qual a quantidade em estoque?"));
        double preco = Double.parseDouble(JOptionPane.showInputDialog(
                "Informe o preço unitário"));
        String consulta = GerenciadorCategorias.consultarCategorias();
        int idTipo = Integer.parseInt(JOptionPane.showInputDialog(
                consulta + "\nEscolha o Tipo desejado"));

        em.getTransaction().begin(); // inicia
        produtos.setNome(nome);
        produtos.setEstoque(qtde);
        produtos.setPreco(preco);
        produtos.setIdProduto(idTipo);// altera
        em.getTransaction().commit(); // valida
        em.close(); // fecha
    }
}





