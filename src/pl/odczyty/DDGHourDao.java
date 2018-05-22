/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class DDGHourDao {
    
    
    
    public static boolean save(DdgHour ddgHour)
    {
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
         String sql = "INSERT INTO DDG (PPE,DATA,USAGE,STATUS,VERSIONS,VERSIONINT) " +
                   "VALUES ('"+ddgHour.getPpe()+"','"+ddgHour.getData()+"','"+ddgHour.getUsage()+"','"+ddgHour.getStatus()+"','"+ddgHour.getVersionInt()+"');"; 
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
  
      return false;  
    }      
 
        public static boolean isAlreadySaved(DdgHour ddgHour)
    {
        
        
      return false;  
    } 
    
    
    
}
