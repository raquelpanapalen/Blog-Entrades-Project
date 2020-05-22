/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.controlador;

import edu.upc.etsetb.poo.blog.domini.Entrada;
import edu.upc.etsetb.poo.blog.domini.EntradesBlog;
import edu.upc.etsetb.poo.blog.domini.Registrat;
import edu.upc.etsetb.poo.blog.domini.Temps;
import edu.upc.etsetb.poo.blog.domini.Usuari;
import edu.upc.etsetb.poo.blog.domini.Visitant;
import edu.upc.etsetb.poo.blog.excepcions.BlogException;
import edu.upc.etsetb.poo.blog.serveis.IO;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author rachel
 */
public class Controlador {
    
    private EntradesBlog blog_actual;
    private Map<String, Registrat> registrats;
    private Usuari usuari_actual;
    
    /* Constructor. Inicialitza les entrades del blog, crea i afegeix 
     * tres entrades per fer proves d'execució. */
    public Controlador(){
        this.blog_actual = new EntradesBlog();
        this.registrats = new HashMap<>();
        this.usuari_actual = null;
        
        //Entrades de prova
        Entrada e1 = new Entrada("t1", "x1", "2018-03-07 09:17:00");
        Entrada e3 = new Entrada("t3", "x3", "2020-05-15 08:42:00");
        Entrada e5 = new Entrada("t5", "x5", "2019-05-15");
                
        //Usuaris registrats de prova
        Registrat usr1 = new Registrat(this, "usr1", "password1");
        Registrat usr2 = new Registrat(this, "usr2", "password2");
        
        /* Afegir entrades de prova al blog dels usuaris de prova i afegir
         * usuaris de prova al mapa de registrats
         */
        usr1.AfageixEntrada(e1);
        usr1.AfageixEntrada(e3);
        usr2.AfageixEntrada(e5);
        this.registrats.put("usr1", usr1);
        this.registrats.put("usr2", usr2);         
    }
    
    //Mostra l'index de les entrades del blog.
    public void index(){
        IO.mostraText(this.blog_actual.index());
    }
    
    /* Mostra l'entrada amb iddentificador igual al valor del argument num.
     * Parameters: num - identificador de l'entrada
     */
    public void mostraEntrada(int num){
        Entrada e = this.blog_actual.agafa(num);
        if (e!=null)
            IO.mostraText(e.toString());
        else
            IO.mostraError("Aquesta entrada no existeix!");
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
        this.blog_actual.afegeixOrdenat(new Entrada(titol, text, temps));
    }
    
    /* Elimina l'entrada amb iddentificador igual al valor del argument num, 
     * i mostra l'entrada eliminada.
     * Parameters: num - identificador de l'entrada a eliminar
     */
    public void eliminaEntrada(int num){
        Entrada e = this.blog_actual.elimina(num);
        if (e!=null)
            IO.mostraText("Elimino: "+e.toString());
        else
            IO.mostraError("Aquesta entrada no existeix!");
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
        this.blog_actual.setCriteri(criteri);    
        this.blog_actual.ordena();
    }
    
    /* Demana a l'usuari els dies inicial i final i mostra totes les entrades 
     * del blog entre aquests dos dies (ambdós inclusius).
     */
    public void dates(){
        IO.mostraText("Dia inicial? (aaaa-mm-dd) ");
        String inici = IO.llegeixText().trim();
        IO.mostraText("Dia final? (aaaa-mm-dd) ");
        String fi = IO.llegeixText().trim();
        IO.mostraText(this.blog_actual.entreDates(new Temps(inici), new Temps(fi)));
    }
    
    //Mostra totes les entrades del blog.
    public void mostraEntrades(){
        IO.mostraText(this.blog_actual.toString());
    }
    
    //Mostra totes les entrades del blog.
    public void mostraBlog(String nom) throws BlogException {
        Registrat usuari = this.registrats.get(nom);
        if (usuari==null)
            throw new BlogException("Usuari desconegut!");
        IO.mostraText(usuari.getBlog().toString());
    }
    
    //Registra un nou usuari demanant que confirmi el password.
    public void registre() throws BlogException {
        IO.mostraText("Alta usuari:\n");
        IO.mostraText("Nom Usuari? ");
        String nom = IO.llegeixText().trim();
        IO.mostraText("Password? ");
        String pass1 = IO.llegeixText().trim();
        IO.mostraText("Repeteix el password: ");
        String pass2 = IO.llegeixText().trim();
        if (!pass1.equals(pass2))
            throw new BlogException("Password incorrecte!");
        this.registrats.put(nom, new Registrat(this, nom, pass1));
    }
    
    /* Pregunta nom d'usuari i password i, si són vàlids, l'usuari actual passa 
     * a ser dit usuari i entra en el cicle de mostrar el menú i realizar opció.
     */
    public void sessio() throws BlogException {
        IO.mostraText("Nom Usuari? ");
        String nom = IO.llegeixText().trim();
        IO.mostraText("Password? ");
        String pass = IO.llegeixText().trim();
        Registrat usuari = this.registrats.get(nom);
        if (usuari==null || !usuari.verificaPassword(pass))
            throw new BlogException();
        this.usuari_actual = usuari;
        this.blog_actual = usuari.getBlog();
        usuari.getMenu().cicle();
    }
    
    /* Crea un nou Visitant que serà el usuari actual i entra en el cicle de 
     * mostrar el menú i realizar opció.
     */
    public void visitant(){
        Visitant usuari = new Visitant(this);
        this.usuari_actual = usuari;
        usuari.getMenu().cicle();
    }
    
    
    //Mostra els noms d'usuaris.
    public void mostraUsuaris(){
        String s="[";
        int i=1;
        for (String nom : this.registrats.keySet()){
            s += nom;
            if(i<this.registrats.size())
                s+=", ";
            i++;
        }
        s+="]\n";
        IO.mostraText(s);
    }
}
