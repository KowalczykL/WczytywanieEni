/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Licznik {
    private String nrLicznika;
    private int mnozna;
    private double straty;
    
   

    public Licznik(String nrLicznika, int mnozna, double straty) {
        this.nrLicznika = nrLicznika;
        this.mnozna = mnozna;
        this.straty = straty;
    }
    
    

    public String getNrLicznika() {
        return nrLicznika;
    }

    public void setNrLicznika(String nrLicznika) {
        this.nrLicznika = nrLicznika;
    }

    public int getMnozna() {
        return mnozna;
    }

    public void setMnozna(int mnozna) {
        this.mnozna = mnozna;
    }

    public double getStraty() {
        return straty;
    }

    public void setStraty(double straty) {
        this.straty = straty;
    }
    
    
    
    
    
    
    
}
