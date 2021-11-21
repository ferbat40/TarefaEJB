/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import br.model.Competicao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ejb.Stateful;
import lombok.Data;

/**
 *
 * @author PARTICULAR
 */
@Stateful
@Data
public class EJBCompetidor implements ICompetidor {
   private Competicao competicao;
   
   
    public EJBCompetidor() {
      competicao = new Competicao();
    
    }
    @Override
    public ArrayList rankins(){
      ArrayList<Entry<String,Integer>> list  = new ArrayList<>(competicao.getCompeticao().entrySet());
      list.sort(Entry.comparingByValue());
      Collections.reverse(list);
      return  list;
    }
    
  
    @Override
    public void computarPontos(String nome, int pontos) {
    competicao.add(nome, pontos);
    }

    @Override
    public Map Maprankins() {
        
      return competicao.getCompeticao();
                
    }

    @Override
    public boolean verificarRanking() {
   
      Optional<Integer> max = competicao.getCompeticao().entrySet().stream().map(Entry::getValue).max(Integer::compare);
      Optional<Integer> min = competicao.getCompeticao().entrySet().stream().map(Entry::getValue).min(Integer::compare);
    
      long contador = competicao.getCompeticao().entrySet().stream().map(Entry::getValue).count();
      
      if (max.get()>min.get() && contador > 1 ){
          return true;
      }
      return false;
    }

   
    
  
    
    
}
