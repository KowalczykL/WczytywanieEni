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
    
 //ArrayList<String> linijki;
// ArrayList<ZuzycieTau> objZuz;
// ArrayList<Wskazanie> wskPop;  
 ArrayList<Wskazanie> wskBieArrayL; 
 ArrayList<Licznik> licznikiArrayL;
 ArrayList<Ppe> ppeArrayL;

     String ppeS;
     String taryfaS;
     String dystrybutorS = "RWE";
     int metSzaInt = 1; 
     String licznikS;
     String dataS;
     String wskazanieS;
     String rodzajS = "PLIK";
     String zrodloS;
     String strefaS = "1";
     String mnoznaS;
     String stratyS = "0";
             
  public PlikOdczytowyRwe(File inputFilePath) {
      this(inputFilePath.getPath());
  }
     
     
   public PlikOdczytowyRwe(String sciezka) {
     //this.linijki = new ArrayList<String>();
//     this.objZuz = new ArrayList<ZuzycieTau>();
//     this.wskPop = new ArrayList<Wskazanie>();
     this.wskBieArrayL = new ArrayList<Wskazanie>();
     this.licznikiArrayL = new ArrayList<Licznik>();
     this.ppeArrayL = new ArrayList<Ppe>();

   
   File f = new File(sciezka);
   zrodloS = sciezka;  
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
                         ppeS = out.substring(5,38);
                         taryfaS = out.substring(0,3);
                   System.out.println(wie+"PPE - <"+ppeS+">");  //.substring(5,38)
                   System.out.println(wie+"PPE - <"+taryfaS+">");  
                   break;
                     case 12:
                         dataS = out.substring(0, 10);
                    System.out.println(wie+"DATA - <"+dataS+">");  
                     break;          
                     case 13:
                    if (!out.equals("E")){
                        wskazanieS = out;
                        System.out.println(wie+"WSKAZANIE - <"+wskazanieS+">");
                    }  
                     break;                             
                     case 18:
                         licznikS = out;
                    System.out.println(wie+"LICZNIK - <"+licznikS+">"); 
                     break;                             
                     case 22:
                         mnoznaS = out;
                    System.out.println(wie+"MNOZNA - <"+mnoznaS+">");  
                     break;
                    }

                     
                         
                    if (flaga) 
                    {
                    wie++;
                    } 

                    if (wie>24) 
                    {
                    Ppe ppeO = new Ppe(ppeS,taryfaS,dystrybutorS);
                    this.ppeArrayL.add(ppeO);
                    Licznik licznikO = new Licznik(licznikS, mnoznaS, stratyS);
                    this.licznikiArrayL.add(licznikO);
                    Wskazanie wskO = new Wskazanie(ppeS, licznikS, strefaS, dataS, wskazanieS, rodzajS, zrodloS);
                    this.wskBieArrayL.add(wskO);
                    wie = 0;
                    flaga = false;
                    }
                
                }//koniec if empty
           // System.out.print(out);  
           // System.out.println("next"+wie);
            
            } //koniec petli iterujacej po niepustych komórkach    
            }// koniec while
            }//koniec try//koniec try//koniec try//koniec try
            
            
                 
                 
                 
            
    catch (FileNotFoundException ex) {
         Logger.getLogger(PlikOdczytowyRwe.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(PlikOdczytowyRwe.class.getName()).log(Level.SEVERE, null, ex);
     }
 
   }
}
