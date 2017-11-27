/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.File;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Loader {
    
    public static void loadDataFromFolder(Dystrybutor dystrybutor){

                FolderOdczytowy folderO = new FolderOdczytowy(dystrybutor);
                PlikOdczytowyTau fileTau;
                PlikOdczytowyRwe fileRwe;
            switch (dystrybutor.getSkrot()){
            case "TAU":          
                for(File folderTemp : folderO.doWczytania){  
                fileTau = new PlikOdczytowyTau(folderTemp);
                Ppe.zapisz(fileTau.ppe);
                Licznik.zapisz(fileTau.liczniki);
                Wskazanie.zapisz(fileTau.wskBie,dystrybutor);
                }
                
            case "RWE":          
                for(File folderTemp : folderO.doWczytania){  
                fileRwe = new PlikOdczytowyRwe(folderTemp); 
                Ppe.zapisz(fileRwe.ppeArrayL);
                Licznik.zapisz(fileRwe.licznikiArrayL);
                Wskazanie.zapisz(fileRwe.wskBieArrayL,dystrybutor);
                System.out.println(fileRwe.wskBieArrayL);
                
                
                }
                      }    
    }
    
    
    
    
}
