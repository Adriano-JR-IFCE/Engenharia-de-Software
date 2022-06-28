package com.engenharia.software.controller;

import com.engenharia.software.model.Venda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class VendaController {
    //atributos - jpa
    EntityManagerFactory fabrica;
    EntityManager gerenciador;
    
    //construtor
    public VendaController() {
        this.fabrica = Persistence.createEntityManagerFactory("persistence_unit_projeto_engenharia_software");
        this.gerenciador = fabrica.createEntityManager();
    }
    
    //setters
    public void setFabrica(EntityManagerFactory fabrica) {
        this.fabrica = fabrica;
    }
    
    public void setGerenciador(EntityManager gerenciador) {
        this.gerenciador = gerenciador;
    }
    
    //getters
    public EntityManagerFactory getFabrica() {
        return this.fabrica;
    }
    
    public EntityManager getGerenciador() {
        return this.gerenciador;
    }
    
    //fechar
    public void fechar() {
        gerenciador.close();
        fabrica.close();
    }
    
    //outros metodos
    public void salvarVenda(Venda venda) {
        gerenciador.getTransaction().begin();
            gerenciador.persist(venda);
        gerenciador.getTransaction().commit();
    }
    
    public List<Venda> todasVendas() {
        String jpql = "select v from Venda v";
        
        TypedQuery typedQuery = gerenciador.createQuery(jpql, Venda.class);
        List<Venda> vendas = typedQuery.getResultList();
        
        return vendas;
    }
    
    public Venda venda(Long id) {
        Venda  venda = gerenciador.find(Venda.class, id);
       
        return venda;
    }
    
    public void atualizarVenda(Venda venda) {
        gerenciador.getTransaction().begin();
            gerenciador.merge(venda);
        gerenciador.getTransaction().commit();
    }
    
    public void removerVenda(Venda venda) {
        gerenciador.getTransaction().begin();
            gerenciador.remove(venda);
        gerenciador.getTransaction().commit();
    }
}
