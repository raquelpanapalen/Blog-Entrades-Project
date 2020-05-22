/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.excepcions;

/**
 *
 * @author rachel
 */
public class BlogException extends Exception {
    
    //Constructor buit
    public BlogException(){}
    
    
    //Constructor que invoca al constructor de la clase mare amb el missatge
    public BlogException(String message){
        super(message);
    }
}
