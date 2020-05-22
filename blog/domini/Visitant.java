/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

import edu.upc.etsetb.poo.blog.controlador.Controlador;
import edu.upc.etsetb.poo.blog.iu.MenuVisitant;

/**
 *
 * @author rachel
 */
public class Visitant extends Usuari {
    
    public Visitant(Controlador contr) {
        super(contr);
        this.menu = new MenuVisitant(contr);
    }
    
}
