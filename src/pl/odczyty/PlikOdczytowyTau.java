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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author puszatek
 */
public class PlikOdczytowyTau {
 ArrayList<String> linijki;
 ArrayList<ZuzycieTau> objZuz;
 ArrayList<Wskazanie> wskPop;  
 ArrayList<Wskazanie> wskBie; 
 ArrayList<Licznik> liczniki;
 ArrayList<Ppe> ppe;

    
 public PlikOdczytowyTau(String sciezka) {
     this.linijki = new ArrayList<String>();
     this.objZuz = new ArrayList<ZuzycieTau>();
     this.wskPop = new ArrayList<Wskazanie>();
     this.wskBie = new ArrayList<Wskazanie>();
     this.liczniki = new ArrayList<Licznik>();
     this.ppe = new ArrayList<Ppe>();
     

     
    File f = new File(sciezka);
    //ArrayList<ZuzycieTau> odczytyPliku = new ArrayList<ZuzycieTau>();
            try (BufferedReader in = new BufferedReader(new FileReader(f));){
    
            String line;
            String[] parts;
            int wie = 0;
            while ((line=in.readLine())!=null){
                 wie++;
                 
                 if (wie>7){
                 //System.out.println("Plikodc - to jest linijka : "+line);
                this.linijki.add(line);
                     
                     
                 parts = line.split(";");
                 
                 //System.out.println("Plikodc - to jest Array : "+Arrays.toString(parts));
                 
                 ZuzycieTau zuztau = new ZuzycieTau(line);
                 //System.out.println(zuztau);
                 this.objZuz.add(zuztau);
                 
                 Wskazanie wskpop = new Wskazanie(parts[0],parts[1],parts[4],parts[5],parts[7],"PLIK",sciezka);
                 this.wskPop.add(wskpop);
                 //System.out.println("PlikodcOOOOO");
                 
                 Wskazanie wskbie = new Wskazanie(parts[0],parts[1],parts[4],parts[6],parts[8],"PLIK",sciezka);
                 //if(!wskbie.czyIstnieje(wskbie))
                 //{wskbie.zapisz(wskbie);}
                 this.wskBie.add(wskbie);
                 //System.out.println("test liczenia strat"+Double.toString(Licznik.liczStraty(zuztau)));
                 Licznik licznik = new Licznik(parts[1], parts[11], Double.toString(Licznik.liczStraty(zuztau))  );
                 this.liczniki.add(licznik);
                // 
                 Ppe ppe = new Ppe(parts[0], parts[3],"TAU");
                 this.ppe.add(ppe);
                 
                 //Ppe ppe = new Ppe();
                 
                //System.out.println(objZuz);
                 //this.linijki.add(Arrays.toString(parts));
            //System.out.print(parts[0]);  
            //System.out.print(";"+parts[6]);
            //System.out.println(";"+parts[8]); 
            //ZuzycieTau odc = new ZuzycieTau();//(parts[0],parts[6],parts[8]);
            //odczytyPliku.add(odc);
            
            
            
            
                 }
                 }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportPliku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImportPliku.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            //return odczytyPliku;

    //System.out.println("całosc tablicy obj linijki"+this.linijki);
    //for (String linijka1 : this.linijki){
      // System.out.println("Wylistowany obj linijki*****"+linijka1);
    //}
    
   //System.out.println("całosc tablicy obj ze zuzyciami"+this.objZuz);
   //for (ZuzycieTau linijka1 : this.objZuz){
    //   System.out.println("Wylistowany obj linijki*****"+linijka1);
    //}
    
    //System.out.println("całosc tablicy wskPop"+this.wskPop);
    //for (Wskazanie wsk1 : this.wskPop){
    //   System.out.println("Wylistowany obj linijki*****"+wsk1);
       //wsk1.zapisz(wsk1);
   // }
    
    // System.out.println("całosc tablicy wskBie"+this.wskBie);
    //for (Wskazanie wsk2 : this.wskBie){
       //System.out.println("Wylistowany obj linijki wsk Bie: "+wsk2);
       //wsk2.zapisz(wsk2);
      // System.out.println("test czy istnieje:  "+wsk2.czyIstnieje(wsk2));
       
    //}
    System.out.println("Utworzono PlikOdczytowy - "+sciezka);
}
 
}
