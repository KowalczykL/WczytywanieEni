/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Deserializer {
    
    public static ArrayList<ZuzycieTau> Deserialize(String nazwaPliku){
        File fin = new File(nazwaPliku);
        ArrayList<ZuzycieTau> odczytySer = new ArrayList<ZuzycieTau>();
        try (ObjectInputStream ois = new ObjectInputStream (new FileInputStream(fin));){
            odczytySer = (ArrayList<ZuzycieTau>) ois.readObject();            
        } catch (IOException ex) {
            Logger.getLogger(Serializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Deserializer.class.getName()).log(Level.SEVERE, null, ex);
        }
         return odczytySer;     
    }
    
      
}
