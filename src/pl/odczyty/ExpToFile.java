/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class ExpToFile {
    
    
    public static void Exportuj(ArrayList<Odczyt> list){
        File fout = new File("output2.CSV");
        FileWriter out = null;
        try {
            out = new FileWriter(fout);
            fout.createNewFile();
            //out.write(list.toString());
            for (int i = 0; i < ((list.size())); i++){
            //out.write(i+1);
            out.write(list.get(i).toString()+"\n");
        }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        finally{
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ExpToFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
    
}
