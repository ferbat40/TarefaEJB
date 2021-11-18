/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author PARTICULAR
 */
@Stateless
public class EJBRetornarSoma implements EJBRetornarSomaLocal {

    
     @Override
    public boolean retSoma(int A, int B, int resultado) {
        if ((A+B)!=resultado){
        return false;   
        }
        return true;
        }
    
}
