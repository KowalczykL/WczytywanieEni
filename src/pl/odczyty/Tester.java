/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Tester {
    //1 tworz obj na podst skrotu  
    //2 z obiektu dydtrybutor pobiea sciezke do folderu z plikami
    //2,1 listuj pliki z folderu zwróć tablice z zawartością w File[]
    //3 Array z plikami do wczytania po wer w bazie z plikami z File[]
    //X3 a moze obiekt lista plikow z polami FOLE[] - do listowania oraz array z tymi do pobrania
    // moze obj plik odczytowy z tablicą linijek w postaci stringu i tablicą odczytów z tych linijek
    // - arraylisty ze wskazaniami w obj plik odczytowy
    //
    //
    //
    //
     public static void testuj(){  // TEST - test do wykonania
          Tester.T14();
    }
    public static void TX(){
    Dystrybutor dyst = new Dystrybutor("TAU");
    File[] pliki = FolderOdczytowy.listuj(dyst.getFolder());
         for (File pliki1 : pliki) {
             System.out.println("Tester.T8-Lista z for: "+pliki1.toString());
    
    }
    }
    
    public static void T14(){
        Wskazanie wsk = new Wskazanie(297);
        System.out.println(wsk);
         wsk = new Wskazanie(291);
        System.out.println(wsk);
        
        
    }
    
    
    
    public static boolean T13(){ //jak wlasciwie działa ten select i rs
    
        Boolean test = false;
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT * FROM WSKAZANIA WHERE PPE='ENID_4081037150' AND DATA='2017-02-20' AND WARTOSC='4181,808'");
       if (rs.next()){
         test = true;
       }
         else{
           test = false;  
         }
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
       return test;
     }
    
    
    public static void T12(){
     PlikOdczytowyTau plikodc = new PlikOdczytowyTau("TAU/DR/DR_ENID_EUPX_20170328_6.csv");
         
     }
    
    
     public static void T11(){
     FolderOdczytowy lista = new FolderOdczytowy("TAU/DR");
     System.out.println("Tester.T11 - wylistuje zawFolderu");
     for (File pliki1 : lista.zawFolderu) {
      System.out.println( pliki1);  
      
      
         
     }
     
     System.out.println("Tester.T11 - koniec liswowania zawFolderu");
     
     
     
     System.out.println("Tester.T11 - wylistuje doWczytania");
     for (File pliki1 : lista.doWczytania) {
     System.out.println( pliki1);
     PlikOdczytowyTau plik = new PlikOdczytowyTau(pliki1.getPath());
     }
     System.out.println("Tester.T11 - koniec liswowania doWczytania");
         //for (int i = 0,i<)

//for (File pliki1 : lista.getZawFolderu()) {
   //          System.out.println("Tester.T8-Listuje zwrocony objekt zawF: "+pliki1.toString());
    
   // }
         
     }
     
     
     public static void T10(){ //zwracanie dystrybutora z bazy
          Dystrybutor dyst = new Dystrybutor("TAU");
          System.out.println("Tester.T10 - zbudowny obj dyst"+dyst);
      } 
     
     
     
     public static void T9(){ //zapisz licznik
          Licznik licznik = new Licznik("9656852295", 40, 1.05);
         //LicznikDAO licznikdao = new LicznikDAO();
          boolean zapisz;
         //zapisz = licznikdao.zapisz(licznik);
      } 
     
     
     
      public static void T8(){
          File[] pliki = FolderOdczytowy.listuj("TAU/DR");
         for (File pliki1 : pliki) {
             System.out.println("Tester.T8-Lista z for: "+pliki1.toString());
          //ListaPlikow.listuj();
             
         }
      }  
    
    public static void T7(){  // TEST - czy wczytany plik jest w bazie
        //Odczyt odc = new ZuzycieTau("ENI1256", "2017-03-16", "1256985");
        if (SQLiteJDBC.czyWczytanySQ("TAU/DR/DR_ENID_EUPX_20170228_1.csv") == true){
            System.out.println("Plik już wczytany");}
        else {System.out.println("Plik do wczytania");}
            
            
        //SQLiteJDBC.czyWczytanySQ("plik8");
        //SQLiteJDBC.czyWczytanySQ("plik123");
    }
   
     /*public static void T6(){  // TEST - zapisz objekt
        ZuzycieTau odc = new ZuzycieTau("ENI1256", "2017-03-16", "1256985");
        SQLiteJDBC.zapiszOdczyt(odc);
    }
*/
    
    
    public static void T5(){  // TEST - tworz tabele
        SQLiteJDBC.tworzTabele("odczyty","odczyty");
    }
    
     public static void T4(){  // TEST - tworz DB
        SQLiteJDBC.tworzBaze("odczyty");
    }
    
    
    
    
    public static void T3(){  // TEST - de-serializacja  
        ArrayList<ZuzycieTau> lista = (Deserializer.Deserialize("outputObj.CSV")); 
        System.out.println(lista);        
    }
    
    public static void T2(){  // TEST - serializacja
       ArrayList<ZuzycieTau> lista = (ImportPliku.Importuj("plik3.CSV")); 
        Serializer.Serialize(lista);        
    }
    
    /**
     * Test zapisu do pliku
     */    
    public static void T1(){  //  TEST - Zapis do pliku
    {
    //Odczyt odc1 = new ZuzycieTau("1","1","1");
        //System.out.println(odc1);
        ArrayList<ZuzycieTau> lista = (ImportPliku.Importuj("plik3.CSV"));
        ZuzycieTau odc1= lista.get(7);
        System.out.println(lista);
        //ExpToFile.Exportuj(lista);
        ExpToFile.Exportuj(lista.get(3));
        ExpToFile.Exportuj(odc1);
        System.out.println(lista.size());
        for (int i = 0; i < ((lista.size())); i++){
            System.out.println(i+1);
            System.out.println(lista.get(i));
        }
        
        /*File f = new File("plik3.CSV");
    File fout = new File("plikout.CSV");
    

        try (BufferedReader in = new BufferedReader(new FileReader(f));
               FileWriter out = new FileWriter(fout);                
                ){
            fout.createNewFile();
            String line;
            String[] parts;
            int wie = 0;
            while ((line=in.readLine())!=null){
                 wie++;
                 if (wie>7){
                 parts = line.split(";");            
            System.out.print(parts[0]);  
            System.out.print(";"+parts[6]);
            System.out.println(";"+parts[8]);  
              }
            }
        }
        catch (Exception ex) {
            Logger.getLogger(WczytywanieEni.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("pusty wiersz");
        }*/

        
        
        
    }
    
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
}
