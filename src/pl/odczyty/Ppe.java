/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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

public class Ppe implements Serializable{
  private int Id;
  private String nrPpe;
  private String taryfa;
  private int taryfaId;
  private String dystrybutor;
  private int dystrybutorId;
  private int metSza;

    public Ppe() {
    }

  
  
    public Ppe(String ppe, String taryfa, String dystrybutor) {
        this.nrPpe = ppe;
        this.taryfa = taryfa;
        //this.taryfaId = taryfaId;
        this.dystrybutor = dystrybutor;
        this.dystrybutorId = Osd.zwrocId(dystrybutor);
        this.metSza = 1;
    }
  
    
    
    public Ppe (int id){
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM PPE WHERE ID='"+id+"'");
      while (rs.next()){
        this.nrPpe = (rs.getString("NRPPE"));
        this.taryfa = (rs.getString("TARYFA"));
        this.taryfaId = (rs.getInt("TARYFAID"));
        this.dystrybutor = (rs.getString("DYSTRYBUTOR"));
        this.dystrybutorId = (rs.getInt("DYSTRYBUTORID"));
        this.metSza = (rs.getInt("METSZA"));
        this.Id = id;
          }
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
     }
    
    public static void listPpe(){
        
        
        
        
    }
    
    public static void zapisz(ArrayList<Ppe> ppe){
        for (Ppe ppe1 : ppe){
            if (!ppe1.czyIstnieje(ppe1)){ppe1.zapisz(ppe1);}
        }}
    
    public static int zwrocId(String ppe){
        int wynik = -1;
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM PPE WHERE NRPPE='"+ppe+"'");
      while (rs.next()){
        wynik = (rs.getInt("ID"));
          }
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
              return wynik;
     }
    
        public boolean czyIstnieje (Ppe ppe){ //jak wlasciwie działa ten select i rs
    Boolean test = false;
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM PPE WHERE NRPPE='"+this.nrPpe+"'");
      if (rs.next())
      {test = true;}
         else{test = false;}
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
       
              if(test){System.out.println("Ppe.czyIstnieje -- juz istnieje");}
              else {System.out.println("Ppe.czyIstnieje -- nie istnieje - ZAPISZ");}    
              return test;
     }
    
  public void zapisz(Ppe ppe){
        
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");
         
         stmt = c.createStatement();
         //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         //LocalDate dataLoc = LocalDate.parse(this.data, formatter);
         String sql = "INSERT INTO PPE (NRPPE,TARYFA,TARYFAID,DYSTRYBUTOR,DYSTRYBUTORID,METSZA) " +
                   "VALUES ('"+this.nrPpe+"','"+this.taryfa+"','"+this.taryfaId+"','"+this.dystrybutor+"','"+this.dystrybutorId+"','"+this.metSza+"');"; 
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
        return "Ppe{" + "Id=" + Id + ", nrPpe=" + nrPpe + ", taryfa=" + taryfa + ", taryfaId=" + taryfaId + ", dystrybutor=" + dystrybutor + ", dystrybutorId=" + dystrybutorId + ", metSza=" + metSza + '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNrPpe() {
        return nrPpe;
    }

    public void setNrPpe(String nrPpe) {
        this.nrPpe = nrPpe;
    }

    public String getTaryfa() {
        return taryfa;
    }

    public void setTaryfa(String taryfa) {
        this.taryfa = taryfa;
    }

    public int getTaryfaId() {
        return taryfaId;
    }

    public void setTaryfaId(int taryfaId) {
        this.taryfaId = taryfaId;
    }

    public String getDystrybutor() {
        return dystrybutor;
    }

    public void setDystrybutor(String dystrybutor) {
        this.dystrybutor = dystrybutor;
    }

    public int getDystrybutorId() {
        return dystrybutorId;
    }

    public void setDystrybutorId(int dystrybutorId) {
        this.dystrybutorId = dystrybutorId;
    }

    public int getMetSza() {
        return metSza;
    }

    public void setMetSza(int metSza) {
        this.metSza = metSza;
    }
  
  
    
  
}
