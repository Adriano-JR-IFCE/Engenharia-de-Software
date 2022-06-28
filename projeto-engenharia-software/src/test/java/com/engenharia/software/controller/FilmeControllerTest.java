/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.engenharia.software.controller;

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
    public void testarSeConstrutorCriaFabricaGerenciado() {
        FilmeController filmeController = new FilmeController();
        
        assertNotNull(filmeController.getFabrica());
        assertNotNull(filmeController.getGerenciador());
    }
    
    @Test
    public void testarFechar() {
        FilmeController filmeController = new FilmeController();
        
        filmeController.fechar();
        
        assertNull(filmeController.getFabrica());
        assertNull(filmeController.getGerenciador());
    }
}
