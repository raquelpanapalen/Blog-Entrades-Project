/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.controlador;

import edu.upc.etsetb.poo.blog.domini.Entrada;
import edu.upc.etsetb.poo.blog.domini.EntradesBlog;
import edu.upc.etsetb.poo.blog.domini.Temps;
import edu.upc.etsetb.poo.blog.serveis.IO;


/**
 *
 * @author rachel
 */
public class Controlador {
    
    private EntradesBlog entrades_blog;
    
    /* Constructor. Inicialitza les entrades del blog, crea i afegeix 
     * tres entrades per fer proves d'execució. */
    public Controlador(){
        entrades_blog = new EntradesBlog();
        entrades_blog.afegeixOrdenat(new Entrada("t3", "x3", "2020-05-15 08:42:00"));
        entrades_blog.afegeixOrdenat(new Entrada("t1", "x1", "2018-03-07 09:17:00"));
        entrades_blog.afegeixOrdenat(new Entrada("t5", "x5", "2019-05-15"));
    }
    
    //Mostra l'index de les entrades del blog.
    public void index(){
        IO.mostraText(entrades_blog.index());
    }
    
    /* Mostra l'entrada amb iddentificador igual al valor del argument num.
     * Parameters: num - identificador de l'entrada
     */
    public void mostraEntrada(int num){
        Entrada e = entrades_blog.agafa(num);
        if (e!=null)
            IO.mostraText(entrades_blog.agafa(num).toString());
        else
            IO.mostraText("Aquesta entrada no existeix\n");
    }
    
    /* Demana el titol, el text, i el dia i hora a l'usuari, crea una entrada 
     * nova, i l'afegeix al blog en la posició que li correspon segons el 
     * criteri d'ordenació actual. Pel que fa al dia i hora, l'usuari té 
     * tres opcions: introduir dia i hora complets, introduir només l'hora, 
     * o pitjar return (no introduir res). 
     * En el darrer cas s'assignarà el dia i hora actuals (ara).
     */
    public void novaEntrada(){
        IO.mostraText("Entrada nova:\n");
        IO.mostraText("Títol? ");
        String titol = IO.llegeixText();
        IO.mostraText("Text? ");
        String text = IO.llegeixText();
        IO.mostraText("Dia i hora? (aaaa-mm-dd <hh:mm:ss>, Return=Ara) ");
        String temps = IO.llegeixText();
        entrades_blog.afegeixOrdenat(new Entrada(titol, text, temps));
    }
    
    /* Elimina l'entrada amb iddentificador igual al valor del argument num, 
     * i mostra l'entrada eliminada.
     * Parameters: num - identificador de l'entrada a eliminar
     */
    public void eliminaEntrada(int num){
        Entrada e = entrades_blog.elimina(num);
        if (e!=null)
            IO.mostraText("Elimino: "+entrades_blog.elimina(num).toString());
        else
            IO.mostraText("Aquesta entrada no existeix\n");
    }
    
    /* Demana el criteri d'ordenació a l'usuari, l'assigna, i ordena segons el 
     * nou criteri. El criteri pot ser "num" o "titol".
     */
    public void ordena(){
        String criteri="";
        do{
            IO.mostraText("Criteri? (num/titol) ");
            criteri = IO.llegeixText();
        }while(!(criteri.equalsIgnoreCase("num") || criteri.equalsIgnoreCase("titol")));
        entrades_blog.setCriteri(criteri);    
        entrades_blog.ordena();
    }
    
    /* Demana a l'usuari els dies inicial i final i mostra totes les entrades 
     * del blog entre aquests dos dies (ambdós inclusius).
     */
    public void dates(){
        IO.mostraText("Dia inicial? (aaaa-mm-dd) ");
        String inici = IO.llegeixText().trim();
        IO.mostraText("Dia final? (aaaa-mm-dd) ");
        String fi = IO.llegeixText().trim();
        IO.mostraText(entrades_blog.entreDates(new Temps(inici), new Temps(fi)));
    }
    
    //Mostra totes les entrades del blog.
    public void mostraEntrades(){
        IO.mostraText(entrades_blog.toString());
    }
}
