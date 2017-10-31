/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Łukasz Kowalczyk
 */

@Entity
@Table(name="PPE")
public class Ppe implements Serializable{
  @Column(name="ID", unique=true)
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int ppeId; 
  @Column(name="PPE", unique=true)  
  private String ppe;
  @Column(name="LICZNIK_ID")
  private int licznikId;  
  @Column(name="TARYFA_ID")
  private int taryfaId;
  
  
  

    public String getPpe() {
        return ppe;
    }

    public void setPpe(String ppe) {
        this.ppe = ppe;
    }

    public int getLicznikId() {
        return licznikId;
    }

    public void setLicznikId(int licznikId) {
        this.licznikId = licznikId;
    }

    public int getTaryfaId() {
        return taryfaId;
    }

    public void setTaryfaId(int taryfaId) {
        this.taryfaId = taryfaId;
    }
  
}
