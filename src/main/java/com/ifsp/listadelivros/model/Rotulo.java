package com.ifsp.listadelivros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Rotulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRotulo;

    @Column(nullable = false)
    private String sinopse;

    @Column(nullable = false)
    private int numPages;
    
    @OneToOne
    private Livro livro;

    public Rotulo(){}

    public Rotulo(String sinopse, int numPages) {
        this.sinopse = sinopse;
        this.numPages = numPages;
    }

    public Long getIdRotulo() {
        return idRotulo;
    }

    public void setIdRotulo(Long idRotulo) {
        this.idRotulo = idRotulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    } 
}
