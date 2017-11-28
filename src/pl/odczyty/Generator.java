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
public class Generator {
  
    
    
    
    
    
    public static int[] getTwoNewestPhisicalIndicationsIds(Ppe ppe){   
        int[] indiationsIds = Generator.getTwoNewestPhisicalIndicationsIds(ppe.getNrPpe());
        return indiationsIds; 
    }
    
    
    
    /**
     *return newest indications' IDs for input ppe
     * @param ppe
     * @return int[]
     */
    public static int[] getTwoNewestPhisicalIndicationsIds(String ppe){
       boolean desc = true;
        int i =0;
     int[] indiationsIds = new int[2];
     
             Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM WSKAZANIA WHERE PPE='"+ppe+"' AND RODZAJ = 'PLIK' ORDER BY DATALOC DESC LIMIT 2");
      while (rs.next()){
          indiationsIds[i]=rs.getInt("ID");
          if(desc){System.out.print("Generator.ID- "+rs.getString("ID")+"; ");}
          if(desc){System.out.print("Generator.WART- "+rs.getString("WARTOSC")+"; ");}
          if(desc){System.out.print("Generator.RODZ- "+rs.getString("RODZAJ")+"; ");}
          if(desc){System.out.print("Generator.DATA- "+rs.getString("DATALOC")+"; ");}
          if(desc){System.out.println("Generator.ZRODLO- "+rs.getString("ZRODLO"));}
          i++;
          
//        this.nrPpe = (rs.getString("NRPPE"));
//        this.taryfa = (rs.getString("TARYFA"));
//        this.taryfaId = (rs.getInt("TARYFAID"));
//        this.dystrybutor = (rs.getString("DYSTRYBUTOR"));
//        this.dystrybutorId = (rs.getInt("DYSTRYBUTORID"));
//        this.metSza = (rs.getInt("METSZA"));
//        this.Id = id;
          }
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
     
     
     
     
     
     
     
     
     
     return indiationsIds; 
 }   
    
    
    
    
    
    
}
