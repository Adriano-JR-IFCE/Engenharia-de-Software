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
    
    @Test
    public void testarSetPrecoIngressoNegativo() {
        Filme filme = new Filme();
        
         IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> filme.setPrecoIngresso(-1));
      
         assertTrue(excecao.getMessage().contains(new Mensagens().EXCECAO_MENSAGEM_PRECO_INGRESSO_NEGATIVO));
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
    
    @Test
    public void testarGetQtdAssentos() {
        Filme filme = new Filme();
        
        filme.setQtdAssentos(10);
        
        assertEquals(filme.getQtdAssentos(), 10);
    }
    
    @Test
    public void testarGetQtdAssentosSemPreenchimentoQtdAssentos() {
        Filme filme = new Filme();
        
        assertEquals(filme.getQtdAssentos(), 0);
    }
    
    @Test
    public void testarGetPrecoIngressoSemPreenchimentoPrecoIngresso() {
        Filme filme = new Filme();
        
        assertEquals(filme.getPrecoIngresso(), 0);
    }
    
    @Test
    public void testarGetPrecoIngresso() {
        Filme filme = new Filme();
        
        filme.setPrecoIngresso(10.00);
        
        assertEquals(filme.getPrecoIngresso(), 10.00);
    }
    
    //testes dos outros metodos
    public void testarToStringFilmeNaoPreenchido() {
        Filme filme = new Filme();
        
        String textoEsperado = String.format("ID: null%nTitulo: null%nQtd. Assentos: 0%nPreco Ingresso: 0.00%n");
        
        assertEquals(filme.toString(), textoEsperado);
    }
}
