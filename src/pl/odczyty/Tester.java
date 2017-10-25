/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.util.ArrayList;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Tester {
    
    public static void T3(){  // TEST - de-serializacja  
        ArrayList<Odczyt> lista = (Deserializer.Deserialize("outputObj.CSV")); 
        System.out.println(lista);        
    }
    
    public static void T2(){  // TEST - serializacja
       ArrayList<Odczyt> lista = (ImportZPliku.Importuj("plik3.CSV")); 
        Serializer.Serialize(lista);        
    }
    
    /**
     * Test zapisu do pliku
     */    
    public static void T1(){  //  TEST - Zapis do pliku
    {
    //Odczyt odc1 = new Odczyt("1","1","1");
        //System.out.println(odc1);
        ArrayList<Odczyt> lista = (ImportZPliku.Importuj("plik3.CSV"));
        Odczyt odc1= lista.get(7);
        System.out.println(lista);
        //ExpToFile.Exportuj(lista);
        ExpToFile.Exportuj(lista.get(3));
        ExpToFile.Exportuj(odc1);
        System.out.println(lista.size());
        for (int i = 0; i < ((lista.size())); i++){
            System.out.println(i+1);
            System.out.println(lista.get(i));
        }
        
        /*File f = new File("plik3.CSV");
    File fout = new File("plikout.CSV");
    

        try (BufferedReader in = new BufferedReader(new FileReader(f));
               FileWriter out = new FileWriter(fout);                
                ){
            fout.createNewFile();
            String line;
            String[] parts;
            int wie = 0;
            while ((line=in.readLine())!=null){
                 wie++;
                 if (wie>7){
                 parts = line.split(";");            
            System.out.print(parts[0]);  
            System.out.print(";"+parts[6]);
            System.out.println(";"+parts[8]);  
              }
            }
        }
        catch (Exception ex) {
            Logger.getLogger(WczytywanieEni.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("pusty wiersz");
        }*/

        
        
        
    }
    
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
}
