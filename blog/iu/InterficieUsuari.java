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
 * @author rachel
 */

/* Gestiona el menú principal i invoca al controlador per implementar cada una 
 * de les opcions.
 */
public class InterficieUsuari {
    
    private Controlador controlador;
    private Menu menu;
    
    //Constructor. Crea el controlador y el menu.
    public InterficieUsuari(){
        controlador = new Controlador();
        menu = new MenuPrincipal(this.controlador);
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
        IO.mostraText("Adeu!\n");
    }
}
