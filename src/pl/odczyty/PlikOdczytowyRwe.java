/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javassist.compiler.TokenId.BREAK;

/**
 *
 * @author puszatek
 */
public class PlikOdczytowyRwe {
    
 ArrayList<String> linijki;
// ArrayList<ZuzycieTau> objZuz;
// ArrayList<Wskazanie> wskPop;  
 ArrayList<Wskazanie> wskBie; 
 ArrayList<Licznik> liczniki;
 ArrayList<Ppe> ppe;
    
   public PlikOdczytowyRwe(String sciezka) {
     this.linijki = new ArrayList<String>();
//     this.objZuz = new ArrayList<ZuzycieTau>();
//     this.wskPop = new ArrayList<Wskazanie>();
     this.wskBie = new ArrayList<Wskazanie>();
     this.liczniki = new ArrayList<Licznik>();
     this.ppe = new ArrayList<Ppe>();
   
   File f = new File(sciezka);
     
   try (BufferedReader in = new BufferedReader(new FileReader(f));){
    
            String line;
            Boolean flaga = false;
            String[] parts;
            String[] pomocniczy = new String[5];
            int wie = 0;
            while ((line=in.readLine())!=null){
                
                
                
                
                
                if (wie>30) {wie = 0;
                flaga = false;
                }
                
                 
            parts = line.split(";");
            
            for(String out : parts){
                if(!out.isEmpty()){
                 if (flaga) {wie++;}     
                    
                 if (out.contains("P+")){
                     flaga = true;
                     wie = 1;
                 }
                 switch (wie){
                     case 1:
                   System.out.println("PPE - <"+out.substring(5,38)+">");  
                     break;
                     case 12:
                    System.out.println("DATA - <"+out+">");  
                     break;          
                     case 13:
                    System.out.println("WSKAZANIE - <"+out+">");  
                     break;                             
                     case 18:
                    System.out.println("LICZNIK - <"+out+">");  
                     break;                             
                     case 22:
                    System.out.println("MNOZNA - <"+out+">");  
                     break;
                    // case 12:
                    //System.out.println(" - "+out);  
                    // break;
                 }
                         
                         
                 
           // System.out.print(out);  
            //System.out.println("next"+wie);
            
            }     
            }
            
            
            
                 
                 
                 
            }
   } catch (FileNotFoundException ex) {
         Logger.getLogger(PlikOdczytowyRwe.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(PlikOdczytowyRwe.class.getName()).log(Level.SEVERE, null, ex);
     }
 
   }
}
