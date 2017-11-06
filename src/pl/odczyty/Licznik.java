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
    private String mnozna;
    private String straty;
    private int nrLicznikaInt;
    private byte mnoznaInt;
    private double stratyInt;
    private int licznikId;
    
   

    public Licznik(String nrLicznika, String mnozna, String straty) {
        this.nrLicznika = nrLicznika;
        this.mnozna = mnozna;
        this.straty = straty;
        this.nrLicznikaInt = Integer.parseInt(nrLicznika);
        this.mnoznaInt = Byte.parseByte(mnozna);
        this.stratyInt = Double.parseDouble(straty);
    }
    
    


    
    
    
    
    
    
    
}
