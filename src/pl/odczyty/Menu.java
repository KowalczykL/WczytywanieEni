/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.io.File;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Scanner;
import measurement.dao.DbGate;
import utilities.DateUtil;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class Menu {

    // start menu
    public void start() {
        this.doTheJob((this.selectJob()));
    }

    public void doTheJob(String param) {

        System.out.println("Satrt job with param" + param);
        Scanner inVal = new Scanner(System.in);
        File[] fileAr;
        File file;
        Loader loader = new Loader();
        DbQuerier dbQuerier1 = new DbQuerier();
        switch (param) {
            case "000":
                System.out.println("Program terminated");

                break;
            case "100":
                System.out.println("Load a file");
                file = new File("DDGD_ZEUP_PGED_P_1761_20170303.csv");
                System.out.print(file.getName());

                loader.loadFile(file);
                break;
            //recognize file 

            case "111":
                System.out.println("Load a file");
                file = new File("rwe_wam_se-zeup_pob-wsor_cp_20180602.dat");
                System.out.print(file.getName());

                loader.loadFile(file);
                break;

            case "400":
                fileAr = Directory.listFiles("INPUT");
                System.out.print(fileAr[1].toString());
                break;
            case "410":
                fileAr = Directory.listFiles("DDG");
                for (File oneFile : fileAr) {
                    System.out.println(oneFile.getPath());

                }

                break;

            case "500":
                fileAr = Directory.listFiles("INPUT");

                for (File oneFile : fileAr) {
                    loader.loadFile(oneFile);

                }
                break;
            case "510":
                fileAr = Directory.listFiles("DDG");
                for (File oneFile : fileAr) {
                    loader.loadFile(oneFile);

                }
                break;

            case "710":
                System.out.println("Enter path to file");
                String inputPath = inVal.nextLine();
                System.out.println(inputPath);
                String fileMeta = FileRecognizer.recognizeFile(inputPath);
                System.out.println(fileMeta);
                System.out.println(fileMeta);
                break;

            case "720":
                //System.out.println("1Enter path to directory");   
                String inputDir = inVal.nextLine();
                System.out.println(inputDir);
                //    Directory directory = new Directory(inputDir);
                //File[] files = Directory.listFiles(inputDir);
                // for(File oneFile: directory.zawFolderu){
                //  FileRecognizer.recognizeFile(oneFile);  
                //  }
                break;

            case "810":
                System.out.println("Select table");

                Scanner table = new Scanner(System.in);
                String inputTable = table.next();

                DbQuerier dbquerier81 = new DbQuerier();
                dbquerier81.doQuery("SELECT", inputTable);

                break;

            case "820":
                System.out.println("Write whole query");
                Scanner in = new Scanner(System.in);
                String inputQuery = in.nextLine();

                DbQuerier dbquerier = new DbQuerier();

                System.out.println(inputQuery);
                dbquerier.doQuery(inputQuery);
                break;

            case "910":
                System.out.println("Tou choose active test");
                Tester.testuj();
                break;

            case "921":
                System.out.println("You choose date reco test");
                DateUtil dateUtil = new DateUtil();
                String format = dateUtil.recognizeFormat("2017-10-31");
                System.out.println(format);
                break;

            case "922":
                System.out.println("You choose date to millis and back test");
                long millis = DateUtil.ConvertStringDateToMillis("1980-10-15");
                System.out.println(millis);
                System.out.println(DateUtil.MillisToTauStringDate(millis));
                break;

            case "923":
                System.out.println("You choose millis to date test");
                long millisDate = 1543705200000L;
                System.out.println(DateUtil.MillisToTauStringDate(1543705200000L));
                break;

            case "924":
                System.out.println("You choose full date test ");
                String dataS = "13.05.1999";
                long dataL = DateUtil.ConvertStringDateToMillis(dataS);
                System.out.println("in millis " + dataL);
                String dataTau = DateUtil.MillisToTauStringDate(dataL);
                System.out.println("bact to date - in tau format " + dataTau);
                break;
            case "940":
                System.out.println("You choose hibernate tests");
                //DbSaver.saveToDb();
                break;

            case "950":
                System.out.println("You choose T24 - zapis ddgday");
                Tester.T24();
                break;

            case "961":
                PobDay pobDay = TestObjectsFactory.returnPobDay();
                DbGate dbGate = new DbGate();
                System.out.println(pobDay.toString());
                System.out.println(pobDay.returnSavingQuery());
                dbGate.saveAnywayByObjectQuery(pobDay.returnSavingQuery());
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
    public String waitForNumber() {
        System.out.println("select number and press ENTER");
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println("You select: " + s);

        return s;

    }

    // print menu, nothing more
    public String selectJob() {
        String param;
        // first level
        System.out.println("Menu");
        System.out.println("**select a numberin NNN format");
        System.out.println("100 - LOAD A FILE");
        System.out.println("200 - SHOW ALL PPE");
        System.out.println("300 - READINGS FOR PPE");
        System.out.println("400 - List (INPUT) directory");
        System.out.println("500 - Load data from (INPUT) directory");
        System.out.println("510 - Load data from (DDG) directory");
        System.out.println("700 - RECOGNIZE FILE");
        System.out.println("800 - QUERY TO DB");
        // active test, selected test, all tests
        System.out.println("900 - Tests");
        System.out.println("921 - Date reco test");
        System.out.println("960 - POB test");
        System.out.println("     961 - create object and .toString test test");
        System.out.println("000 - EXIT");
        System.out.println("");

        // give mi first number
        param = this.waitForNumber();

        return param;
    }
}
