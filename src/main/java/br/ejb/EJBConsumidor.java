/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Pessoal
 */

@MessageDriven(
        activationConfig={
            @ActivationConfigProperty(
            propertyName="destinationLookup",
            propertyValue="Message/Fila"),
            @ActivationConfigProperty(
            propertyName="desintationType",
            propertyValue="javax.jms.Queue"
            
            )
                
})

public class EJBConsumidor implements MessageListener {

    @Override
    public void onMessage(Message msg) {
 
           try{
           MapMessage tm = (MapMessage) msg;
           
          
         //   System.out.println("porra");A
            
            Enumeration<String> maps = tm.getMapNames();
           Map<String,Integer> map = new HashMap<>();
          
            while (maps.hasMoreElements()){
                String Key=maps.nextElement();
                map.put(Key, (Integer) tm.getObject(Key));
               
            }
           
           ArrayList<Map.Entry<String,Integer>> list  = new ArrayList<>(map.entrySet());
           list.sort(Map.Entry.comparingByValue());
           Collections.reverse(list);
          
           for (int u = 0 ; u < list.size(); u++){
         
               System.out.println("Competidor: "+list.get(u).getKey()+" ponto(s): "+list.get(u).getValue());
                   }
            
            
           }catch(Exception ex){ 
               ex.printStackTrace();
               
           }

    }
    
}
