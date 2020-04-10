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
    
    private Controlador controlador;
    
    //Constructor. Crea el controlador.
    public InterficieUsuari(){
        controlador = new Controlador();
    }
    
    //Mostra les opcions del menú principal.
    public void mostraOpcions(){
        System.out.print("Opcions:\n\tindex\n\tmostra <num>\n\tnova\n\telimina <num>\n\tordena\n\tdates\n\ttotes\n\tfi\nIntrodueix una opció: ");
    }
    
    //Per cada valor d'op, executa el mètode corresponent del controlador.
    public void executaOpcio(String op){
        switch (op.charAt(0)) {
            case 'i':
            case 'I':
                controlador.index();
                break;
            case 'm':
            case 'M':
                String[] parts=op.split(" ");
                int num=Integer.parseInt(parts[1]);
                controlador.mostraEntrada(num);
                break;
            case 'n':
            case 'N':
                controlador.novaEntrada();
                break;
            case 'e':
            case 'E':
                String[] partes=op.split(" ");
                int n=Integer.parseInt(partes[1]);
                controlador.eliminaEntrada(n);
                break;
            case 'o':
            case 'O':
                controlador.ordena();
                break;
            case 'd':
            case 'D':
                controlador.dates();
                break;
            case 't':
            case 'T':
                controlador.mostraEntrades();
                break;
            default:
                break;
        }
    }
    
    //Cicle principal d'execució: mostra opcions, llegeix opcio i executa opcio.
    public void cicle(){
        String opc="x";
        while(!String.valueOf(opc.charAt(0)).equalsIgnoreCase("f")){
            mostraOpcions();
            opc=IO.llegeixText();
            executaOpcio(opc);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IO io = new IO();
        InterficieUsuari iu=new InterficieUsuari();
        System.out.println("Hola!");
        iu.cicle();        
        System.out.println("Adeu!");
    }
    
}
