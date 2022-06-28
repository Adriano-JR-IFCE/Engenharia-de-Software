package com.engenharia.software.model;

import com.engenharia.software.auxiliar.Mensagens;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilmeTest {
    
    public FilmeTest() {
    }

    //testes do setters
    @Test
    public void testarConstrutorFilme() {
        Filme filme = new Filme();
        
        assertNotNull(filme);
    }
    
    @Test
    public void testarSetTituloEmBranco() {
        Filme filme = new Filme();
        
        String titulo = "";
                
         IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> filme.setTitulo(titulo));
      
         assertTrue(excecao.getMessage().contains(new Mensagens().EXCECAO_MENSAGEM_TITULO_EM_BRANCO));
    }
    
    //testes dos getters
    
    //testes dos outros metodos
    
}
