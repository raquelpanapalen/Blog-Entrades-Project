/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.serveis;

import java.util.Scanner;

/**
 *
 * @author rachel
 */

/* Aquesta classe encapsula les operacions d'entrada sortida. Lectura de teclat 
 * i escritura en pantalla.
 */
public class IO {
    
    public static Scanner teclat = new Scanner(System.in);
    
    public IO(){}
    
    //Mostra el text per la pantalla.
    public static void mostraText(String text){
        System.out.print(text);
    }
    
    /* Retorna el text que l'usuari introdueix per teclat. Aquest metode usa 
     * l'atribut static teclat de classe Scanner.
     */
    public static String llegeixText(){
        return teclat.nextLine();
    }
    
    
}
