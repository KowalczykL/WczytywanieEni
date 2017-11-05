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
public class ZuzycieTau implements Serializable{
    String ppe;
    String nrLicznika;
    String kodOt;
    String taryfa;
    String strefa;
    String dataOd;
    String dataDo;
    String wskPop;
    String wskBie;
    String zuzBru;
    String straty;
    String mnozna;
    String werDanych;
    String statOdc;
    String statRozl;
    String rodzajodc;

    
    public ZuzycieTau(String linijka) {
        String[] elem = linijka.split(";");
        
        this.ppe = elem[0];
        this.nrLicznika = elem[1];
        this.kodOt = elem[2];
        this.taryfa = elem[3];
        this.strefa = elem[4];
        this.dataOd = elem[5];
        this.dataDo = elem[6];
        this.wskPop = elem[7];
        this.wskBie = elem[8];
        this.zuzBru = elem[9];
        this.straty = elem[10];
        this.mnozna = elem[11];
        this.werDanych = elem[12];
        this.statOdc = elem[13];
        this.statRozl = elem[14];
        this.rodzajodc = elem[15];
        
    }

    public ZuzycieTau(String ppe, String nrLicznika, String kodOt, String taryfa, String strefa, String dataOd, String dataDo, String wskPop, String wskBie, String zuzBru, String straty, String mnozna, String werDanych, String statOdc, String statRozl, String rodzajodc) {
        this.ppe = ppe;
        this.nrLicznika = nrLicznika;
        this.kodOt = kodOt;
        this.taryfa = taryfa;
        this.strefa = strefa;
        this.dataOd = dataOd;
        this.dataDo = dataDo;
        this.wskPop = wskPop;
        this.wskBie = wskBie;
        this.zuzBru = zuzBru;
        this.straty = straty;
        this.mnozna = mnozna;
        this.werDanych = werDanych;
        this.statOdc = statOdc;
        this.statRozl = statRozl;
        this.rodzajodc = rodzajodc;
    }
    
    
    
    
    
    
    
    
    
    


    public ZuzycieTau() {
    }

    
    @Override
    public String toString() {
        return (this.ppe+";"+this.nrLicznika+";"+this.kodOt+";"+this.taryfa+";"+this.dataOd+";"+this.dataDo+";"+this.wskPop+";"+this.wskBie+";"+this.zuzBru+";"+this.straty+";"+this.mnozna+";"+this.werDanych+";"+this.statOdc+";"+this.statRozl+";"+this.rodzajodc);
    }

    public String getPpe() {
        return ppe;
    }

    public void setPpe(String ppe) {
        this.ppe = ppe;
    }

    public String getNrLicznika() {
        return nrLicznika;
    }

    public void setNrLicznika(String nrLicznika) {
        this.nrLicznika = nrLicznika;
    }

    public String getKodOt() {
        return kodOt;
    }

    public void setKodOt(String kodOt) {
        this.kodOt = kodOt;
    }

    public String getTaryfa() {
        return taryfa;
    }

    public void setTaryfa(String taryfa) {
        this.taryfa = taryfa;
    }

    public String getDataOd() {
        return dataOd;
    }

    public void setDataOd(String dataOd) {
        this.dataOd = dataOd;
    }

    public String getDataDo() {
        return dataDo;
    }

    public void setDataDo(String dataDo) {
        this.dataDo = dataDo;
    }

    public String getWskPop() {
        return wskPop;
    }

    public void setWskPop(String wskPop) {
        this.wskPop = wskPop;
    }

    public String getWskBie() {
        return wskBie;
    }

    public void setWskBie(String wskBie) {
        this.wskBie = wskBie;
    }

    public String getZuzBru() {
        return zuzBru;
    }

    public void setZuzBru(String zuzBru) {
        this.zuzBru = zuzBru;
    }

    public String getStraty() {
        return straty;
    }

    public void setStraty(String straty) {
        this.straty = straty;
    }

    public String getMnozna() {
        return mnozna;
    }

    public void setMnozna(String mnozna) {
        this.mnozna = mnozna;
    }

    public String getWerDanych() {
        return werDanych;
    }

    public void setWerDanych(String werDanych) {
        this.werDanych = werDanych;
    }

    public String getStatOdc() {
        return statOdc;
    }

    public void setStatOdc(String statOdc) {
        this.statOdc = statOdc;
    }

    public String getStatRozl() {
        return statRozl;
    }

    public void setStatRozl(String statRozl) {
        this.statRozl = statRozl;
    }

    public String getRodzajodc() {
        return rodzajodc;
    }

    public void setRodzajodc(String rodzajodc) {
        this.rodzajodc = rodzajodc;
    }

    public String getStrefa() {
        return strefa;
    }

    public void setStrefa(String strefa) {
        this.strefa = strefa;
    }
   
    
}
