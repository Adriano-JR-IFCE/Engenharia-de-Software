package com.engenharia.software.controller;

import com.engenharia.software.auxiliar.Mensagens;
import com.engenharia.software.model.Filme;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FilmeController {
    //atributos - jpa
    EntityManagerFactory fabrica;
    EntityManager gerenciador;
    
    //construtor
    public FilmeController() {
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
    public void salvarFilme(Filme filme) {
        gerenciador.getTransaction().begin();
            gerenciador.persist(filme);
        gerenciador.getTransaction().commit();
    }
    
    public List<Filme> todosFilmes() {
        String jpql = "select f from Filme f";
        
        TypedQuery typedQuery = gerenciador.createQuery(jpql, Filme.class);
        List<Filme> filmes = typedQuery.getResultList();
        
        return filmes;
    }
    
    public Filme filme(Long id) {
        if (id < 0)
            throw new IllegalArgumentException(new Mensagens().EXCECAO_MENSAGEM_ID_INVALIDO);
        
        Filme filme = gerenciador.find(Filme.class, id);
       
        return filme;
    }
    
    public void atualizarFilme(Filme filme) {
        gerenciador.getTransaction().begin();
            gerenciador.merge(filme);
        gerenciador.getTransaction().commit();
    }
    
    public void removerFilme(Filme filme) {
        gerenciador.getTransaction().begin();
            gerenciador.remove(filme);
        gerenciador.getTransaction().commit();
    }
}
