/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Łukasz Kowalczyk
 */
//readings per one hour of a day, 23-25 per day
@Entity
@Table(name = "ddg_hour")
public class DdgHour {

    @Id  @GeneratedValue
    private long id;
    private String ppe;
    private String data;
    private double usage;
    private int statusInt;
    private int versionInt;

    public DdgHour(long id, String ppe, String data, double usage, int status,  int versionInt) {
        this.id = id;
        this.ppe = ppe;
        this.data = data;
        this.usage = usage;
        this.statusInt = status;
        this.versionInt = versionInt;
    }

    public DdgHour(String ppe, String data, double usage, int status,  int versionInt) {
        this.ppe = ppe;
        this.data = data;
        this.usage = usage;
        this.statusInt = status;
        this.versionInt = versionInt;
    }
    
    
    
    
    
    

    public long getId() {
        return id;
    }

    public String getPpe() {
        return ppe;
    }

    public String getData() {
        return data;
    }

    public double getUsage() {
        return usage;
    }

    public int getStatus() {
        return statusInt;
    }

    public int getVersionInt() {
        return versionInt;
    }

}
