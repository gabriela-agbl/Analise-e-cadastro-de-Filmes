package com.atividade_1.AnaliseFilme.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Preferencia 
{
    private String estilo;
 
    public String getEstilo() 
    { 
        return estilo; 
    } 
  
    public void setEstilo(String estilo) 
    { 
        this.estilo = estilo; 
    } 
}
