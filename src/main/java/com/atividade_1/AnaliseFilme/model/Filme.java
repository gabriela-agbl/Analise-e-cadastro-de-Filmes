package com.atividade_1.AnaliseFilme.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Filmes")
public class Filme 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String sinopse;
    private String genero;
    private Integer ano_lancamento; 

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return ano_lancamento;
    }

    public void setAnoLancamento(Integer ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }
    
}
