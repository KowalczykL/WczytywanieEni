
package pl.odczyty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImportPliku {
    
    //public static boolean czyWczytany (String plik){
        
        
        
      //return false;  
   // }
    
    
    
    
    
    
    
    public static ArrayList<ZuzycieTau> Importuj(String nazwaPliku){
    File f = new File(nazwaPliku);
    ArrayList<ZuzycieTau> odczytyPliku = new ArrayList<ZuzycieTau>();
            try (BufferedReader in = new BufferedReader(new FileReader(f));){
    
            String line;
            String[] parts;
            int wie = 0;
            while ((line=in.readLine())!=null){
                 wie++;
                 if (wie>7){
                 parts = line.split(";");            
            //System.out.print(parts[0]);  
            //System.out.print(";"+parts[6]);
            //System.out.println(";"+parts[8]); 
            ZuzycieTau odc = new ZuzycieTau();//(parts[0],parts[6],parts[8]);
            odczytyPliku.add(odc);
            
                 }
                 }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportPliku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImportPliku.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return odczytyPliku;
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
