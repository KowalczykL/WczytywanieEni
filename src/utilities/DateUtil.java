/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class DateUtil {

    public static long ConvertStringDateToMillis(String date) {
String format = DateUtil.recognizeFormat(date);
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date dateO = null;
        System.out.println("input "+date);
        try {
            dateO = formatter.parse(date);
            System.out.println("getmillismet "+ dateO);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dateO.getTime();
    }

    public static String recognizeFormat(String data) {
        String format = null;

        char[] dateChar = data.toCharArray();

        if (dateChar[2] == '-') {
            format = "dd-MM-yyyy";
        } else if (dateChar[4] == '-') {
            format = "yyyy-MM-dd";
        } else if (dateChar[2] == '.') {
            format = "dd.MM.yyyy";
        } else if (dateChar[4] == '.') {
            format = "yyyy.MM.dd";
        }

        return format;
    }

    public static String MillisToTauStringDate(long millis) {
        String format = "yyyy-MM-dd";
        
Date date = new Date(millis);

 return DateFormat.getDateInstance().format(date);
    }

}
