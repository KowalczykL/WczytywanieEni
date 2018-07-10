/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Osd {
    private String nazwa;
    private String skrot;
    private String folder;
    private String fxls;
    private String dataFormat;

    public Osd(String nazwa, String skrot, String folder, String fxls) {
        this.nazwa = nazwa;
        this.skrot = skrot;
        this.folder = folder;
        this.fxls = fxls;
    }

    public Osd() {
    }

    @Override
    public String toString() {
        return "Dystrybutor{" + "nazwa=" + nazwa + ", skrot=" + skrot + ", folder=" + folder + '}';
    }
    
    
    
    
    public Osd (String skrot){
        
       //System.out.println("DYST.pobDyst - Otrzymałem parametr"+skrot);
        Connection c = null;
        Statement stmt = null;
        Osd dyst = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM DYSTRYBUTORZY WHERE SKROT='"+skrot+"'");
         //System.out.println("DYSTRYBUTORZY.pobDyst -NAZWA Dyst z bazy"+rs.getString("NAZWA"));
         //System.out.println("DYST.pobDyst -NAZWA Dyst z bazy"+rs.getString("SKROT"));
         System.out.println("DYST.pobDyst -NAZWA Dyst z bazy"+rs.getString("FXLS"));
         this.nazwa = rs.getString("NAZWA");
         this.skrot = rs.getString("SKROT");
         this.folder = rs.getString("FOLDER");
         this.fxls = rs.getString("FXLS");
         this.dataFormat = rs.getString("PARSER");
         
         

         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }

       System.out.println("DYST - Utworzono obiekt Dystrybutor - "+this.nazwa+this.skrot+this.folder+this.fxls); 
    }
    
        public static int zwrocId(String dystSkr){
        int wynik = -1;
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM DYSTRYBUTORZY WHERE SKROT='"+dystSkr+"'");
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

    public String getFolder() {
        return folder;
    }

    public void setFolderPlikow(String folderPlikow) {
        this.folder = folderPlikow;
    }

    public String getFxls() {
        return fxls;
    }

    public void setFxls(String fxls) {
        this.fxls = fxls;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }
    
    
    
}
