/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;
import java.util.ArrayList;
import java.util.HashSet;



/**
 *
 * @author Salvatore Spanu 65219
 */
public class NerdFactory {
    
    private static NerdFactory singleton;
    public static NerdFactory getInstance() {
        if (singleton == null) {
            singleton = new NerdFactory();
        }
        return singleton;
    }
    private ArrayList<Nerd> listaNerds = new ArrayList<Nerd>();
    
    private NerdFactory() {
        //Creazione utenti

        //Steve
        Nerd nerd1 = new Nerd();
        nerd1.setId(0);
        nerd1.setNome("Steve");
        nerd1.setCognome("Jobs");
        nerd1.setUrlFotoProfilo("img/steve.jpg");
        nerd1.setUsername("stevej");
        nerd1.setPassword("123456");
        nerd1.setFrasePresentazione("Ciao io sono Steve!");
        nerd1.setDataNascita("11/12/1955");    
        
        //Bill
        Nerd nerd2 = new Nerd();
        nerd2.setId(1);
        nerd2.setNome("Bill");
        nerd2.setCognome("Gates");
        nerd2.setUrlFotoProfilo("img/bill.jpg");
        nerd2.setUsername("billg");
        nerd2.setPassword("123456");
        nerd2.setFrasePresentazione("Ciao io sono Bill!");
        nerd2.setDataNascita("01/02/1950"); 
        
        //Linus
        Nerd nerd3 = new Nerd();
        nerd2.setId(2);
        nerd2.setNome("Linus");
        nerd2.setCognome("Torvalds");
        nerd2.setUrlFotoProfilo("img/linus.jpg");
        nerd2.setUsername("linust");
        nerd2.setPassword("123456");
        nerd2.setFrasePresentazione("Ciao io sono Linus!");
        nerd2.setDataNascita("07/03/1952"); 

        listaNerds.add(nerd1);
        listaNerds.add(nerd2);
        listaNerds.add(nerd3);
    }
    public Nerd getNerdById(int id) {
        for (Nerd nerd : this.listaNerds) {
            if (nerd.getId() == id) {
                return nerd;
            }
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password){
        for (Nerd nerd : this.listaNerds){
            if(nerd.getNome().equals(user) && nerd.getPassword().equals(password)){
                return nerd.getId();
            }
        }
        return -1;
    }
}

