/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

import edu.upc.etsetb.poo.blog.controlador.Controlador;
import edu.upc.etsetb.poo.blog.iu.Menu;

/**
 *
 * @author rachel
 */
public abstract class Usuari {
    protected Menu menu;
    protected Controlador contr;
    
    //Constructor que asigna controlador i inicialitza menú a null.
    public Usuari(Controlador contr){
        this.menu = null;
        this.contr = contr;
    }
    
    //Getter de menú.
    public Menu getMenu(){
        return this.menu;
    }
    
}
