/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.ejb.EJBAleatorioLocal;
import br.ejb.EJBRetornarSomaLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Map;
import javax.ejb.EJB;
import lombok.Data;

import br.ejb.ICompetidor;
import java.util.ArrayList;

/**
 *
 * @author PARTICULAR
 */
@Named(value = "jSFCompetidor")
@SessionScoped
@Data
public class JSFCompetidor implements Serializable {

    @EJB
    private EJBRetornarSomaLocal eJBRetornarSoma;

    @EJB
    private EJBAleatorioLocal eJBAleatorio;
   
    @EJB
    private ICompetidor eJBCompetidor;
    
    
   
    private int ValorA;
    private int ValorB;
    private int resultado;
    private String nome;
    private String exibir; 
    
   

    public JSFCompetidor() {
    }
    
    public int getValorA(){
        ValorA=eJBAleatorio.gerarA();
        return ValorA;
    }
    
    public int getValorB(){
        ValorB=eJBAleatorio.gerarB();
        return ValorB;
    }
    
    
    public void adicionarCompetidor(){
       eJBCompetidor.computarPontos(nome, 0);
       exibir="";
    }
    
    public void gerarRanking(){
      if (eJBRetornarSoma.retSoma(ValorA, ValorB, resultado)==false){
        exibir="Soma esta errada" ;   
        eJBCompetidor.computarPontos(nome, 0);
        }else{
        eJBCompetidor.computarPontos(nome, 1);
        exibir="Soma corresponde";
        }
        }
      
    public ArrayList getRanking(){
     return eJBCompetidor.rankins();
    }
        
    
    }
    
        
    
    
   
    

