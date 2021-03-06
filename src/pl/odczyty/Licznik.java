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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Licznik {
    private String nrLicznika;
    private String mnozna;
    private String straty;
    private long nrLicznikaInt;
    private int mnoznaInt;
    private double stratyInt;
    private int Id;

    public Licznik() {
    }
    
   

    public Licznik(String nrLicznika, String mnozna, String straty) {
        this.nrLicznika = nrLicznika;
        this.mnozna = mnozna;
        this.straty = straty;
        this.nrLicznikaInt = Long.parseLong(nrLicznika);
        this.mnoznaInt = Integer.parseInt(mnozna);
        this.stratyInt = Double.parseDouble(straty);
    }
    
    public Licznik (int id){ //jak wlasciwie działa ten select i rs
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM LICZNIKI WHERE ID='"+id+"'");
      while (rs.next()){
        this.nrLicznika = (rs.getString("NRLICZNIKA"));
        this.mnozna = (rs.getString("MNOZNA"));
        this.straty = (rs.getString("STRATY"));
        this.nrLicznikaInt = (rs.getLong("NRLICZNIKAINT"));
        this.mnoznaInt = (rs.getInt("MNOZNAINT"));
        this.stratyInt = (rs.getDouble("STRATYINT"));
        this.Id = id;
          }
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
     }


    public static double liczStraty (ZuzycieTau zuzycie){
        return Licznik.liczStraty(zuzycie.straty,zuzycie.zuzBru);
        /*double straty = 0;
        double licznik = 0;
        double mianownik = 0;
        
        if (zuzycie.straty != null && !zuzycie.straty.isEmpty()){licznik = Double.parseDouble(zuzycie.straty);}
        if (zuzycie.zuzBru != null && !zuzycie.zuzBru.isEmpty()){mianownik = Double.parseDouble(zuzycie.zuzBru);}
        if (licznik == 0 || mianownik == 0){straty = 0;}
        else{straty = licznik/mianownik;} 
        return straty;*/
    }
    
        public static double liczStraty (String licznik, String mianownik){
        double straty = 0;
        double licznik1 = 0;
        double mianownik1 = 0;
        licznik.replace(",", ".");
        mianownik.replace(",", ".");
        if (licznik != null && !licznik.isEmpty()){licznik1 = Double.parseDouble(licznik.replace(",", "."));}
        else{licznik="0";}
        if (mianownik != null && !mianownik.isEmpty()){mianownik1 = Double.parseDouble(mianownik.replace(",", "."));}
        else{mianownik="0";}
        if (licznik1 == 0 || mianownik1 == 0){straty = 0;}
        else{straty = licznik1/mianownik1;} 
        return straty;
    }
    
    
    
    
    
        public static int zwrocId(String licznik){
        int wynik = -1;
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM LICZNIKI WHERE NRLICZNIKA='"+licznik+"'");
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
    
    public boolean czyIstnieje (Licznik licznik){ //jak wlasciwie działa ten select i rs
    Boolean test = false;
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM LICZNIKI WHERE NRLICZNIKAINT='"+this.nrLicznikaInt+"'");
      if (rs.next())
      {test = true;}
         else{test = false;}
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
              if(test){System.out.println("Ppe.czyIstnieje -- juz istnieje");}
              else {System.out.println("Ppe.czyIstnieje -- nie istnieje - ZAPISZ");}                 
              
       return test;
       
     }
    
    public static void zapisz (ArrayList<Licznik> licznik){
        for (Licznik licznik1 : licznik){
        if (!licznik1.czyIstnieje(licznik1)){licznik1.zapisz(licznik1);}

        }
    }
    public void zapisz (Licznik licznik){
        
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
         String sql = "INSERT INTO LICZNIKI (NRLICZNIKA,MNOZNA,STRATY,NRLICZNIKAINT,MNOZNAINT,STRATYINT) " +
                   "VALUES ('"+licznik.nrLicznika+"','"+licznik.mnozna+"','"+licznik.straty+"','"+licznik.nrLicznikaInt+"','"+licznik.mnoznaInt+"','"+licznik.stratyInt+"');"; 
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
    public String toString() {
        return "Licznik{" + "nrLicznikaInt=" + nrLicznikaInt + ", mnoznaInt=" + mnoznaInt + ", stratyInt=" + stratyInt + ", licznikId=" + Id + '}';
    }
    
    
    
    
    
    
}
