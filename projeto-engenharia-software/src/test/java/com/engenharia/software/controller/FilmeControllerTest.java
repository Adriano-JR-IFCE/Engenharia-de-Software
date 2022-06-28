/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.engenharia.software.controller;

import com.engenharia.software.model.Filme;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lobonegro
 */
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
        
        filmeController.fechar();
        
        assertEquals(filmes.size(), 3);
    }
}
