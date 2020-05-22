/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.iu;

import edu.upc.etsetb.poo.blog.controlador.Controlador;
import edu.upc.etsetb.poo.blog.serveis.IO;



/**
 *
 * @author silvi
 */

/* Gestiona el menú principal i invoca al controlador per implementar cada una 
 * de les opcions.
 */
public class InterficieUsuari {
    private Controlador contr;
    private Menu menu;
    
    //Constructor. Crea el controlador.
    public InterficieUsuari(){
        this.contr= new Controlador();
        this.menu= new MenuPrincipal(this.contr);
    }
       
    //Cicle principal d'execució: mostra opcions, llegeix opcio i executa opcio.
    public void cicle(){
        menu.cicle();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InterficieUsuari iu = new InterficieUsuari();
        IO.mostraText("Hola!\n");
        iu.cicle();        
    }
}
