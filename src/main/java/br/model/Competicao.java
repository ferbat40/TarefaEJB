/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.model;


import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author PARTICULAR
 */

@Data
public class Competicao {
  
    private Map<String,Integer> competicao;
    
    public Competicao(){
        competicao = new HashMap<>();
      
    }
    
    
    public void add(String nome,int pontos){
       if (competicao.containsKey(nome)){
          competicao.replace(nome, competicao.get(nome).intValue()+pontos);
       }else{
        competicao.put(nome, pontos);
        } 
       
    }
    
    
}
