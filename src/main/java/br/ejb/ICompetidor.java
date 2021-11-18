/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import java.util.ArrayList;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author PARTICULAR
 */
@Local
public interface ICompetidor {
    
    
    public void computarPontos(String nome, int pontos);
    
    
    
    public ArrayList rankins();
    
}
