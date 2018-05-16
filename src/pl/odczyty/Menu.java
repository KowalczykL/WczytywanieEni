/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Menu {
    // start menu
    public void start()
        {
            this.doTheJob((this.selectJob()));
        }
    
 
    public void doTheJob (int[] params){

String res = "";
for(int num: params)
    res += num;
System.out.println("Satrt job with param"+res);
Scanner inVal = new Scanner(System.in);
     switch(res)
        {
         case "00000":
             System.out.println("Program terminated");
             
            break;
          
         //recognize file   
         case "71000":    
            System.out.println("Enter path to file");
            String inputPath = inVal.nextLine();  
            System.out.println(inputPath);
            String[] fileMeta = FileRecognizer.recognizeFile(inputPath);
            System.out.println(fileMeta[0]); 
            System.out.println(fileMeta[1]);            
            break;
            
         case "72000":    
            //System.out.println("1Enter path to directory");   
            String inputDir = inVal.nextLine();
            System.out.println(inputDir); 
            FolderOdczytowy directory = new FolderOdczytowy(inputDir);
            //File[] files = FolderOdczytowy.listuj(inputDir);
               // for(File oneFile: directory.zawFolderu){
              //  FileRecognizer.recognizeFile(oneFile);  
              //  }
            break;            
            
            
            
            
         case "81000":
            System.out.println("Select table");   
            
         
            Scanner table = new Scanner(System.in); 
            String inputTable = table.next();  
            
            DbQuerier dbquerier81 = new DbQuerier();
            dbquerier81.doQuery("SELECT",inputTable);
             
             break;            
            
         case "82000":
             System.out.println("Write whole query");
             Scanner in = new Scanner(System.in);
             String inputQuery = in.nextLine();
             
             DbQuerier dbquerier = new DbQuerier();
             
             System.out.println(inputQuery);
             dbquerier.doQuery(inputQuery);
             break;
             

             
         case "91000":
             System.out.println("Tou choose active test");
             Tester.testuj();
             break;
             
         default:
             System.out.println("Wrong number/not suported yet");
             System.out.println("Select supported code");
             //System.out.println("***");
             //System.out.println("**");
             System.out.println("*");
             //System.out.println();
             System.out.println();
             this.start();
        }
     
     
     
    }
    
    
    
    // listen to number for action to do
    public int waitForNumber(){
        System.out.println("select number and press ENTER");
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println("You select: "+s);
        int output = Integer.parseInt(s);
        return output;

    }
    // print menu, nothing more
  public int[] selectJob(){
      int[] params = new int[5];
      // first level
    System.out.println("Menu");
    System.out.println("**select a number");
    System.out.println("1 - LOAD A FILE");
    System.out.println("2 - SHOW ALL PPE");
    System.out.println("3 - READINGS FOR PPE");
    System.out.println("4 - ");
    System.out.println("7 - RECOGNIZE FILE");
    System.out.println("8 - QUERY TO DB");
    // active test, selected test, all tests
    System.out.println("9 - Tests");
    System.out.println("0 - EXIT");
    System.out.println("");
    
    
    // give mi first number
    params[0] = this.waitForNumber();
    
    switch(params[0]){
        case 0:
            //System.out.println("Program terminated");
        break;
        case 1:
            System.out.println("1");
            break;
        case 7:    
            System.out.println("You select recognization, please select submenu");
            System.out.println("1 - recognize file");
            System.out.println("2 - recognize directory"); 
            params[1] = this.waitForNumber();
            
            break;
        case 8:
            System.out.println("You select queries, please select submenu");
            System.out.println("1 - do SELECT");
            System.out.println("2 - write whole query"); 
            params[1] = this.waitForNumber();
            break;
            
        case 9:
            System.out.println("9");
            System.out.println("You select tests, please select submenu");
            System.out.println("1 - active test");
            System.out.println("2 - selected test");
            System.out.println("3 - all tests");
            params[1] = this.waitForNumber();
            
            switch(params[1]){
                case 1:
                    System.out.println("1");
                break;
                
            }
        break;
    }
    
    
    
    
  return params;  
}  
}
