package com.engenharia.software.model;

import com.engenharia.software.auxiliar.Mensagens;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VendaTest {
    
    public VendaTest() {
    }

    //construtor
    @Test
    public void testarConstrutorVenda() {
        Venda venda = new Venda();
        
        assertNotNull(venda);
    }
    
    //setters
    @Test
    public void testarSetTituloEmBranco() {
        Venda venda = new Venda();
        
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> venda.setTitulo(""));
        
        assertTrue(excecao.getMessage().contains(new Mensagens().EXCECAO_MENSAGEM_TITULO_EM_BRANCO));
    }
    
    @Test
    public void testarSetQtdAssentosNulo() {
        Venda venda = new Venda();
        
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> venda.setQtdAssentos(0));
        
        assertTrue(excecao.getMessage().contains(new Mensagens().EXCECAO_MENSAGEM_QTD_ASSENTOS_NEGATIVA_OU_NULA));
    }
    
    @Test
    public void testarSetQtdAssentosNegativa() {
        Venda venda = new Venda();
        
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> venda.setQtdAssentos(-1));
        
        assertTrue(excecao.getMessage().contains(new Mensagens().EXCECAO_MENSAGEM_QTD_ASSENTOS_NEGATIVA_OU_NULA));
    }
    
    @Test
    public void testarSetTotalNulo() {
        Venda venda = new Venda();
        
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> venda.setTotal(0));
        
        assertTrue(excecao.getMessage().contains(new Mensagens().EXCECAO_MENSAGEM_TOTAL_NEGATIVO_OU_NULO));
    }
    
    @Test
    public void testarSetTotalNegativo() {
        Venda venda = new Venda();
        
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> venda.setTotal(-1));
        
        assertTrue(excecao.getMessage().contains(new Mensagens().EXCECAO_MENSAGEM_TOTAL_NEGATIVO_OU_NULO));
    }
}
