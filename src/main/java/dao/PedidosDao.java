package dao;

import model.Pedidos;
import model.Produtos;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidosDao {
    private EntityManager em;

    public PedidosDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Pedidos pedidos) {
        this.em.persist(pedidos);
    }

    //consultar
    public List<Pedidos> buscarTodos() {
        String jpql = "SELECT u FROM Pedidos u";
        return em.createQuery(jpql, Pedidos.class).getResultList();
    }

    // alterar
    public Pedidos buscarPorId(int id) {
        return em.find(Pedidos.class, id);
    }

    public void alterar(Pedidos pedidos) {
        this.em.merge(pedidos);
    }

    // excluir
    public void excluir(Pedidos pedidos) {
        this.em.merge(pedidos);
        this.em.remove(pedidos);
    }
}
