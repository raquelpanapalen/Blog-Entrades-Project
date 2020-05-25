/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.iu;

import edu.upc.etsetb.poo.blog.controlador.Controlador;
import edu.upc.etsetb.poo.blog.excepcions.BlogException;
import edu.upc.etsetb.poo.blog.serveis.IO;

/**
 *
 * @author rachel
 */
public abstract class Menu {
    protected Controlador controlador;
    
    public Menu(Controlador contr){
        this.controlador = contr;
    }
    
    //Mostra opcions i, mentre no sigui "fi" intenta excutar l'opció.
    public void cicle(){
        String op="";
        while (!(op.equalsIgnoreCase("f") || op.equalsIgnoreCase("fi"))){
            mostraOpcions();
            op = demanaOpcio();
            try {
                this.executaOpcio(op);
            } catch (BlogException e) {
                IO.mostraError(e.getMessage());
            }
        }
    }
    
    //Demana l'opció a l'usuari i la retorna.
    public String demanaOpcio(){
        IO.mostraText("Introdueix una opció: ");
        return IO.llegeixText().toLowerCase().trim();
    }
    
    public abstract void executaOpcio(String op) throws BlogException;
    
    public abstract void mostraOpcions();
}
