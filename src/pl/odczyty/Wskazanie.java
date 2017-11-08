/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author puszatek
 */
public class Wskazanie {
    //public static DateTimeFormatter formTau = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    String ppe;
    String licznik;
    String strefa;
    String data;
    //LocalDate dataLoc = LocalDate.parse(data, this.formTau);
    String wartosc;
    String rodzaj;
    String zrodlo;
    int ppeId;
    int licznikInt;
    int licznikId;
    int strefaI;
    int wartoscI;

    
    
    
    
    
    public Wskazanie(String ppe, String licznik, String strefa, String data, String wartosc, String rodzaj, String zrodlo) {
        this.ppe = ppe;
        this.licznik = licznik;
        this.strefa = strefa;
        this.data = data;
        this.wartosc = wartosc;
        this.rodzaj = rodzaj;
        this.zrodlo = zrodlo;
        //DateTimeFormatter formTau = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate dataLoc = LocalDate.parse(data, this.formTau);
    }

    public Wskazanie() {
    }

     public Wskazanie (int id){ //jak wlasciwie działa ten select i rs
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM WSKAZANIA WHERE ID='"+id+"'");
      

        while (rs.next()){
            
            

        this.ppe = (rs.getString("PPE"));
        
        

        this.licznik = (rs.getString("LICZNIK"));

        this.strefa = (rs.getString("STREFA"));
        this.data = (rs.getString("DATA"));
        this.wartosc = (rs.getString("WARTOSC"));
        this.rodzaj = (rs.getString("RODZAJ"));
        this.zrodlo = (rs.getString("ZRODLO"));
         
         
         }
    
        
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
    
     }
    
    public Wskazanie(ZuzycieTau zuz){
        
     this.ppe = zuz.ppe;
        this.licznik = zuz.nrLicznika;
        this.strefa = zuz.ppe;
        this.data = data;
        this.wartosc = wartosc;
        this.rodzaj = rodzaj;   
    }
    
    public boolean czyIstnieje (Wskazanie wsk){ //jak wlasciwie działa ten select i rs
    
        Boolean test = false;
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM WSKAZANIA WHERE PPE='"+this.ppe+"' AND DATA='"+this.data+"' AND WARTOSC='"+this.wartosc+"'");
      
      if (rs.next()){
     
         test = true;
        
       }
         else{
   
           
           test = false; 

         }
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
       return test;
     }
    
    
    
    
    public void zapisz (ArrayList<Wskazanie> wsk){
        for (Wskazanie wsk1 : wsk){
            wsk1.zapisz(wsk1);
        } 
        
        
    }
    
    
    public void zapisz (Wskazanie wsk){
        
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");
         
         stmt = c.createStatement();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         LocalDate dataLoc = LocalDate.parse(this.data, formatter);
         String sql = "INSERT INTO WSKAZANIA (PPE,LICZNIK,DATA,DATALOC,STREFA,WARTOSC,RODZAJ,ZRODLO) " +
                   "VALUES ('"+wsk.ppe+"','"+wsk.licznik+"','"+wsk.data+"','"+dataLoc+"','"+wsk.strefa+"','"+wsk.wartosc+"','"+wsk.rodzaj+"','"+wsk.zrodlo+"');"; 
                 //  "VALUES ('12', "+odc.dataOd+", "+odc.taryfa+", "+odc.wskBie+", "+odc.strefa+", "+odc.mnozna+" );"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
   
}
    
    
   
    
    
    @Override
    public String toString() {
        return (this.ppe+";"+this.licznik+";"+this.strefa+";"+this.data+";"+this.wartosc+";"+this.rodzaj);
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
        return licznikInt;
    }

    public void setLicznikI(int licznikI) {
        this.licznikInt = licznikI;
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
