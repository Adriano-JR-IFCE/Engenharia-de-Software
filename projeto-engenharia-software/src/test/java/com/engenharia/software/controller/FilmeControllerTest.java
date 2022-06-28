package com.engenharia.software.controller;

import com.engenharia.software.model.Filme;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilmeControllerTest {
    
    public FilmeControllerTest() {
    }
   
    @Test
    public void testarConstrutorFilmeController() {
        FilmeController filmeController = new FilmeController();
        
        assertNotNull(filmeController);
    }
    
    @Test
    public void testarSeConstrutorCriaFabricaGerenciador() {
        FilmeController filmeController = new FilmeController();
        
        assertNotNull(filmeController.getFabrica());
        assertNotNull(filmeController.getGerenciador());
    }
    
    @Test
    public void testarFechar() {
        FilmeController filmeController = new FilmeController();
        
        filmeController.fechar();
        
        assertFalse(filmeController.getFabrica().isOpen());
        assertFalse(filmeController.getGerenciador().isOpen());
    }
    
    @Test
    public void testarSalvarFilme() {
        Filme filme = new Filme();
        
        filme.setTitulo("teste");
        filme.setQtdAssentos(30);
        filme.setPrecoIngresso(10.00);
        
        FilmeController filmeController = new FilmeController();
        
        filmeController.salvarFilme(filme);
        
        assertNotNull(filme.getId());
    }
    
    @Test
    public void testarTodosFilmes() {
        Filme filme1 = new Filme();
        filme1.setTitulo("teste");
        filme1.setQtdAssentos(30);
        filme1.setPrecoIngresso(10.00);
        
        Filme filme2 = new Filme();
        filme2.setTitulo("teste");
        filme2.setQtdAssentos(30);
        filme2.setPrecoIngresso(10.00);
        
        Filme filme3 = new Filme();
        filme3.setTitulo("teste");
        filme3.setQtdAssentos(30);
        filme3.setPrecoIngresso(10.00);
        
        FilmeController filmeController = new FilmeController();
        
        filmeController.salvarFilme(filme1);
        filmeController.salvarFilme(filme2);
        filmeController.salvarFilme(filme3);
        
        List<Filme> filmes = filmeController.todosFilmes();
                
        assertEquals(filmes.size(), 3);
    }
    
    @Test
    public void testarFilmeIdInvalido() {
        FilmeController filmeController = new FilmeController();
        
        Filme filme = filmeController.filme(-1l);
        
        assertNull(filme);
    }
    
    @Test
    public void testarFilmeId() {
        FilmeController filmeController = new FilmeController();
        
        Filme filme = new Filme();
        filme.setTitulo("teste");
        filme.setQtdAssentos(30);
        filme.setPrecoIngresso(10.00);
        
        filmeController.salvarFilme(filme);
        
        Filme filmeRetornado = filmeController.filme(filme.getId());
        
        assertEquals(filmeRetornado.getId(), filme.getId());
    }
    
    @Test
    public void testarRemoverFilme() {
        FilmeController filmeController = new FilmeController();
        
        Filme filme = new Filme();
        filme.setTitulo("test");
        filme.setQtdAssentos(1);
        filme.setPrecoIngresso(1.00);
        
        filmeController.salvarFilme(filme);
        
        Long id = filme.getId();
        
        filme = filmeController.filme(id);
        
        filmeController.removerFilme(filme);
        
        filme = filmeController.filme(id);
                
        assertNull(filme);
    }
    
    @Test
    public void testarAtualizarFilme() {
        FilmeController filmeController = new FilmeController();
        
        Filme filme = new Filme();
        filme.setTitulo("test");
        filme.setQtdAssentos(1);
        filme.setPrecoIngresso(1.00);
        
        filmeController.salvarFilme(filme);
        
        filme = filmeController.filme(filme.getId());
        
        filme.setTitulo("teste");
        filme.setQtdAssentos(2);
        filme.setPrecoIngresso(2.00);
        
        filmeController.atualizarFilme(filme);
        
        assertEquals(filme.getTitulo(), "teste");
        assertEquals(filme.getQtdAssentos(), 2);
        assertEquals(filme.getPrecoIngresso(), 2.00);
        
        filmeController.removerFilme(filme);
    }
}
