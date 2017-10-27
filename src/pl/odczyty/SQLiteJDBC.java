/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.sql.*;


public class SQLiteJDBC {
        public static boolean czyWczytany (String plik){
        Boolean test = false;
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");
         
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT NAZWA FROM WCZYTANE_PLIKI");
         while (rs.next()){
         String wyniki = rs.getString("NAZWA");
         if (plik.equals(wyniki)){
             test = true;             
         }
         
         System.out.println(plik+wyniki);
         
         
         }
        // String sql = "INSERT INTO OdczytyT (PPE,DATA,TARYFA,WSKBIE) " +
              //     "VALUES ('"+odc.ppe+"',"+odc.data+",'C12','123');"; 
                 //  "VALUES ('12', "+odc.data+", "+odc.taryfa+", "+odc.wskBie+", "+odc.strefa+", "+odc.mnozna+" );"; 
         
                 
                 
                 //stmt.executeUpdate(sql);
         //stmt.close();
         //c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println(test);
        
      return test;  
    }
    
    
      public static void zapiszOdczyt( Odczyt odc ) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");
         
         stmt = c.createStatement();
         String sql = "INSERT INTO OdczytyT (PPE,DATA,TARYFA,WSKBIE) " +
                   "VALUES ('"+odc.ppe+"',"+odc.data+",'C12','123');"; 
                 //  "VALUES ('12', "+odc.data+", "+odc.taryfa+", "+odc.wskBie+", "+odc.strefa+", "+odc.mnozna+" );"; 
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
    
    
   public static void tworzTabele( String baza, String tabela ) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:"+baza+".db");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "CREATE TABLE "+tabela+" " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " PPE           TEXT    NOT NULL, " + 
                        " STREFA            INT     NOT NULL, " + 
                        " WSKAZANIE        CHAR(50), " + 
                        " SALARY         REAL)"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   } 
    
    
  public static void tworzBaze(String nazwa) {
      Connection c = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:"+nazwa+".db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }
}