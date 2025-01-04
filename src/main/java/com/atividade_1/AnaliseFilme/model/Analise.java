package com.atividade_1.AnaliseFilme.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Análises")
public class Analise 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_a;
    @ManyToOne
    @JoinColumn(name = "filme")
    private Filme filme;
    private String analise;
    private Integer nota;

    public Integer getId() {
        return id_a;
    }

    public void setId(Integer id_a) {
        this.id_a = id_a;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getAnalise() {
        return analise;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    } 
}
