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
public class DDGHour {
    private int id;
    private String ppe;
    private String data;
    private float usage;
    private String status;
    private String versionS;
    private int versionInt;

    public DDGHour(int id, String ppe, String data, float usage, String status, String versionS, int versionInt) {
        this.id = id;
        this.ppe = ppe;
        this.data = data;
        this.usage = usage;
        this.status = status;
        this.versionS = versionS;
        this.versionInt = versionInt;
    }

    
    
    
    public int getId() {
        return id;
    }

    public String getPpe() {
        return ppe;
    }

    public String getData() {
        return data;
    }

    public float getUsage() {
        return usage;
    }

    public String getStatus() {
        return status;
    }

    public String getVersionS() {
        return versionS;
    }

    public int getVersionInt() {
        return versionInt;
    }
    
    
    
    
    
}