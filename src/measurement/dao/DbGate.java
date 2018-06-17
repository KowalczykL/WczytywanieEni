/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package measurement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import pl.odczyty.DdgDay;

/**
 *
 * @author puszatek
 */
public class DbGate {

    
    
    
        public void saveAnywayByObjectQuery(String[] elements) {
            String query = "";
            query = "INSERT INTO "+elements[0]+" "+elements[1]+" VALUES "+elements[2];
            System.out.println("query from []"+query);
            this.saveAnywayByObjectQuery(query);
            
        }
        
    
    
    
    
    
    
    public void saveAnywayByObjectQuery(String query) {

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
         stmt.executeUpdate(query);
         stmt.close();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Records created successfully");
}

    public boolean isInBaseByObjectQuery(String query) {

        Boolean test = false;
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                test = true;
            } else {
                test = false;
            }
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if (test) {
            System.out.println("DdgDay.czyIstnieje -- juz istnieje");
        } else {
            System.out.println("DdgDay.czyIstnieje -- nie istnieje - ZAPISZ");
        }
        return test;

    }

}
