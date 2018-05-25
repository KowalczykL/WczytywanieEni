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
public class FileRecognizer {

    
    public static  String recognizeFile(String path){
        File file = new File(path);
        String output = FileRecognizer.recognizeFile(file);
        return output;
    }
    
    
    
    
    public static  String recognizeFile(File file){
    //Tauron, Enea, ...
    String operator;
  //DR - meter readings, DP - use per hour
    String sourceType; 
    // File type tags in one String array
    String[] fileTypeTags = new String[2];
        
String fileName = file.getName();
System.out.println(fileName);
    // 1 - Energa DR
    if ((fileName.contains("UDPP_ZEUP_"))||(fileName.contains("UDPM_ZEUP_"))){
        fileTypeTags[0] = "KEE";
        fileTypeTags[1] = "DR";
        }
    // 2 - Energa DP
    else if (fileName.contains("DDG_ZEUP_")){
        fileTypeTags[0] = "KEE";
        fileTypeTags[1] = "DDG"; 
        }
    // 3 - WAT DR
        else if (fileName.contains("UDPZEUP_PGED_")){
        fileTypeTags[0] = "WAT";
        fileTypeTags[1] = "DR";
        }
    // 4 - WAT DP
        else if (fileName.contains("DDGD_ZEUP_")){
        fileTypeTags[0] = "WAT";
        fileTypeTags[1] = "DDG";
        }        
    // 5 - TAU DR
        else if (fileName.contains("DR_")){
        fileTypeTags[0] = "TAU";
        fileTypeTags[1] = "DR";
        }
    // 6 - TAU DP
        else if (fileName.contains("DP_")){
        fileTypeTags[0] = "TAU";
        fileTypeTags[1] = "DDG";
        }         
    // 7 - ENEA DR
        else if (fileName.contains("DO_ENED_ZEUP_")){
        fileTypeTags[0] = "ENEA";
        fileTypeTags[1] = "DR";
        }
    // 8 - ENEA, RWE DP
        else if (fileName.contains("DG_")){
            if(fileName.contains("DG_ENED_ZEUP_"))
                {
                    fileTypeTags[0] = "ENEA"; 
                }
            else if(fileName.contains("DG_WAM_ZEUP_"))
                {
                    fileTypeTags[0] = "RWE"; 
                }
        
        fileTypeTags[1] = "DDG"; 
        }        
    // 9 - LZM DR
        else if (fileName.contains("Stany")){
        fileTypeTags[0] = "LZM";
        fileTypeTags[1] = "DR";
        }                
    // 10 - LZM DP
        else if (fileName.contains("PLLZED")){
        fileTypeTags[0] = "LZM";
        fileTypeTags[1] = "DDG";
        }                 
    // 11 - LZT DR
        else if (fileName.contains("_Pomiary_")){
        fileTypeTags[0] = "LZT";
        fileTypeTags[1] = "DR";
        }        
    else
        {
        fileTypeTags[0] = "Something went wrong";
        fileTypeTags[1] = "I dont know him";            
            
        }
    
    
    
     return fileTypeTags[0]+fileTypeTags[1];       
}
    
    

}
