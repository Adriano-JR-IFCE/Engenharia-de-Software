package com.engenharia.software.model;

import com.engenharia.software.auxiliar.Mensagens;
import java.util.Date;
import java.text.DateFormat;
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
    
    @Test
    public void testarSetDataVenda() {
        Venda venda = new Venda();
        
        venda.setDataVenda(new Date());
    }
    
    //getters
    @Test
    public void testarGetTituloPreenchido() {
        Venda venda = new Venda();
        
        venda.setTitulo("teste");
        
        assertEquals(venda.getTitulo(), "teste");
    }
    
    @Test
    public void testarGetTituloNaoPreenchido() {
        Venda venda = new Venda();
                
        assertNull(venda.getTitulo());
    }
    
    @Test
    public void testarGetQtdAssentosPreenchido() {
        Venda venda = new Venda();
        
        venda.setQtdAssentos(10);
        
        assertEquals(venda.getQtdAssentos(), 10);
    }
    
    @Test
    public void testarGetQtdAssentosNaoPreenchido() {
        Venda venda = new Venda();
                
        assertEquals(venda.getQtdAssentos(), 0);
    }
    
    @Test
    public void testarGetTotalPreenchido() {
        Venda venda = new Venda();
        
        venda.setTotal(10.00);
        
        assertEquals(venda.getTotal(), 10.00);
    }
    
    @Test
    public void testarGetTotalNaoPreenchido() {
        Venda venda = new Venda();
                
        assertEquals(venda.getQtdAssentos(), 0.00);
    }
    
    @Test
    public void testarGetDataVendaPreenchida() {
        Venda venda = new Venda();
        
        venda.setDataVenda(new Date());
        
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
        
        assertEquals(formato.format(venda.getDataVenda()), formato.format(new Date()));
    }
    
    @Test
    public void testarGetDataVendaNaoPreenchida() {
        Venda venda = new Venda();
        
        assertNull(venda.getDataVenda());
    }
    
    //outros metodos
    public void testarToStringPreenchido() {
        Venda venda = new Venda();
        
        venda.setId(1l);
        venda.setTitulo("teste");
        venda.setQtdAssentos(1);
        venda.setTotal(1);
        
        String textoEsperado = String.format("ID: 1%nFilme: teste%nQtd. Assentos: 1%nTotal: 1.00%n");
        
        assertEquals(venda.toString(), textoEsperado);
    }
    
    public void testarToStringNaoPreenchido() {
        Venda venda = new Venda();
        
        String textoEsperado = String.format("ID: null%nFilme: null%nQtd. Assentos: 0%nTotal: 0.00%n");
        
        assertEquals(venda.toString(), textoEsperado);
    }
}
