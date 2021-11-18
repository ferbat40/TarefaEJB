/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import java.util.Random;
import javax.ejb.Stateless;

/**
 *
 * @author PARTICULAR
 */
@Stateless
public class EJBAleatorio implements EJBAleatorioLocal {

   @Override
    public int gerarA() {
        
        return new Random().nextInt(1+20);
    }

    @Override
    public int gerarB() {
      return new Random().nextInt(1+20);
    }
}
