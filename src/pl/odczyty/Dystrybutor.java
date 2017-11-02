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
        
       System.out.println("DYST.pobDyst - Otrzymałem parametr"+skrot);
       //Dystrybutor dyst = new Dystrybutor();
        Connection c = null;
        Statement stmt = null;
        Dystrybutor dyst = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM DYST WHERE SKROT='TAU'");
         System.out.println("DYST.pobDyst -NAZWA Dyst z bazy"+rs.getString("NAZWA"));
         System.out.println("DYST.pobDyst -NAZWA Dyst z bazy"+rs.getString("SKROT"));
         System.out.println("DYST.pobDyst -NAZWA Dyst z bazy"+rs.getString("FOLDER"));
         this.nazwa = rs.getString("NAZWA");
         this.skrot = rs.getString("SKROT");
         this.folder = rs.getString("FOLDER");
         
         
         
         
         
         //ResultSet rsSkrot;
         //rsSkrot = stmt.executeQuery("SELECT SKROT FROM DYST");
         //System.out.println("DYST.pobDyst -NAZWA Dyst z bazy"+rsNazwa.getString("SKROT"));
         
         //ResultSet rsFolder;
         //rsFolder = stmt.executeQuery("SELECT FOLDER FROM DYST WHERE ID=1");
         //System.out.println("DYST.pobDyst -NAZWA Dyst z bazy"+rsNazwa);
         
         //dyst = new Dystrybutor(rs.getString("NAZWA"),rs.getString("SKROT"),rs.getString("FOLDER"));
         //dyst = new Dystrybutor("NAZWA","SKROT","FOLDER");
         
         //System.out.println("DYST.pobDyst -po zbudowaniu obiektu dyst"+dyst);
         
         //while (rs.next()){
         //String wyniki = rs.getString("NAZWA");
         //if (plik.equals(wyniki)){
         //    test = true;             
         //}
         //}
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      //System.out.println("SQLiteJDBC,czyEczytany: return - "+test);
        //if(!test){
        //    System.out.println("SQLiteJDBC.czyWczytany: Do wczytania - "+plik.toString());
        //}
        //else{System.out.println("SQLiteJDBC.czyWczytany: Nic do wczytania");}
      //return dyst; 
      
        
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
