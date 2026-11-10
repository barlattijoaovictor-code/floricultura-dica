package dao;

import model.Clientes;
import model.Produtos;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutosDao {
    private EntityManager em;

    public ProdutosDao(EntityManager em) {
        this.em = em;
    }

    // cadastrar
    public void cadastrar(Produtos produtos) {
        this.em.persist(produtos);
    }

    //consultar
    public List<Produtos> buscarTodos() {
        String jpql = "SELECT u FROM Produtos u";
        return em.createQuery(jpql, Produtos.class).getResultList();
    }

    // alterar
    public Produtos buscarPorId(int id) {
        return em.find(Produtos.class, id);
    }

    public void alterar(Produtos produtos) {
        this.em.merge(produtos);
    }

    // excluir
    public void excluir(Produtos produtos) {
        this.em.merge(produtos);
        this.em.remove(produtos);
    }
}


