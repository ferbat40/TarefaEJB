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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
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
      ArrayList<Entry<String,Integer>> list = new ArrayList<>(competicao.getCompeticao().entrySet());
      list.sort(Entry.comparingByValue());
      Collections.reverse(list);
      return  list;
    }
    
  
    @Override
    public void computarPontos(String nome, int pontos) {
    competicao.add(nome, pontos);
    }

   
    
  
    
    
}
