/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

/**
 *
 * @author Łukasz Kowalczyk
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class FolderOdczytowy {
File[] zawFolderu;
ArrayList<File> doWczytania;

    @Override
    public String toString() {
        return "ListaPlikow{" + "zawFolderu=" + zawFolderu + ", doWczytania=" + doWczytania + '}';
    }
  
    public FolderOdczytowy(Dystrybutor dystrybutor) {
        this(dystrybutor.getFolder());   
    }
    
    
    public FolderOdczytowy(String folder) {

       //System.out.println("ListaPlików.konst - parametr konstr"+folder);
      String dirPathname = folder;
        File directory = new File(dirPathname);
        if(!directory.isDirectory()){
            //System.out.println(dirPathname + " is not directory");
            } 
        File[] files = directory.listFiles();
        //System.out.println("ListaPlików.konst obj file - "+files.toString());
        this.zawFolderu = files;  
        //System.out.println("ListaPlików.konst - ustawiono pole zawFolderu");
        //System.out.println("ListaPlików.konst - zwraca thisa"+this.zawFolderu);
        for (File pliki1 : this.zawFolderu) {
             //System.out.println("FolderOdc-Listuje zwrocony objekt zawF: "+pliki1.toString());
             boolean test = czyWczytany(pliki1);
             //System.out.println("Test czy wczytany - "+czyWczytany(pliki1));
             
             
    }
        this.doWczytania = new ArrayList();            
             //System.out.println("Folder - tworze pustego array");
             //System.out.println(this.doWczytania);
        
        for (File pliki2 : this.zawFolderu) {
           if(!czyWczytany(pliki2)){
              //System.out.println("if"); 
           this.doWczytania.add(pliki2);
           }else{//System.out.println("else");
           }
           }
        //System.out.println("DO wczyt"+this.doWczytania);
        //for (ArrayList<File> pliki3 : this.zawFolderu) {
             //System.out.println("FolderOdc-Listuje zwrocony objekt zawF: "+pliki1.toString());
            // boolean test = czyWczytany(pliki3);
             //System.out.println("Test czy wczytany - "+czyWczytany(pliki1));
             
             
    //}
        
       System.out.println("Utworzono obiekt FolderOdczytowy - "+folder); 
    }


        
	private static final boolean RECURSIVE = false;
/**zwraca taklice File[] z zawartością folder
     * @param sciezka
     * @return u*/
        
        public static File[] listuj(String sciezka){
            
        String dirPathname = sciezka;
        File directory = new File(dirPathname);
        if(!directory.isDirectory()){
            System.out.println(dirPathname + " is not directory");
            } 
        //drukujZaw(directory);
        File[] files = directory.listFiles();
        System.out.println("ListaPlików.listuj - "+files.toString());
        return files;
        //for (File file : files) {
        //if (!SQLiteJDBC.czyWczytany(file.toString())){
        //System.out.println(file.toString());}
        //else{System.out.println("else");}
//file.getPath();
        }
        public boolean czyWczytany (File plik){
        String sciezka = plik.toString();
        Boolean test = false;
        Connection c = null;
        Statement stmt = null;
              try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:odczyty.db");
         c.setAutoCommit(false);
         //System.out.println("Opened database successfully");
         
         stmt = c.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery("SELECT NAZWA FROM WCZYTANE_PLIKI");
         //System.out.println("Folder.czyW - wynik selecta z bazy: "+rs);
         
         
         //do przebudowy
         while (rs.next()){
         String wyniki = rs.getString("NAZWA");
          //System.out.println("Folder.czyW - wynik 1 linii selecta z bazy"+wyniki);
         //System.out.println( " @#$%^plik"+plik+"- VS -wynik  "+wyniki);
          //System.out.println( " @#$%^plik"+plik+"- VS -wynik  "+wyniki);
          //System.out.println(sciezka.equals(wyniki));
          
          if (sciezka.equals(wyniki)){
          
             test = true;  
             System.out.println("Plik juz wczytany"+plik);
         }
         else{
              //test = false;
         System.out.println("Plik do wczytania"+plik);
         }
         }
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      
       //if(!test){
            //System.out.println("Test: "+test+" ;Plik: "+sciezka+" - do wczytania");
       // }
       // else{System.out.println("Test: "+test+" ;Plik: "+sciezka+" - juz wczytany");}
      //System.out.println("F_odc,czyEczytany: return - "+test);
       return test;
      
      
    }
        
        
        
           
        
        
        
        
        
	public static void listujZaw() throws IOException {

		String dirPathname = "C:\\Users\\Łukasz Kowalczyk\\Desktop\\pliki pomiarowe\\Pliki pom\\lzt\\Odczyty";

		File directory = new File(dirPathname);
		if(!directory.isDirectory()){
			System.out.println(dirPathname + " is not directory");

		}
		printContentOfFilesInDirectory(directory);
	}

	private static void printContentOfFilesInDirectory(File directory) throws IOException {

		File[] files = directory.listFiles();
                //System.out.println(files.get(0x2));

		for (File file : files) {

			if(file.isFile()){

				printFile(file);
System.out.println(file);
			} else if(file.isDirectory() && RECURSIVE){
System.out.println(file);
				printContentOfFilesInDirectory(file);
			}
		}
	}

	private static void printFile(File file) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(file));

		try {
			printReaderContent(reader);
		}finally{
			reader.close();
		}
	}

	private static void printReaderContent(BufferedReader reader) throws IOException {

		String line = null;
		while( (line = reader.readLine()) != null ){
			System.out.println(line);
		}
	}

    public File[] getZawFolderu() {
        return zawFolderu;
    }

    public void setZawFolderu(File[] zawFolderu) {
        this.zawFolderu = zawFolderu;
    }

    public ArrayList<File> getDoWczytania() {
        return doWczytania;
    }

    public void setDoWczytania(ArrayList<File> doWczytania) {
        this.doWczytania = doWczytania;
    }


}
