/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

/**
 *
 * @author rachel
 */

/* Gestiona una Entrada del Blog. Una Entrada té un id, un titol, un text, i el 
 * dia i hora en que s'ha creat.
 */
public class Entrada {
    private static int nEntrades = 0;
    private int id;
    private String titol;
    private String text;
    private Temps temps;
    
    /* Crea una entrada amb el titol, el text, i el dia i hora indicats i 
     * incrementa en 1 el valor del atribut static nEntrades. Si temps val "", 
     * assigna el temps actual (ara). Assigna al atribut id el valor del atribut
     * static nEntrades (que és el nombre d'entrades que s'han creat des de 
     * l'inici de l'execució del programa).
     */
    public Entrada(String titol, String text, String temps){
        this.id = nEntrades;
        this.titol = titol;
        this.text = text;
        if (temps.equals("")){
            this.temps = new Temps();
            this.temps.ara();
        }
        else
            this.temps = new Temps(temps);
        nEntrades++;
    }
    
    //Getter id
    public int getId(){
        return id;
    }
    
    //Geter titol
    public String getTitol(){
        return titol;
    }
    
    //Getter temps
    public Temps getQuan(){
        return temps;
    }
    
    /* Compara l'entrada una amb l'altre, segons el criteri. El criteri pot ser 
     * "num" (l'id) o "titol" (el titol). Retorna un enter positiu si una es 
     * mes gran que altra segons el criteri; 0 si son iguals segons el criteri; 
     * enter negatiu si una es mes petita que altra segons el criteri. Si el 
     * criteri no es ni "num" ni "titol" retorna 0.
     */
    public static int compare(Entrada una, Entrada altra, String criteri){
        
        
        return 0;
    }
    
    //Retorna un string en el format "id titol text dia hora"
    @Override
    public String toString(){
        
        return "";
    }
    
    
    
    
    
    
    
}
