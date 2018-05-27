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
public class DdgDayDao implements Dao {

    @Override
    public boolean isInBase(Object ddgDayO) { //jak wlasciwie działa ten select i rs
    DdgDay ddgDay = (DdgDay) ddgDayO;
        Boolean test = false;
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM DDG_DAY WHERE PPE = '"+ddgDay.getPpe()+"' AND DATE = '"+ddgDay.getDataS()+"' AND VERSION='"+ddgDay.getVersion()+"'");
      
         if (rs.next())
      {test = true;}
         else{test = false;}
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
       
              if(test){System.out.println("DdgDay.czyIstnieje -- juz istnieje");}
              else {System.out.println("DdgDay.czyIstnieje -- nie istnieje - ZAPISZ");}    
              return test;
     }

    @Override
    public void saveAnyway(Object ddgDayO) {
        DdgDay ddgDay = (DdgDay) ddgDayO;
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
         String sql = "INSERT INTO DDG_DAY (OSD,PPE,DATE,FILE_NAME,VERSION,NR_OF_HOURS,DAY_VAL,HR_1_VAL,HR_2_VAL,HR_3_VAL,HR_4_VAL,HR_5_VAL,HR_6_VAL,HR_7_VAL,HR_8_VAL,HR_9_VAL,HR_10_VAL,HR_11_VAL,HR_12_VAL,HR_13_VAL,HR_14_VAL,HR_15_VAL,HR_16_VAL,HR_17_VAL,HR_18_VAL,HR_19_VAL,HR_20_VAL,HR_21_VAL,HR_22_VAL,HR_23_VAL,HR_24_VAL,HR_2A_VAL,HR_1_STAT,HR_2_STAT,HR_3_STAT,HR_4_STAT,HR_5_STAT,HR_6_STAT,HR_7_STAT,HR_8_STAT,HR_9_STAT,HR_10_STAT,HR_11_STAT,HR_12_STAT,HR_13_STAT,HR_14_STAT,HR_15_STAT,HR_16_STAT,HR_17_STAT,HR_18_STAT,HR_19_STAT,HR_20_STAT,HR_21_STAT,HR_22_STAT,HR_23_STAT,HR_24_STAT,HR_2A_STAT) " +
                   "VALUES ('"+ddgDay.getOsd()+"','"+ddgDay.getPpe()+"','"+ddgDay.getDataS()+"','"+ddgDay.getFileName()+"','"+ddgDay.getVersion()+"','"+ddgDay.getNumberOfHours()+"','"+ddgDay.getDayVal()+"','"+ddgDay.getHour1val()+"','"+ddgDay.getHour2val()+"','"+ddgDay.getHour3val()+"','"+ddgDay.getHour4val()+"','"+ddgDay.getHour5val()+"','"+ddgDay.getHour6val()+"','"+ddgDay.getHour7val()+"','"+ddgDay.getHour8val()+"','"+ddgDay.getHour9val()+"','"+ddgDay.getHour10val()+"','"+ddgDay.getHour11val()+"','"+ddgDay.getHour12val()+"','"+ddgDay.getHour13val()+"','"+ddgDay.getHour14val()+"','"+ddgDay.getHour15val()+"','"+ddgDay.getHour16val()+"','"+ddgDay.getHour17val()+"','"+ddgDay.getHour18val()+"','"+ddgDay.getHour19val()+"','"+ddgDay.getHour20val()+"','"+ddgDay.getHour21val()+"','"+ddgDay.getHour22val()+"','"+ddgDay.getHour23val()+"','"+ddgDay.getHour24val()+"','"+ddgDay.getHour2Aval()+"','"+ddgDay.getHour1Status()+"','"+ddgDay.getHour2Status()+"','"+ddgDay.getHour3Status()+"','"+ddgDay.getHour4Status()+"','"+ddgDay.getHour5Status()+"','"+ddgDay.getHour6Status()+"','"+ddgDay.getHour7Status()+"','"+ddgDay.getHour8Status()+"','"+ddgDay.getHour9Status()+"','"+ddgDay.getHour10Status()+"','"+ddgDay.getHour11Status()+"','"+ddgDay.getHour12Status()+"','"+ddgDay.getHour13Status()+"','"+ddgDay.getHour14Status()+"','"+ddgDay.getHour15Status()+"','"+ddgDay.getHour16Status()+"','"+ddgDay.getHour17Status()+"','"+ddgDay.getHour18Status()+"','"+ddgDay.getHour19Status()+"','"+ddgDay.getHour20Status()+"','"+ddgDay.getHour21Status()+"','"+ddgDay.getHour22Status()+"','"+ddgDay.getHour23Status()+"','"+ddgDay.getHour24Status()+"','"+ddgDay.getHour2AStatus()+"');"; 
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
}

    
    
    
    
    @Override
    public DdgDay returnById(long id) {
        DdgDay ddgDay = new DdgDay();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM DDG_DAY WHERE ID='" + id + "'");
            while (rs.next()) {

                ddgDay.setId(rs.getLong("ID"));

                ddgDay.setOsd(rs.getString("OSD"));
                ddgDay.setPpe(rs.getString("PPE"));
                ddgDay.setDataS(rs.getString("DATE"));

                //może konwersja daty
                ddgDay.setFileName(rs.getString("FILE_NAME"));
                ddgDay.setVersion(rs.getInt("VERSION"));
                ddgDay.setNumberOfHours(rs.getInt("NR_OF_HOURS"));
// DayVal Should Do the job itself
                ddgDay.setHour1val(rs.getDouble("HR_1_VAL"));
                ddgDay.setHour2val(rs.getDouble("HR_2_VAL"));
                ddgDay.setHour3val(rs.getDouble("HR_3_VAL"));
                ddgDay.setHour4val(rs.getDouble("HR_4_VAL"));
                ddgDay.setHour5val(rs.getDouble("HR_5_VAL"));
                ddgDay.setHour6val(rs.getDouble("HR_6_VAL"));
                ddgDay.setHour7val(rs.getDouble("HR_7_VAL"));
                ddgDay.setHour8val(rs.getDouble("HR_8_VAL"));
                ddgDay.setHour9val(rs.getDouble("HR_9_VAL"));
                ddgDay.setHour10val(rs.getDouble("HR_10_VAL"));
                ddgDay.setHour11val(rs.getDouble("HR_11_VAL"));
                ddgDay.setHour12val(rs.getDouble("HR_12_VAL"));
                ddgDay.setHour13val(rs.getDouble("HR_13_VAL"));
                ddgDay.setHour14val(rs.getDouble("HR_14_VAL"));
                ddgDay.setHour15val(rs.getDouble("HR_15_VAL"));
                ddgDay.setHour16val(rs.getDouble("HR_16_VAL"));
                ddgDay.setHour17val(rs.getDouble("HR_17_VAL"));
                ddgDay.setHour18val(rs.getDouble("HR_18_VAL"));
                ddgDay.setHour19val(rs.getDouble("HR_19_VAL"));
                ddgDay.setHour20val(rs.getDouble("HR_20_VAL"));
                ddgDay.setHour21val(rs.getDouble("HR_21_VAL"));
                ddgDay.setHour22val(rs.getDouble("HR_22_VAL"));
                ddgDay.setHour23val(rs.getDouble("HR_23_VAL"));
                ddgDay.setHour24val(rs.getDouble("HR_24_VAL"));
                ddgDay.setHour2Aval(rs.getDouble("HR_2A_VAL"));

                ddgDay.setHour1Status(rs.getInt("HR_1_STAT"));
                ddgDay.setHour2Status(rs.getInt("HR_2_STAT"));

            }
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return ddgDay;
    }

    @Override
    public void saveIfNew(Object ddgDayO) {
            DdgDay ddgDay = (DdgDay) ddgDayO;
            
    if( !this.isInBase(ddgDay)) {
        System.out.print("not saved");
        this.saveAnyway(ddgDay);
    } else {
       System.out.print("already saved");
    }
    }

}
