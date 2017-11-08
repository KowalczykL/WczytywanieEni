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
public class Dystrybutor {
    private String nazwa;
    private String skrot;
    private String folder;

    public Dystrybutor(String nazwa, String skrot, String folder) {
        this.nazwa = nazwa;
        this.skrot = skrot;
        this.folder = folder;
    }

    public Dystrybutor() {
    }

    @Override
    public String toString() {
        return "Dystrybutor{" + "nazwa=" + nazwa + ", skrot=" + skrot + ", folder=" + folder + '}';
    }
    
    
    
    
    public Dystrybutor (String skrot){
        
       //System.out.println("DYST.pobDyst - Otrzymałem parametr"+skrot);
        Connection c = null;
        Statement stmt = null;
        Dystrybutor dyst = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM DYSTRYBUTORZY WHERE SKROT='TAU'");
         //System.out.println("DYSTRYBUTORZY.pobDyst -NAZWA Dyst z bazy"+rs.getString("NAZWA"));
         //System.out.println("DYST.pobDyst -NAZWA Dyst z bazy"+rs.getString("SKROT"));
         //System.out.println("DYST.pobDyst -NAZWA Dyst z bazy"+rs.getString("FOLDER"));
         this.nazwa = rs.getString("NAZWA");
         this.skrot = rs.getString("SKROT");
         this.folder = rs.getString("FOLDER");
         

         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }

       System.out.println("DYST - Utworzono obiekt Dystrybutor - "+this.nazwa+this.skrot+this.folder); 
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
    
    
    
}
