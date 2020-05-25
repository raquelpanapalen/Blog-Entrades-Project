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
public class MenuVisitant extends Menu {

    public MenuVisitant(Controlador contr) {
        super(contr);
    }

    @Override
    public void executaOpcio(String op) throws BlogException {
        if (!(op.equals(""))) {
            String[] parts = op.split(" ");
            if (op.charAt(0)=='l' && "llistausuaris".contains(op))
                this.controlador.mostraUsuaris();
            
            else if (op.charAt(0)=='m' && "mostrablog".contains(parts[0])
                    && parts.length==2)
                this.controlador.mostraBlog(parts[1]);
            
            else if (op.charAt(0)=='f' && "fi".contains(op)){}
            
            else
                throw new BlogException("Opció incorrecta!");
   
        }
        else
            throw new BlogException("Opció incorrecta!");
    }

    @Override
    public void mostraOpcions() {
        IO.mostraText("Opcions:\n" +
            "   llistaUsuaris\n" +
            "   mostraBlog nomUsuari\n" +
            "   fi\n");
    }
    
}
