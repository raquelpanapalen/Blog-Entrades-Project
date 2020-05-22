/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

import edu.upc.etsetb.poo.blog.controlador.Controlador;
import edu.upc.etsetb.poo.blog.iu.MenuRegistrat;

/**
 *
 * @author rachel
 */
public class Registrat extends Usuari {
    private String nomUsuari;
    private String password;
    private EntradesBlog blog;
    
    //Constructor que construeix un usuari registrat.
    public Registrat(Controlador contr, String nom, String passwd) {
        super(contr);
        this.blog = new EntradesBlog();
        this.menu = new MenuRegistrat(contr);
        this.nomUsuari = nom.toLowerCase();
        this.password = passwd;
    }
    
    //Afageix l'entrada e al blog de l'usuari.
    public void AfageixEntrada(Entrada e){
        this.blog.afegeixOrdenat(e);
    }
    
    //Getter del blog.
    public EntradesBlog getBlog(){
        return this.blog;
    }
    
    //Verifica si el password passat per arguments es el d'aquest usuari.
    public boolean verificaPassword(String pass){
        return this.password.equals(pass);
    }


}
