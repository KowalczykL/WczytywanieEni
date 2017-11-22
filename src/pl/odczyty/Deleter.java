/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Deleter {
    
    public static void delete(String co, String gdzie, String where){ //jak wlasciwie działa ten select i rs
    //Boolean test = false;
        Connection c = null;
        PreparedStatement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         
         stmt = c.prepareStatement("DELETE FROM Table WHERE name = ?");
         
         //stmt.setString(1,name);
        stmt.executeUpdate(); 
         //stmt = c.createStatement();
         //ResultSet rs;
         //rs = stmt.executeQuery("DELETE "+co+" FROM "+gdzie+" WHERE "+where);
         
//      if (rs.next())
//      {test = true;}
//         else{test = false;}
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
       
              //if(test){System.out.println("Ppe.czyIstnieje -- juz istnieje");}
              //else {System.out.println("Ppe.czyIstnieje -- nie istnieje - ZAPISZ");}    
              //return test;
     }
    
        public static void delete(String komenda){ //jak wlasciwie działa ten select i rs

        //c = null;
        Statement stmt = null;
              try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");

        //stmt = c.prepareStatement(komenda);
        stmt.executeUpdate(komenda); 
        c.close();
                  
                  
                  
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
       
              //if(test){System.out.println("Ppe.czyIstnieje -- juz istnieje");}
              //else {System.out.println("Ppe.czyIstnieje -- nie istnieje - ZAPISZ");}    
              //return test;
     }
     
}
