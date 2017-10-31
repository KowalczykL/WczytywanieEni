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
public class Dystrybutor {
    private String nazwa;
    private String skrot;
    private String folderPlikow;

    public Dystrybutor(String nazwa, String skrot, String folderPlikow) {
        this.nazwa = nazwa;
        this.skrot = skrot;
        this.folderPlikow = folderPlikow;
    }
    
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getSkrot() {
        return skrot;
    }

    public void setSkrot(String skrot) {
        this.skrot = skrot;
    }

    public String getFolderPlikow() {
        return folderPlikow;
    }

    public void setFolderPlikow(String folderPlikow) {
        this.folderPlikow = folderPlikow;
    }
    
    
    
}
