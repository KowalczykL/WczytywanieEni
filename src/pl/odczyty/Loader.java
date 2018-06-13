/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import measurement.dao.DdgDayDao;
import utilities.DateUtil;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Loader {

    public void loadFile(File file) {
        String metaData = FileRecognizer.recognizeFile(file);
        DdgDayDao ddgDayDao = new DdgDayDao();
        PobDay pobDay;
        String line;
        String[] parts;
        int currentLine = 0;
        String[] subParts;
        switch (metaData) {
            /*    case "RWEDDG":
                System.out.println("WATDDG to save");
                DdgDay ddgDayRwe = new DdgDay();
                ddgDayRwe.setOsd("RWE");
                //ddgDayRwe.setFileName(file.getName());

                try (BufferedReader in = new BufferedReader(new FileReader(file));) {
                    while ((line = in.readLine()) != null) {
                        currentLine++;
                        if (currentLine == 0) {
                            parts = line.split(";");
                            ddgDayRwe.setFileName(parts[0]);
                        }
                        
                        if (currentLine == 6) {
                            parts = line.split(";");
                            ddgDayRwe.setDataS(parts[1]);

                        }
                        if (currentLine == 7) {
                            parts = line.split(";");
                            ddgDayRwe.setVersion(Integer.parseInt(parts[1]));
                        }
                        /*     if (currentLine == 0) {
                            parts = line.split(";");
                            // System.out.println(parts[3]);
                            subParts = parts[3].split("/");
                            //System.out.println(subParts[3]);
                            ddgDay.setVersion(Integer.parseInt(subParts[3]));
                        }*/

 /*  if (currentLine > 8) {
                            parts = line.split(";");
                            if (parts[5].isEmpty()) {
                                parts[5] = "0";
                            }
                            if (parts[6].isEmpty()) {
                                parts[6] = "3";
                            }
                            ddgDay.setPpe(parts[0]);
                            ddgDay.setDataS(parts[2]);
                            ddgDay.setHour1val(Double.parseDouble(parts[3].replace(',', '.')));
                            ddgDay.setHour1Status(Integer.parseInt(parts[4]));
                            ddgDay.setHour2val(Double.parseDouble(parts[5].replace(',', '.')));
                            ddgDay.setHour2Status(Integer.parseInt(parts[6]));
                            ddgDay.setHour3val(Double.parseDouble(parts[7].replace(',', '.')));
                            ddgDay.setHour3Status(Integer.parseInt(parts[8]));
                            ddgDay.setHour4val(Double.parseDouble(parts[9].replace(',', '.')));
                            ddgDay.setHour4Status(Integer.parseInt(parts[10]));
                            ddgDay.setHour5val(Double.parseDouble(parts[11].replace(',', '.')));
                            ddgDay.setHour5Status(Integer.parseInt(parts[12]));
                            ddgDay.setHour6val(Double.parseDouble(parts[13].replace(',', '.')));
                            ddgDay.setHour6Status(Integer.parseInt(parts[14]));
                            ddgDay.setHour7val(Double.parseDouble(parts[15].replace(',', '.')));
                            ddgDay.setHour7Status(Integer.parseInt(parts[16]));
                            ddgDay.setHour8val(Double.parseDouble(parts[17].replace(',', '.')));
                            ddgDay.setHour8Status(Integer.parseInt(parts[18]));
                            ddgDay.setHour9val(Double.parseDouble(parts[19].replace(',', '.')));
                            ddgDay.setHour9Status(Integer.parseInt(parts[20]));
                            ddgDay.setHour10val(Double.parseDouble(parts[21].replace(',', '.')));
                            ddgDay.setHour11Status(Integer.parseInt(parts[22]));
                            ddgDay.setHour12val(Double.parseDouble(parts[23].replace(',', '.')));
                            ddgDay.setHour12Status(Integer.parseInt(parts[24]));
                            ddgDay.setHour13val(Double.parseDouble(parts[25].replace(',', '.')));
                            ddgDay.setHour13Status(Integer.parseInt(parts[26]));
                            ddgDay.setHour14val(Double.parseDouble(parts[27].replace(',', '.')));
                            ddgDay.setHour14Status(Integer.parseInt(parts[28]));
                            ddgDay.setHour15val(Double.parseDouble(parts[29].replace(',', '.')));
                            ddgDay.setHour15Status(Integer.parseInt(parts[30]));
                            ddgDay.setHour16val(Double.parseDouble(parts[31].replace(',', '.')));
                            ddgDay.setHour16Status(Integer.parseInt(parts[32]));
                            ddgDay.setHour17val(Double.parseDouble(parts[33].replace(',', '.')));
                            ddgDay.setHour17Status(Integer.parseInt(parts[34]));
                            ddgDay.setHour18val(Double.parseDouble(parts[35].replace(',', '.')));
                            ddgDay.setHour18Status(Integer.parseInt(parts[36]));
                            ddgDay.setHour19val(Double.parseDouble(parts[37].replace(',', '.')));
                            ddgDay.setHour19Status(Integer.parseInt(parts[38]));
                            ddgDay.setHour20val(Double.parseDouble(parts[39].replace(',', '.')));
                            ddgDay.setHour20Status(Integer.parseInt(parts[40]));
                            ddgDay.setHour21val(Double.parseDouble(parts[41].replace(',', '.')));
                            ddgDay.setHour21Status(Integer.parseInt(parts[42]));
                            ddgDay.setHour22val(Double.parseDouble(parts[43].replace(',', '.')));
                            ddgDay.setHour22Status(Integer.parseInt(parts[44]));
                            ddgDay.setHour23val(Double.parseDouble(parts[45].replace(',', '.')));
                            ddgDay.setHour23Status(Integer.parseInt(parts[46]));
                            ddgDay.setHour24val(Double.parseDouble(parts[47].replace(',', '.')));
                            ddgDay.setHour24Status(Integer.parseInt(parts[48]));
                            ddgDay.setHour2Aval(Double.parseDouble(parts[49].replace(',', '.')));
                            ddgDay.setHour2AStatus(Integer.parseInt(parts[50]));

                            // ddgDay.toString();
                            System.out.println(ddgDay.toString());
                            // System.out.print(";" + parts[6]);
                            //System.out.println(";" + parts[8]);

                            ddgDayDao.saveIfNew(ddgDay);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ImportPliku.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ImportPliku.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;*/
            // changed current line - to repain
            case "WATDDG":
                System.out.println("WATDDG to save");
                DdgDay ddgDay = new DdgDay();
                ddgDay.setOsd("WAT");
                ddgDay.setFileName(file.getName());

                System.out.println(file.exists());
                try (BufferedReader in = new BufferedReader(new FileReader(file));) {
                    while ((line = in.readLine()) != null) {
                        currentLine++;
                        if (currentLine == 0) {
                            parts = line.split(";");
                            // System.out.println(parts[3]);
                            subParts = parts[3].split("/");
                            //System.out.println(subParts[3]);
                            ddgDay.setVersion(Integer.parseInt(subParts[3]));
                        }

                        if (currentLine > 3) {
                            parts = line.split(";");
                            if (parts[5].isEmpty()) {
                                parts[5] = "0";
                            }
                            if (parts[6].isEmpty()) {
                                parts[6] = "3";
                            }
                            ddgDay.setPpe(parts[0]);
                            ddgDay.setDataS(parts[2]);
                            ddgDay.setHour1val(Double.parseDouble(parts[3].replace(',', '.')));
                            ddgDay.setHour1Status(Integer.parseInt(parts[4]));
                            ddgDay.setHour2val(Double.parseDouble(parts[5].replace(',', '.')));
                            ddgDay.setHour2Status(Integer.parseInt(parts[6]));
                            ddgDay.setHour3val(Double.parseDouble(parts[7].replace(',', '.')));
                            ddgDay.setHour3Status(Integer.parseInt(parts[8]));
                            ddgDay.setHour4val(Double.parseDouble(parts[9].replace(',', '.')));
                            ddgDay.setHour4Status(Integer.parseInt(parts[10]));
                            ddgDay.setHour5val(Double.parseDouble(parts[11].replace(',', '.')));
                            ddgDay.setHour5Status(Integer.parseInt(parts[12]));
                            ddgDay.setHour6val(Double.parseDouble(parts[13].replace(',', '.')));
                            ddgDay.setHour6Status(Integer.parseInt(parts[14]));
                            ddgDay.setHour7val(Double.parseDouble(parts[15].replace(',', '.')));
                            ddgDay.setHour7Status(Integer.parseInt(parts[16]));
                            ddgDay.setHour8val(Double.parseDouble(parts[17].replace(',', '.')));
                            ddgDay.setHour8Status(Integer.parseInt(parts[18]));
                            ddgDay.setHour9val(Double.parseDouble(parts[19].replace(',', '.')));
                            ddgDay.setHour9Status(Integer.parseInt(parts[20]));
                            ddgDay.setHour10val(Double.parseDouble(parts[21].replace(',', '.')));
                            ddgDay.setHour10Status(Integer.parseInt(parts[22]));
                            ddgDay.setHour11val(Double.parseDouble(parts[23].replace(',', '.')));
                            ddgDay.setHour11Status(Integer.parseInt(parts[24]));
                            ddgDay.setHour12val(Double.parseDouble(parts[25].replace(',', '.')));
                            ddgDay.setHour12Status(Integer.parseInt(parts[26]));
                            ddgDay.setHour13val(Double.parseDouble(parts[27].replace(',', '.')));
                            ddgDay.setHour13Status(Integer.parseInt(parts[28]));
                            ddgDay.setHour14val(Double.parseDouble(parts[29].replace(',', '.')));
                            ddgDay.setHour14Status(Integer.parseInt(parts[30]));
                            ddgDay.setHour15val(Double.parseDouble(parts[31].replace(',', '.')));
                            ddgDay.setHour15Status(Integer.parseInt(parts[32]));
                            ddgDay.setHour16val(Double.parseDouble(parts[33].replace(',', '.')));
                            ddgDay.setHour16Status(Integer.parseInt(parts[34]));
                            ddgDay.setHour17val(Double.parseDouble(parts[35].replace(',', '.')));
                            ddgDay.setHour17Status(Integer.parseInt(parts[36]));
                            ddgDay.setHour18val(Double.parseDouble(parts[37].replace(',', '.')));
                            ddgDay.setHour18Status(Integer.parseInt(parts[38]));
                            ddgDay.setHour19val(Double.parseDouble(parts[39].replace(',', '.')));
                            ddgDay.setHour19Status(Integer.parseInt(parts[40]));
                            ddgDay.setHour20val(Double.parseDouble(parts[41].replace(',', '.')));
                            ddgDay.setHour20Status(Integer.parseInt(parts[42]));
                            ddgDay.setHour21val(Double.parseDouble(parts[43].replace(',', '.')));
                            ddgDay.setHour21Status(Integer.parseInt(parts[44]));
                            ddgDay.setHour22val(Double.parseDouble(parts[45].replace(',', '.')));
                            ddgDay.setHour22Status(Integer.parseInt(parts[46]));
                            ddgDay.setHour23val(Double.parseDouble(parts[47].replace(',', '.')));
                            ddgDay.setHour23Status(Integer.parseInt(parts[48]));
                            ddgDay.setHour24val(Double.parseDouble(parts[49].replace(',', '.')));
                            ddgDay.setHour24Status(Integer.parseInt(parts[50]));

                            if (ddgDay.getDataS() == "26.03.17") {
                                ddgDay.setHour24val(Double.parseDouble(parts[50].replace(',', '.')));
                                ddgDay.setHour24Status(Integer.parseInt(parts[51]));
                            }

                            // ddgDay.toString();
                            System.out.println(ddgDay.toString());
                            // System.out.print(";" + parts[6]);
                            //System.out.println(";" + parts[8]);

                            ddgDayDao.saveIfNew(ddgDay);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ImportPliku.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ImportPliku.class.getName()).log(Level.SEVERE, null, ex);
                }

                /*
                {
    File f = new File(nazwaPliku);
    ArrayList<ZuzycieTau> odczytyPliku = new ArrayList<ZuzycieTau>();
            try (BufferedReader in = new BufferedReader(new FileReader(f));)
                {
    
            String line;
            String[] parts;
            int wie = 0;
            while ((line=in.readLine())!=null){
                 wie++;
                 if (wie>7){
                 parts = line.split(";");            
            //System.out.print(parts[0]);  
            //System.out.print(";"+parts[6]);
            //System.out.println(";"+parts[8]); 
            ZuzycieTau odc = new ZuzycieTau();//(parts[0],parts[6],parts[8]);
            odczytyPliku.add(odc);
            
                 }
                 }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportPliku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImportPliku.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return odczytyPliku;
}
                
                 */
                break;

            //recognize file  
            // !!! IN PROGRESS !!!
            case "RWEPOB":
                this.loadRwePob(file);
                break;

            default:
                System.out.print("not suported yet");
                break;
        }

    }

    /*public static void loadDataFromFolder(Dystrybutor dystrybutor){

                Directory folderO = new Directory(dystrybutor);
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
    }*/
    public void loadRwePob(File file) {
        System.out.println("RWEPOB to save");
        int currentLine = 0;
        String line;
        PobDay pobDay = new PobDay();
        pobDay.setOsd("RWE");
        pobDay.setFileName(file.getName());
        String[] subString;

        try (BufferedReader in = new BufferedReader(new FileReader(file));) {
            while ((line = in.readLine()) != null) {

                if (currentLine == 4) {
                    pobDay.setDateL(DateUtil.ConvertStringDateToMillis(line));
                }
                if (currentLine == 5) {
                    pobDay.setNubberOfHours(Integer.parseInt(line));
                    //System.out.println("nr ofhr   "+pobDay.getNubberOfHours());
                    //int[] ststuses = new int[pobDay.getNubberOfHours()];
                    pobDay.setStatusesAI(new int[pobDay.getNubberOfHours()]);

                    pobDay.setValuesAD(new double[pobDay.getNubberOfHours()]);
                }

                if (currentLine > 5 && currentLine < (pobDay.getNubberOfHours() + 6)) {
                    subString = line.split(",");
                    pobDay.setValuesAD(currentLine - 6, Double.parseDouble(subString[0]));
                    //pobDay.setValuesAD(currentLine - 6, currentLine);
                    //System.out.println(currentLine+"string"+Double.parseDouble(subString[0]));
                    //System.out.println(subString.toString());
                    int status = 9;
                    if (subString[1].equals("*")) {
                        status = 3;
                    }
                    if (subString[1].equals("+")) {
                        status = 0;
                    }

                    pobDay.setStatusesAI(currentLine - 6, status);
                }

                //System.out.println(pobDay);
                currentLine++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(pobDay);
    }

}
