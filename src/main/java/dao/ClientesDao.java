package dao;


import model.Clientes;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientesDao {
    private EntityManager em;


    public ClientesDao(EntityManager em) {
        this.em = em;
    }

    // cadastrar
    public void cadastrar(Clientes clientes) {
        this.em.persist(clientes);
    }

    //consultar
    public List<Clientes> buscarTodos() {
        String jpql = "SELECT u FROM Clientes u";
        return em.createQuery(jpql, Clientes.class).getResultList();
    }

    // alterar
    public Clientes buscarPorId(int id) {
        return em.find(Clientes.class, id);
    }

    public void alterar(Clientes clientes) {
        this.em.merge(clientes);
    }

    // excluir
    public void excluir(Clientes clientes) {
        this.em.merge(clientes);
        this.em.remove(clientes);
    }
}
