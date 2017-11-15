/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
/**
 *
 * @author Łukasz Kowalczyk
 */
public class Converter {
    
    public static void convert (Dystrybutor dystrybutor){
             System.out.println("Start");
        String folderOut = dystrybutor.getFolder();
        String format = "yyyyMMdd-HHmm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        File folderIn = new File(dystrybutor.getFxls());
        File plikout;
        String dataS;
        LocalDateTime data;// = LocalDateTime.now();
     //System.out.print(data);
        
        File[] plikiIn = folderIn.listFiles();
           for (File plik : plikiIn) {
               System.out.println(plik);
               
               data = LocalDateTime.now();
               dataS = data.format(formatter);;
               plikout = new File(folderOut+"/"+dystrybutor.getSkrot()+"-"+dataS+".csv");
               
           Converter.xlstoCsv(plik, plikout);
           }
        
        
    }
    
    
    
    
    
    public static void xlstoCsv(File inputFile, File outputFile){

        StringBuffer data = new StringBuffer();
        
                try 
        {
        FileOutputStream fos = new FileOutputStream(outputFile);

        // Get the workbook object for XLS file
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(inputFile));
        // Get first sheet from the workbook
        HSSFSheet sheet = workbook.getSheetAt(0);
        Cell cell;
        Row row;

        // Iterate through each rows from first sheet
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) 
        {
                row = rowIterator.next();
                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) 
                {
                        cell = cellIterator.next();
                        
                        switch (cell.getCellTypeEnum()) 
                        {
                        case BOOLEAN:
                                data.append(cell.getBooleanCellValue()).append(";");
                                break;
                                
                        case NUMERIC:
                                data.append(cell.getNumericCellValue() + ";");
                                break;
                                
                        case STRING:
                                data.append(cell.getStringCellValue() + ";");
                                break;

                        case BLANK:
                                data.append("" + ";");
                                break;
                        
                        default:
                                data.append(cell + ";");
                        }
                        
                        
                }
                data.append("\r\n"); 
        }

        fos.write(data.toString().getBytes());
        fos.close();
        }
        catch (FileNotFoundException e) 
        {
                e.printStackTrace();
        }
        catch (IOException e) 
        {
                e.printStackTrace();
        }
    }
    
}
