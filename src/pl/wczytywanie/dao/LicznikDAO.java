/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wczytywanie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import pl.odczyty.Licznik;

/**
 *
 * @author puszatek
 */
public class LicznikDAO {
    
    //public static Licznik odtworz (){
        
        
        
    //}
    
    
    
    
    
    
    
    
    
    public boolean zapisz (Licznik licznik){
      Connection c = null;
      Statement stmt = null;  
       try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");
         
         stmt = c.createStatement();
         String sql = "INSERT INTO LICZNIK (NR_LICZNIKA,MNOZNA,STRATY) " +
                   "VALUES ('"+licznik.getNrLicznika()+"',"+licznik.getMnozna()+","+licznik.getStraty()+");"; 
                 //  "VALUES ('12', "+odc.data+", "+odc.taryfa+", "+odc.wskBie+", "+odc.strefa+", "+odc.mnozna+" );"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      } 
     return true;
        
        
    }
    
    
    
    
    
}
