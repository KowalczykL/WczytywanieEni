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

public class ListaPlikow {


	private static final boolean RECURSIVE = false;

        public static void listuj(){
            
        String dirPathname = "DR";
        File directory = new File(dirPathname);
        if(!directory.isDirectory()){
            System.out.println(dirPathname + " is not directory");
            } 
        //drukujZaw(directory);
        File[] files = directory.listFiles();
        for (File file : files) {
        System.out.println(file);
        SQLiteJDBC.czyWczytany(file.toString());
        
//file.getPath();
        }
        
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


}
