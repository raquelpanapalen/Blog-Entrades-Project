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
    
    //Constructor. Crea el controlador.
    public InterficieUsuari(){
        controlador = new Controlador();
    }
    
    //Mostra les opcions del menú principal.
    public void mostraOpcions(){
        IO.mostraText("Opcions:\n" +
            "   index\n" +
            "   mostra num\n" +
            "   nova\n" +
            "   elimina num\n" +
            "   ordena\n" +
            "   dates\n" +
            "   totes\n" +
            "   fi\n");
    }
    
    //Per cada valor d'op, executa el mètode corresponent del controlador.
    public void executaOpcio(String op){
        if (op.equals(""))
            IO.mostraText("Opció incorrecta\n");
        else{
            switch (op.charAt(0)){
                case 'i':
                    if ("index".contains(op))
                        controlador.index();
                    else
                        IO.mostraText("Opció incorrecta\n");
                    break;
                case 'm':
                    String[] parts = op.split(" ");
                    if ("mostra".contains(parts[0]) && parts.length==2){
                        controlador.mostraEntrada(Integer.parseInt(parts[1]));
                    }else
                        IO.mostraText("Opció incorrecta\n");
                    break;
                case 'n':
                    if ("nova".contains(op))
                        controlador.novaEntrada();
                    else
                        IO.mostraText("Opció incorrecta\n");
                    break;
                case 'e':
                    String[] partes = op.split(" ");
                    if ("elimina".contains(partes[0]) && partes.length==2){
                        controlador.eliminaEntrada(Integer.parseInt(partes[1]));
                    }else
                        IO.mostraText("Opció incorrecta\n");
                    break;
                case 'o':
                    if ("ordena".contains(op))
                        controlador.ordena();
                    else
                        IO.mostraText("Opció incorrecta\n");
                    break;
                case 'd':
                    if ("dates".contains(op))
                        controlador.dates();
                    else
                        IO.mostraText("Opció incorrecta\n");
                    break;
                case 't':
                    if ("totes".contains(op))
                        controlador.mostraEntrades();
                    else
                        IO.mostraText("Opció incorrecta\n");
                    break; 
                case 'f':
                    if (!("fi".contains(op)))
                        IO.mostraText("Opció incorrecta\n");
                    break;
                default:
                    IO.mostraText("Opció incorrecta\n");
                    break;
            }
        }
    }
    
    //Cicle principal d'execució: mostra opcions, llegeix opcio i executa opcio.
    public void cicle(){
        String op="";
        while (!(op.equalsIgnoreCase("f") || op.equalsIgnoreCase("fi"))){
            mostraOpcions();
            IO.mostraText("Introdueix una opció: ");
            op = IO.llegeixText().toLowerCase().trim();
            executaOpcio(op);
        }
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
