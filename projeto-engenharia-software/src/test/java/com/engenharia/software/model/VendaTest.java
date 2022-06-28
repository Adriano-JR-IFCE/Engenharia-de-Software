package com.engenharia.software.model;

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
    
}
