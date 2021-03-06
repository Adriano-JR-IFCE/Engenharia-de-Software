package com.engenharia.software.model;

import com.engenharia.software.auxiliar.Mensagens;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //atributos
    private String titulo;
    private int qtdAssentos;
    private double precoIngresso;
       
    //setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setTitulo(String titulo) {
        //caso o titulo seja em branco
        if (titulo.isEmpty())
            throw new IllegalArgumentException(new Mensagens().EXCECAO_MENSAGEM_TITULO_EM_BRANCO);
        
        this.titulo = titulo;
    }
    
    public void setQtdAssentos(int qtdAssentos) {
        if (qtdAssentos < 0)
            throw new IllegalArgumentException(new Mensagens().EXCECAO_MENSAGEM_QTD_ASSENTOS_NEGATIVA);
        this.qtdAssentos = qtdAssentos;
    }
    
    public void setPrecoIngresso(double precoIngresso) {
        if (precoIngresso <= 0.00)
            throw new IllegalArgumentException(new Mensagens().EXCECAO_MENSAGEM_PRECO_INGRESSO_NULO_OU_NEGATIVO);
        this.precoIngresso = precoIngresso;
    }
    
    //getters
    public Long getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public int getQtdAssentos() {
        return qtdAssentos;
    }

    public double getPrecoIngresso() {
        return precoIngresso;
    }
    
    //outros metodos
    @Override
    public String toString() {
        return 
                String.format("ID: %d%nTitulo: %s%nQtd. Assentos: %d%nPreco Ingresso: %.2f%n",
                            getId(),
                            getTitulo(),
                            getQtdAssentos(),
                            getPrecoIngresso()
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
        if (!(object instanceof Filme)) {
            return false;
        }
        Filme other = (Filme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
