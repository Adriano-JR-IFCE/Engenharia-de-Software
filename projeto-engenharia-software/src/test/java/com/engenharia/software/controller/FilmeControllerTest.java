/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.engenharia.software.controller;

import com.engenharia.software.model.Filme;
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
}
