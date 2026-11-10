package dao;

import model.Categorias;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriasDao {
    private EntityManager em;

    // construtor
    public CategoriasDao(EntityManager em) {
        this.em = em;
    }
    // cadastrar
    public void cadastrar(Categorias categoria) {
        this.em.persist(categoria);
    }
    //consultar
    public List<Categorias> buscarTodos() {
        String jpql = "SELECT u FROM Categorias u";
        return em.createQuery(jpql,Categorias.class).getResultList();
    }
    // alterar
    public Categorias buscarPorId(int id) {
        return em.find(Categorias.class,id);
    }
    public void alterar(Categorias categoria) {
        this.em.merge(categoria);
    }
    // excluir
    public void excluir(Categorias categoria) {
        this.em.merge(categoria);
        this.em.remove(categoria);
    }
}
