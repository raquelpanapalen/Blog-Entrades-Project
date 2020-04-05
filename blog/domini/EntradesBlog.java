/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;


import java.util.Collections;
import java.util.Iterator;
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
        if (this.criteri.equals("num") || this.criteri.equals("titol")){
            this.criteri = criteri;
            return true;
        }
        return false;
    }
    
    /* Afegeix una Entrada e a la posició que li correspon a la llista 
     * d'entrades, segons el criteri actual.
     */
    public void afegeixOrdenat(Entrada e){
        int i=0;
        while (i<entrades.size() && Entrada.compare(entrades.get(i), e, criteri)<0){
            i++;
        }
        entrades.add(i, e);
    }
    
    /* Busca l'entrada amb id==num i, si existeix, la retorna. 
     * Altrament retorna null.
     */
    public Entrada agafa(int num){
        for (Entrada e : entrades) {
            if (e.getId()==num)
                return e;
        }
        return null;
    }
    
    /* Busca l'entrada amb id==num i, si existeix, l'elimina de la llista i 
     * la retorna. Altrament retorna null.
     */
    public Entrada elimina(int num){
        Iterator<Entrada> it = entrades.iterator();
        while (it.hasNext()){
            Entrada e = it.next();
            if (e.getId()==num){
                it.remove();
                return e;
            }   
        }
        return null;
    }
    
    //Ordena la llista d'entrades segons el valor actual del criteri.
    public void ordena(){
        for (int i=0; i<entrades.size()-1; i++){
            for (int j=i+1; j<entrades.size(); j++){
                if (Entrada.compare(entrades.get(i), entrades.get(j), criteri)>0){
                    Collections.swap(entrades, i, j);
                }
            }
        }
    }
    
    /* Retorna una String amb l'index de les entrades del blog ordenades segons
     * el criteri actual. 
     */
    public String index(){
        ordena();
        String s="Index{\n";
        for (Entrada e : entrades)
            s += "   "+e.getId()+" "+e.getTitol()+"\n";
        s+="}\n";
        return s;
    }
    
    /* Retorna una String amb totes les entrades entre el dia inici i el dia fi 
     * (ambdós inclosos) ordenades segons el criteri actual. 
     */
    public String entreDates(Temps inici, Temps fi){
        ordena();
        String s="Dates("+inici+","+fi+"){\n";
        for (Entrada e : entrades){
            if (e.getQuan().comparaTemps(inici)>=0 
                    && e.getQuan().comparaTemps(fi)<=0)
                s += "   "+e.toString();
        }
        s+="}\n";
        return s;
    }
    
    /* Retorna una String amb totes les entrades del blog, ordenades segons el 
     * criteri actual. 
     */
    @Override
    public String toString(){
        ordena();
        String s="Totes{\n";
        for (Entrada e : entrades)
            s += "   "+e.toString();
        s+="}\n";
        return s;
    }
}
