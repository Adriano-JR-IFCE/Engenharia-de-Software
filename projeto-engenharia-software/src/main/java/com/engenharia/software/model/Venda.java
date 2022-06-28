package com.engenharia.software.model;

import com.engenharia.software.auxiliar.Mensagens;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    private String titulo;
    private int qtdAssentos;
    private double total;
    
    //setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setTitulo(String titulo) {
        if (titulo.isEmpty())
            throw new IllegalArgumentException(new Mensagens().EXCECAO_MENSAGEM_TITULO_EM_BRANCO);
        this.titulo = titulo;
    }
    
    public void setQtdAssentos(int qtdAssentos) {
        if (qtdAssentos <= 0)
            throw new IllegalArgumentException(new Mensagens().EXCECAO_MENSAGEM_QTD_ASSENTOS_NEGATIVA_OU_NULA);
        this.qtdAssentos = qtdAssentos;
    }
    
    public void setTotal(double total) {
        if (total <= 0)
            throw new IllegalArgumentException(new Mensagens().EXCECAO_MENSAGEM_TOTAL_NEGATIVO_OU_NULO);
        this.total = total;
    }
    
    //getters
    public Long getId() {
        return id;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
    public int getQtdAssentos() {
        return this.qtdAssentos;
    }
    
    public double getTotal() {
        return this.total;
    }
    
    //outros metodos
    @Override
    public String toString() {
        return 
                String.format("ID: %d%nFilme: %s%nQtd. Assentos: %d%nTotal: %.2f%n",
                        getId(),
                        getTitulo(),
                        getQtdAssentos(),
                        getTotal()
                );
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
