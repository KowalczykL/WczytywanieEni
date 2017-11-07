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

    public Ppe(String ppe, String taryfa, String dystrybutor) {
        this.nrPpe = ppe;
        this.taryfa = taryfa;
        //this.taryfaId = taryfaId;
        this.dystrybutor = dystrybutor;
        //this.dystrybutorId = dystrybutorId;
        this.metSza = 1;
    }
  
    
    public Ppe (int id){ //jak wlasciwie działa ten select i rs
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
        this.nrPpe = (rs.getString("PPE"));
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
    
    public void zapisz (ArrayList<Ppe> ppe){
        for (Ppe ppe1 : ppe){
            ppe1.zapisz(ppe1);
        }}
    
    
    
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
         rs = stmt.executeQuery("SELECT * FROM PPE WHERE PPE='"+this.nrPpe+"'");
      if (rs.next())
      {test = true;}
         else{test = false;}
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
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
         String sql = "INSERT INTO PPE (PPE,TARYFA,TARYFAID,DYSTRYBUTOR,DYSTRYBUTOORID,METSZA) " +
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
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

    
  
}
