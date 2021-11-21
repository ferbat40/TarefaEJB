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

import javax.ejb.EJB;
import lombok.Data;

import br.ejb.ICompetidor;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author PARTICULAR
 */
@Named(value = "jSFCompetidor")
@SessionScoped
@Data
public class JSFCompetidor implements Serializable {

    @Resource(lookup="java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory Contexts;
    
    @Resource(lookup="Message/Fila")
    private Queue fila;
    
   
    
    
    
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
    private String servidor;
   

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
       send();
        }
      
    public ArrayList getRanking(){
         return eJBCompetidor.rankins();
    }
      
  
    
    public void send(){
         servidor="Ranking empatado ou com 1 participante, não enviado ao servidor";
        if (eJBCompetidor.verificarRanking()==true){
           servidor="Existe um Vencedor, foi enviado ao servidor" ;
        try{
        JMSContext contexty = Contexts.createContext();
        contexty.createProducer().send(fila, eJBCompetidor.Maprankins());
        
         
        
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        
    }
    }
    
    }
    
        
    
    
   
    

