/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class DbQuerier {
    
    
    public ResultSet doQuery(String query)
        {
         ResultSet rs = null;            
        int wynik = -1;
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();

         rs = stmt.executeQuery(query);
                              while (rs.next())
            {
           for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
              System.out.print(" " + rs.getMetaData().getColumnName(i) + "=" + rs.getObject(i));
            }
              System.out.println();           
            }
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
              return rs;
     }
    
    public ResultSet doQuery(String type, String table)
        {
         ResultSet rs = null;            
        int wynik = -1;
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         System.out.println(type+" * FROM "+table);
         rs = stmt.executeQuery(type+" * FROM "+table);
                     while (rs.next())
            {
           for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
              System.out.print(" " + rs.getMetaData().getColumnName(i) + "=" + rs.getObject(i));
            }
              System.out.println();           
            }
         
         
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
              return rs;
     }



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

    
    
    
}
