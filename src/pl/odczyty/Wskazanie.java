/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

/**
 *
 * @author puszatek
 */
public class Wskazanie {
    String ppe;
    String licznik;
    String strefa;
    String data;
    String wartosc;
    String rodzaj;
    int ppeId;
    int licznikI;
    int licznikId;
    int strefaI;
    int wartoscI;

    public Wskazanie(String ppe, String licznik, String strefa, String data, String wartosc, String rodzaj) {
        this.ppe = ppe;
        this.licznik = licznik;
        this.strefa = strefa;
        this.data = data;
        this.wartosc = wartosc;
        this.rodzaj = rodzaj;
    }

    public Wskazanie() {
    }

    
    
    public Wskazanie(ZuzycieTau zuz){
        
     this.ppe = zuz.ppe;
        this.licznik = zuz.nrLicznika;
        this.strefa = zuz.ppe;
        this.data = data;
        this.wartosc = wartosc;
        this.rodzaj = rodzaj;   
    }
    
    
    
    
    
    @Override
    public String toString() {
        return "Wskazanie{" + "ppe=" + ppe + ", licznik=" + licznik + ", strefa=" + strefa + ", data=" + data + ", wartosc=" + wartosc + ", rodzaj=" + rodzaj + '}';
    }

    public String getPpe() {
        return ppe;
    }

    public void setPpe(String ppe) {
        this.ppe = ppe;
    }

    public String getLicznik() {
        return licznik;
    }

    public void setLicznik(String licznik) {
        this.licznik = licznik;
    }

    public String getStrefa() {
        return strefa;
    }

    public void setStrefa(String strefa) {
        this.strefa = strefa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getWartosc() {
        return wartosc;
    }

    public void setWartosc(String wartosc) {
        this.wartosc = wartosc;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public int getPpeId() {
        return ppeId;
    }

    public void setPpeId(int ppeId) {
        this.ppeId = ppeId;
    }

    public int getLicznikI() {
        return licznikI;
    }

    public void setLicznikI(int licznikI) {
        this.licznikI = licznikI;
    }

    public int getLicznikId() {
        return licznikId;
    }

    public void setLicznikId(int licznikId) {
        this.licznikId = licznikId;
    }

    public int getStrefaI() {
        return strefaI;
    }

    public void setStrefaI(int strefaI) {
        this.strefaI = strefaI;
    }

    public int getWartoscI() {
        return wartoscI;
    }

    public void setWartoscI(int wartoscI) {
        this.wartoscI = wartoscI;
    }
    
}
