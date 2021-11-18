/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import javax.ejb.Local;

/**
 *
 * @author PARTICULAR
 */
@Local
public interface EJBRetornarSomaLocal {
    
    public boolean retSoma(int A, int B, int resultado);
    
}
