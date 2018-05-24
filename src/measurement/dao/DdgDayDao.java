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
 * @author Łukasz Kowalczyk
 */
public class DdgDayDao implements Dao{



    


    @Override
    public void isInBase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DdgDay returnById(long id) {
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM DDG_DAY WHERE ID='"+id+"'");
      while (rs.next()){
          
          
        this.nrPpe = (rs.getString("NRPPE"));
        this.taryfa = (rs.getString("TARYFA"));
        this.taryfaId = (rs.getInt("TARYFAID"));
        this.dystrybutor = (rs.getString("DYSTRYBUTOR"));
        this.dystrybutorId = (rs.getInt("DYSTRYBUTORID"));
        this.metSza = (rs.getInt("METSZA"));
        this.Id = id;
        
        
          }
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
     }
    
}
