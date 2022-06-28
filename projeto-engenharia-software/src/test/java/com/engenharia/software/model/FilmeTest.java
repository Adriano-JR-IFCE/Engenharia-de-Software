package com.engenharia.software.model;

import com.engenharia.software.auxiliar.Mensagens;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilmeTest {
    
    public FilmeTest() {
    }
    
    //teste do construtor
    @Test
    public void testarConstrutorFilme() {
        Filme filme = new Filme();
        
        assertNotNull(filme);
    }

    //testes do setters
    @Test
    public void testarSetTituloEmBranco() {
        Filme filme = new Filme();
        
        String titulo = "";
                
         IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> filme.setTitulo(titulo));
      
         assertTrue(excecao.getMessage().contains(new Mensagens().EXCECAO_MENSAGEM_TITULO_EM_BRANCO));
    }
    
    @Test
    public void testarSetQtdAssentosNegativo() {
        Filme filme = new Filme();
        
         IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> filme.setQtdAssentos(-1));
      
         assertTrue(excecao.getMessage().contains(new Mensagens().EXCECAO_MENSAGEM_QTD_ASSENTOS_NEGATIVA));
    }
    
    //testes dos getters
    @Test
    public void testarGetTituloFilme() {
        Filme filme = new Filme();
        
        filme.setTitulo("teste");
        
        assertEquals(filme.getTitulo(), "teste");
    }
    
    @Test
    public void testarGetTituloNull() {
        Filme filme = new Filme();
        
        assertNull(filme.getTitulo());
    }
    
    //testes dos outros metodos
    
}
