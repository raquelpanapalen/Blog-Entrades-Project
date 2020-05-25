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
public class MenuRegistrat extends Menu {

    public MenuRegistrat(Controlador contr) {
        super(contr);
    }

    @Override
    public void executaOpcio(String op) throws BlogException {
        if (!(op.equals(""))) {
            String[] parts = op.split(" ");
            if (op.charAt(0)=='i' && "index".contains(op))
                this.controlador.index();
            
            else if (op.charAt(0)=='n' && "nova".contains(op))
                this.controlador.novaEntrada();
            
            else if (op.charAt(0)=='o' && "ordena".contains(op))
                this.controlador.ordena();
            
            else if (op.charAt(0)=='d' && "dates".contains(op))
                this.controlador.dates();
            
            else if (op.charAt(0)=='t' && "totes".contains(op))
                this.controlador.mostraEntrades();
            
            else if (op.charAt(0)=='m' && "mostra".contains(parts[0])
                    && parts.length==2)
                this.controlador.mostraEntrada(Integer.parseInt(parts[1]));
            
            else if (op.charAt(0)=='e' && "elimina".contains(parts[0])
                    && parts.length==2)
                this.controlador.eliminaEntrada(Integer.parseInt(parts[1]));
            
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
            "   index\n" +
            "   mostra <num>\n" +
            "   nova\n" +
            "   elimina <num>\n" +
            "   ordena\n" +
            "   dates\n" +
            "   totes\n" +
            "   fi\n");
    }
    
}
