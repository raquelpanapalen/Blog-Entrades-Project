/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rachel
 */

/* Gestiona totes les entrades del Blog. Un objecte de la classe EntradesBlog 
 * conté una llista amb les entrades del blog, i una string amb el criteri 
 * segons el qual estan ordenades en el moment actual 
 * ("num", per defecte, o "titol").
 */
public class EntradesBlog {
    private String criteri;
    private List<Entrada> entrades;
    
    //Crea l'objecte EntradesBlog amb una llista buida i el criteri "num".
    public EntradesBlog(){
        entrades = new LinkedList<>();
        criteri = "num";
    }
    
    
    /* Assigna un valor a criteri. Si criteri no és "num" o "titol", el deixa 
     * com estava. Retorn true si l'ha pogut modificar, i false en cas contrari.
     * Returns: true si l'argument es un valor valid i s'ha pogut modificar 
     * l'atribut; false si l'argument no es valid i no s'ha pogut modificar.
     */
    public boolean setCriteri(String criteri){
        
        return false;
    }
    
    /* Afegeix una Entrada e a la posició que li correspon a la llista 
     * d'entrades, segons el criteri actual.
     */
    public void afegeixOrdenat(Entrada e){
        
    }
    
    /* Busca l'entrada amb id==num i, si existeix, la retorna. 
     * Altrament retorna null.
     */
    public Entrada agafa(int num){
     
        return null;
    }
    
    /* Busca l'entrada amb id==num i, si existeix, l'elimina de la llista i 
     * la retorna. Altrament retorna null.
     */
    public Entrada elimina(int num){
        
        return null;
    }
    
    //Ordena la llista d'entrades segons el valor actual del criteri.
    public void ordena(){
        
    }
    
    public String index(){
        
        return "";
    }
    
    public String entreDates(Temps inici, Temps fi){
        
        return "";
    }
    
    @Override
    public String toString(){
        
        return "";
    }
}
