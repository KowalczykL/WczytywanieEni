/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.Serializable;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Odczyt implements Serializable{
    String ppe;
    String nrLicznika;
    String data;
    String taryfa;
    String wskBie;
    String strefa;
    String mnozna;
    String straty;   

    public Odczyt(String ppe, String nrLicznika, String data, String taryfa, String wskBie, String strefa, String mnozna, String straty) {
        this.ppe = ppe;
        this.nrLicznika = nrLicznika;
        this.data = data;
        this.taryfa = taryfa;
        this.wskBie = wskBie;
        this.strefa = strefa;
        this.mnozna = mnozna;
        this.straty = straty;
    }

    public Odczyt(String ppe, String data, String wskBie) {
        this.ppe = ppe;
        this.data = data;
        this.wskBie = wskBie;
    }
    @Override
    public String toString(){
    return (this.ppe+";"+this.data+";"+this.wskBie);
    }
}
