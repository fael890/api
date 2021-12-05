package com.ifsp.listadelivros.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Livro {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @Column(nullable = false)
    private Boolean lido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRotulo")
    private Rotulo rotulo;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Categoria> categorias;

    public Livro(){}

    public Livro(String title, Boolean lido, Rotulo rotulo){
        this.title = title;
        this.lido = lido;
        this.rotulo = rotulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Boolean getLido() {
        return lido;
    }

    public void setLido(Boolean lido) {
        this.lido = lido;
    }

    public Rotulo getRotulo() {
        return rotulo;
    }

    public void setRotulo(Rotulo rotulo) {
        this.rotulo = rotulo;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
