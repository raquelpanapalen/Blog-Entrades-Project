/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

import java.time.LocalDateTime;

/**
 *
 * @author rachel
 */
public class Temps {
    
    private String dia; //aaaa-mm-dd
    private String hora; //hh:mm:ss
        
    //Constructor: el dia i l'hora són buits.
    public Temps(){}
    
    /* Extreu el dia i l'hora de l'string temps, amb 
     * temps = "aaaa-mm-dd hh:mm:ss"
     */
    public Temps(String temps){
        dia = temps.split(" ")[0];
        if (temps.split(" ").length==1)
            hora = "";
        else
            hora = temps.split(" ")[1]; 
    }
    
    /* Assigna a this el dia i l'hora de l'instant actual. 
     * Utilitza LocalDateTime.now().toString(), que retorna el temps actual 
     * en el format "aaaa-mm-ddThh:mm:ss"
     */
    public void ara(){
        this.dia=LocalDateTime.now().toString().split("T")[0];
        this.hora=LocalDateTime.now().toString().split("T")[1];
    }
    
    /* Compara el dia de this amb el dia d'altre. Retorna un enter negatiu si 
     * el dia d'aquest objecte (this) és posterior al dia d'altre; 0 si es el 
     * mateix que el dia d'altre, i un enter negatiu si es anterior al dia 
     * d'altre.
     */
    public int comparaDia(Temps altre){
        return this.dia.compareTo(altre.dia);
    }
    
    /* Compara el dia i hora de this amb el dia i hora d'altre. Retorna un 
     * valor > 0 si el dia i l'hora d'aquest objecte (this) són posteriors al 
     * dia i l'hora d'altre; 0 si son el mateixos, i un enter negatiu si son 
     * anteriors al dia i l'hora d'altre. 
     */
    public int comparaTemps(Temps altre){
        if (this.comparaDia(altre)!=0)
            return this.comparaDia(altre);
        return this.hora.compareTo(altre.hora);
    }
    
    
    //Retorna el dia i l'hora en un string en el format "aaaa-mm-dd hh:mm:ss".
    @Override
    public String toString(){
        return dia+" "+hora;      
    }
}
