package dao;

import model.PedidoProduto;
import model.Produtos;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidoProdutoDao {
    private EntityManager em;

    public PedidoProdutoDao(EntityManager em) {
        this.em = em;
    }
    // cadastrar
    public void cadastrar(PedidoProduto pedidoProduto) {
        this.em.persist(pedidoProduto);
    }

    //consultar
    public List<PedidoProduto> buscarTodos() {
        String jpql = "SELECT u FROM PedidoProduto u";
        return em.createQuery(jpql, PedidoProduto.class).getResultList();
    }

    // alterar
    public PedidoProduto buscarPorId(int id) {
        return em.find(PedidoProduto.class, id);
    }

    public void alterar(PedidoProduto pedidoProduto) {
        this.em.merge(pedidoProduto);
    }

    // excluir
    public void excluir(PedidoProduto pedidoProduto) {
        this.em.merge(pedidoProduto);
        this.em.remove(pedidoProduto);
    }
}
