/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Serializer {  // Serializuj Arraya
    
     public static void Serialize(ZuzycieTau odc){
        File fout = new File("outputObj.CSV");
        try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(fout));){
            oos.writeObject(odc);            
        } catch (IOException ex) {
            Logger.getLogger(Serializer.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public static void Serialize(ArrayList<ZuzycieTau> list){
        File fout = new File("outputObj.CSV");
        try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(fout));){
            oos.writeObject(list);            
        } catch (IOException ex) {
            Logger.getLogger(Serializer.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
