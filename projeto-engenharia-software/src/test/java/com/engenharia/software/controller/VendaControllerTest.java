package com.engenharia.software.controller;

import com.engenharia.software.model.Venda;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VendaControllerTest {
    
    public VendaControllerTest() {
    }

    @Test
    public void testarConstrutorVendaController() {
        VendaController vendaController = new VendaController();
        
        assertNotNull(vendaController);
    }
    
    @Test
    public void testarSeConstrutorCriaFabricaGerenciador() {
        VendaController vendaController = new VendaController();
        
        assertNotNull(vendaController.getFabrica());
        assertNotNull(vendaController.getGerenciador());
    }
    
    @Test
    public void testarFechar() {
        VendaController vendaController = new VendaController();
        
        vendaController.fechar();
        
        assertFalse(vendaController.getFabrica().isOpen());
        assertFalse(vendaController.getGerenciador().isOpen());
    }
    
    @Test
    public void testarSalvarVenda() {
        Venda venda = new Venda();
        
        venda.setTitulo("teste");
        venda.setQtdAssentos(30);
        venda.setTotal(10.00);
        venda.setDataVenda(new Date());
        
        VendaController vendaController = new VendaController();
        
        vendaController.salvarVenda(venda);
        
        assertNotNull(venda.getId());
        
        vendaController.removerVenda(venda);
    }
    
    @Test
    public void testarTodasVendas() {
        Venda venda1 = new Venda();
        venda1.setTitulo("teste");
        venda1.setQtdAssentos(30);
        venda1.setTotal(10.00);
        venda1.setDataVenda(new Date());
        
        Venda venda2 = new Venda();
        venda2.setTitulo("teste");
        venda2.setQtdAssentos(30);
        venda2.setTotal(10.00);
        venda2.setDataVenda(new Date());
        
        Venda venda3 = new Venda();
        venda3.setTitulo("teste");
        venda3.setQtdAssentos(30);
        venda3.setTotal(10.00);
        venda3.setDataVenda(new Date());
        
        
        VendaController vendaController = new VendaController();
        
        vendaController.salvarVenda(venda1);
        vendaController.salvarVenda(venda2);
        vendaController.salvarVenda(venda3);
        
        List<Venda> vendas = vendaController.todasVendas();
                
        assertEquals(vendas.size(), 3);
    }
    
    @Test
    public void testarVendaIdInvalido() {
        VendaController vendaController = new VendaController();
        
        Venda venda = vendaController.venda(-1l);
        
        assertNull(venda);
    }
    
    @Test
    public void testarVendaId() {
        VendaController vendaController = new VendaController();
        
        Venda venda = new Venda();
        venda.setTitulo("teste");
        venda.setQtdAssentos(30);
        venda.setTotal(10.00);
        venda.setDataVenda(new Date());
        
        vendaController.salvarVenda(venda);
        
        Venda vendaRetornada = vendaController.venda(venda.getId());
        
        assertEquals(vendaRetornada.getId(), venda.getId());
        
        vendaController.removerVenda(venda);
    }
    
    @Test
    public void testarRemoverVenda() {
        VendaController vendaController = new VendaController();
        
        Venda venda = new Venda();
        venda.setTitulo("teste");
        venda.setQtdAssentos(30);
        venda.setTotal(10.00);
        venda.setDataVenda(new Date());

        vendaController.salvarVenda(venda);
        
        Long id = venda.getId();
        
        venda = vendaController.venda(id);
        
        vendaController.removerVenda(venda);
        
        venda = vendaController.venda(id);
                
        assertNull(venda);
    }
    
    @Test
    public void testarAtualizarVenda() {        
        VendaController vendaController = new VendaController();
        
        Venda venda = new Venda();
        venda.setTitulo("test");
        venda.setQtdAssentos(30);
        venda.setTotal(10.00);
        venda.setDataVenda(new Date());

        vendaController.salvarVenda(venda);
                
        venda = vendaController.venda(venda.getId());
        
        venda.setTitulo("teste");
        venda.setQtdAssentos(3);
        venda.setTotal(15.00);
        Date data = new Date();
        venda.setDataVenda(data);
        
        vendaController.atualizarVenda(venda);
        
        assertEquals(venda.getTitulo(), "teste");
        assertEquals(venda.getQtdAssentos(), 3);
        assertEquals(venda.getTotal(), 15.00);
        assertEquals(venda.getDataVenda(), data);
        
        vendaController.removerVenda(venda);
    }
    
}
