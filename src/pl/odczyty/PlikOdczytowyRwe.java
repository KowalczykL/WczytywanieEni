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
            //boolean e = false;
            Boolean flaga = false;
            String[] parts;
            String[] pomocniczy = new String[5];
            int wie = 0;
            while ((line=in.readLine())!=null){
                 
                

                
                 
            parts = line.split(";");
            
            for(String out : parts){
                if(!out.isEmpty()){
                  
                    
                 if (out.contains("P+")){
                     flaga = true;
                     wie = 1;
                 }
                    //System.out.println("przod --  "+wie+"  -  "+out+"  -  "+wie);
                
                 
//                 if (out.contains("E")&&wie>13){
//                     e = true;
//                 }
                 
                 
                if (flaga) {
                 //System.out.println(wie+out+wie);
                
                    if  (out.equals("E")||out.equals("ZD"))
                    {
                    wie--;
                    }
                }
                 switch (wie)
                    {
                     case 1:
                   System.out.println(wie+"PPE - <"+out+">");  //.substring(5,38)
                     break;
                     case 12:
                    System.out.println(wie+"DATA - <"+out+">");  
                     break;          
                     case 13:
                    if (!out.equals("E")){System.out.println(wie+"WSKAZANIE - <"+out+">");}  
                     break;                             
                     case 18:
                    System.out.println(wie+"LICZNIK - <"+out+">"); 
                     break;                             
                     case 22:
                    System.out.println(wie+"MNOZNA - <"+out+">");  
                     break;
                    }

                     
                         
                    if (flaga) 
                    {
                    wie++;
                    } 

                    if (wie>24) 
                    {
                    wie = 0;
                    flaga = false;
                    }
                
                }//koniec if empty
           // System.out.print(out);  
           // System.out.println("next"+wie);
            
            } //koniec petli iterujacej po niepustych komórkach    
            }// koniec while
            }//koniec try
            
            
                 
                 
                 
            
    catch (FileNotFoundException ex) {
         Logger.getLogger(PlikOdczytowyRwe.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(PlikOdczytowyRwe.class.getName()).log(Level.SEVERE, null, ex);
     }
 
   }
}
