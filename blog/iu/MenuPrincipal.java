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
public class MenuPrincipal extends Menu {

    public MenuPrincipal(Controlador contr) {
        super(contr);
    }

    @Override
    public void executaOpcio(String op) throws BlogException {
        if (!(op.equals(""))) {
            if (op.charAt(0)=='v' && "visitant".contains(op))
                this.controlador.visitant();
            
            else if (op.charAt(0)=='i' && "inicia sessio".contains(op))
                this.controlador.sessio();
            
            else if (op.charAt(0)=='r' && "registra't".contains(op))
                this.controlador.registre();
            
            else if (op.charAt(0)=='f' && "fi".contains(op)){}
            
            else{
                throw new BlogException("Opció incorrecta!");
            }
                
        }
        else
            throw new BlogException("Opció incorrecta!");
    }

    @Override
    public void mostraOpcions() {
        IO.mostraText("Opcions:\n" +
            "   visitant\n" +
            "   inicia sessio\n" +
            "   registra't\n" +
            "   fi\n");
    }
    
}
