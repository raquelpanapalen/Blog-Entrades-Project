/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.iu;

import edu.upc.etsetb.poo.blog.controlador.Controlador;

/**
 *
 * @author rachel
 */

/* Gestiona el menú principal i invoca al controlador per implementar cada una 
 * de les opcions.
 */
public class InterficieUsuari {
    
    private Controlador controlador;
    
    //Constructor. Crea el controlador.
    public InterficieUsuari(){
        controlador = new Controlador();
    }
    
    //Mostra les opcions del menú principal.
    public void mostraOpcions(){
        
    }
    
    //Per cada valor d'op, executa el mètode corresponent del controlador.
    public void executaOpcio(String op){
        
    }
    
    //Cicle principal d'execució: mostra opcions, llegeix opcio i executa opcio.
    public void cicle(){
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
