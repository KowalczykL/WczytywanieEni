/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.time.LocalDate;

/**
 *
 * @author Łukasz Kowalczyk
 */
//measurements for one day
public class DdgDay {

    private long id;
    private String osd;
    private String ppe;
    private String dataS;
    private LocalDate dataD;
    private String fileName;
    private int version;
    private int numberOfHours;

    // suming values of all hours in day into value for day - suming in constructor
    private double dayVal;

    private double hour1val;
    private double hour2val;
    private double hour3val;
    private double hour4val;
    private double hour5val;
    private double hour6val;
    private double hour7val;
    private double hour8val;
    private double hour9val;
    private double hour10val;
    private double hour11val;
    private double hour12val;
    private double hour13val;
    private double hour14val;
    private double hour15val;
    private double hour16val;
    private double hour17val;
    private double hour18val;
    private double hour19val;
    private double hour20val;
    private double hour21val;
    private double hour22val;
    private double hour23val;
    private double hour24val;
    private double hour2Aval;

    private int hour1Status;
    private int hour2Status;
    private int hour3Status;
    private int hour4Status;
    private int hour5Status;
    private int hour6Status;
    private int hour7Status;
    private int hour8Status;
    private int hour9Status;
    private int hour10Status;
    private int hour11Status;
    private int hour12Status;
    private int hour13Status;
    private int hour14Status;
    private int hour15Status;
    private int hour16Status;
    private int hour17Status;
    private int hour18Status;
    private int hour19Status;
    private int hour20Status;
    private int hour21Status;
    private int hour22Status;
    private int hour23Status;
    private int hour24Status;
    private int hour2AStatus;

    public DdgDay(long id, String osd, String ppe, String dataS, String fileName, int version, int numberOfHours, double hour1val, double hour2val, double hour3val, double hour4val, double hour5val, double hour6val, double hour7val, double hour8val, double hour9val, double hour10val, double hour11val, double hour12val, double hour13val, double hour14val, double hour15val, double hour16val, double hour17val, double hour18val, double hour19val, double hour20val, double hour21val, double hour22val, double hour23val, double hour24val, double hour2Aval, int hour1Status, int hour2Status, int hour3Status, int hour4Status, int hour5Status, int hour6Status, int hour7Status, int hour8Status, int hour9Status, int hour10Status, int hour11Status, int hour12Status, int hour13Status, int hour14Status, int hour15Status, int hour16Status, int hour17Status, int hour18Status, int hour19Status, int hour20Status, int hour21Status, int hour22Status, int hour23Status, int hour24Status, int hour2AStatus) {
        this.id = id;
        this.osd = osd;
        this.ppe = ppe;
        this.dataS = dataS;
        this.dataD = dataD;
        this.fileName = fileName;
        this.version = version;
        this.numberOfHours = numberOfHours;
        this.hour1val = hour1val;
        this.hour2val = hour2val;
        this.hour3val = hour3val;
        this.hour4val = hour4val;
        this.hour5val = hour5val;
        this.hour6val = hour6val;
        this.hour7val = hour7val;
        this.hour8val = hour8val;
        this.hour9val = hour9val;
        this.hour10val = hour10val;
        this.hour11val = hour11val;
        this.hour12val = hour12val;
        this.hour13val = hour13val;
        this.hour14val = hour14val;
        this.hour15val = hour15val;
        this.hour16val = hour16val;
        this.hour17val = hour17val;
        this.hour18val = hour18val;
        this.hour19val = hour19val;
        this.hour20val = hour20val;
        this.hour21val = hour21val;
        this.hour22val = hour22val;
        this.hour23val = hour23val;
        this.hour24val = hour24val;
        this.hour2Aval = hour2Aval;
        this.hour1Status = hour1Status;
        this.hour2Status = hour2Status;
        this.hour3Status = hour3Status;
        this.hour4Status = hour4Status;
        this.hour5Status = hour5Status;
        this.hour6Status = hour6Status;
        this.hour7Status = hour7Status;
        this.hour8Status = hour8Status;
        this.hour9Status = hour9Status;
        this.hour10Status = hour10Status;
        this.hour11Status = hour11Status;
        this.hour12Status = hour12Status;
        this.hour13Status = hour13Status;
        this.hour14Status = hour14Status;
        this.hour15Status = hour15Status;
        this.hour16Status = hour16Status;
        this.hour17Status = hour17Status;
        this.hour18Status = hour18Status;
        this.hour19Status = hour19Status;
        this.hour20Status = hour20Status;
        this.hour21Status = hour21Status;
        this.hour22Status = hour22Status;
        this.hour23Status = hour23Status;
        this.hour24Status = hour24Status;
        this.hour2AStatus = hour2AStatus;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public DdgDay() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOsd() {
        return osd;
    }

    public void setOsd(String osd) {
        this.osd = osd;
    }

    public String getPpe() {
        return ppe;
    }

    public void setPpe(String ppe) {
        this.ppe = ppe;
    }

    public String getDataS() {
        return dataS;
    }

    public void setDataS(String dataS) {
        this.dataS = dataS;
    }

    public LocalDate getDataD() {
        return dataD;
    }

    public void setDataD(LocalDate dataD) {
        this.dataD = dataD;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public double getDayVal() {
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;
        return dayVal;
    }

    public void setDayVal(double dayVal) {
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour1val() {
        return hour1val;
    }

    public void setHour1val(double hour1val) {
        this.hour1val = hour1val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour2val() {
        return hour2val;
    }

    public void setHour2val(double hour2val) {
        this.hour2val = hour2val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour3val() {
        return hour3val;
    }

    public void setHour3val(double hour3val) {
        this.hour3val = hour3val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour4val() {
        return hour4val;
    }

    public void setHour4val(double hour4val) {
        this.hour4val = hour4val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour5val() {
        return hour5val;
    }

    public void setHour5val(double hour5val) {
        this.hour5val = hour5val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour6val() {
        return hour6val;
    }

    public void setHour6val(double hour6val) {
        this.hour6val = hour6val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour7val() {
        return hour7val;
    }

    public void setHour7val(double hour7val) {
        this.hour7val = hour7val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour8val() {
        return hour8val;
    }

    public void setHour8val(double hour8val) {
        this.hour8val = hour8val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour9val() {
        return hour9val;
    }

    public void setHour9val(double hour9val) {
        this.hour9val = hour9val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour10val() {
        return hour10val;
    }

    public void setHour10val(double hour10val) {
        this.hour10val = hour10val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour11val() {
        return hour11val;
    }

    public void setHour11val(double hour11val) {
        this.hour11val = hour11val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;
    }

    public double getHour12val() {
        return hour12val;
    }

    public void setHour12val(double hour12val) {
        this.hour12val = hour12val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour13val() {
        return hour13val;
    }

    public void setHour13val(double hour13val) {
        this.hour13val = hour13val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour14val() {
        return hour14val;
    }

    public void setHour14val(double hour14val) {
        this.hour14val = hour14val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour15val() {
        return hour15val;
    }

    public void setHour15val(double hour15val) {
        this.hour15val = hour15val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour16val() {
        return hour16val;
    }

    public void setHour16val(double hour16val) {
        this.hour16val = hour16val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour17val() {
        return hour17val;
    }

    public void setHour17val(double hour17val) {
        this.hour17val = hour17val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour18val() {
        return hour18val;
    }

    public void setHour18val(double hour18val) {
        this.hour18val = hour18val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour19val() {
        return hour19val;
    }

    public void setHour19val(double hour19val) {
        this.hour19val = hour19val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour20val() {
        return hour20val;
    }

    public void setHour20val(double hour20val) {
        this.hour20val = hour20val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour21val() {
        return hour21val;
    }

    public void setHour21val(double hour21val) {
        this.hour21val = hour21val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour22val() {
        return hour22val;
    }

    public void setHour22val(double hour22val) {
        this.hour22val = hour22val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour23val() {
        return hour23val;
    }

    public void setHour23val(double hour23val) {
        this.hour23val = hour23val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour24val() {
        return hour24val;
    }

    public void setHour24val(double hour24val) {
        this.hour24val = hour24val;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public double getHour2Aval() {
        return hour2Aval;
    }

    public void setHour2Aval(double hour2Aval) {
        this.hour2Aval = hour2Aval;
        this.dayVal = hour1val + hour2val + hour3val + hour4val + hour5val + hour6val + hour7val + hour8val + hour9val + hour10val + hour11val + hour12val + hour13val + hour14val + hour15val + hour16val + hour17val + hour18val + hour19val + hour20val + hour21val + hour22val + hour23val + hour24val + hour2Aval;

    }

    public int getHour1Status() {
        return hour1Status;
    }

    public void setHour1Status(int hour1Status) {
        this.hour1Status = hour1Status;
    }

    public int getHour2Status() {
        return hour2Status;
    }

    public void setHour2Status(int hour2Status) {
        this.hour2Status = hour2Status;
    }

    public int getHour3Status() {
        return hour3Status;
    }

    public void setHour3Status(int hour3Status) {
        this.hour3Status = hour3Status;
    }

    public int getHour4Status() {
        return hour4Status;
    }

    public void setHour4Status(int hour4Status) {
        this.hour4Status = hour4Status;
    }

    public int getHour5Status() {
        return hour5Status;
    }

    public void setHour5Status(int hour5Status) {
        this.hour5Status = hour5Status;
    }

    public int getHour6Status() {
        return hour6Status;
    }

    public void setHour6Status(int hour6Status) {
        this.hour6Status = hour6Status;
    }

    public int getHour7Status() {
        return hour7Status;
    }

    public void setHour7Status(int hour7Status) {
        this.hour7Status = hour7Status;
    }

    public int getHour8Status() {
        return hour8Status;
    }

    public void setHour8Status(int hour8Status) {
        this.hour8Status = hour8Status;
    }

    public int getHour9Status() {
        return hour9Status;
    }

    public void setHour9Status(int hour9Status) {
        this.hour9Status = hour9Status;
    }

    public int getHour10Status() {
        return hour10Status;
    }

    public void setHour10Status(int hour10Status) {
        this.hour10Status = hour10Status;
    }

    public int getHour11Status() {
        return hour11Status;
    }

    public void setHour11Status(int hour11Status) {
        this.hour11Status = hour11Status;
    }

    public int getHour12Status() {
        return hour12Status;
    }

    public void setHour12Status(int hour12Status) {
        this.hour12Status = hour12Status;
    }

    public int getHour13Status() {
        return hour13Status;
    }

    public void setHour13Status(int hour13Status) {
        this.hour13Status = hour13Status;
    }

    public int getHour14Status() {
        return hour14Status;
    }

    public void setHour14Status(int hour14Status) {
        this.hour14Status = hour14Status;
    }

    public int getHour15Status() {
        return hour15Status;
    }

    public void setHour15Status(int hour15Status) {
        this.hour15Status = hour15Status;
    }

    public int getHour16Status() {
        return hour16Status;
    }

    public void setHour16Status(int hour16Status) {
        this.hour16Status = hour16Status;
    }

    public int getHour17Status() {
        return hour17Status;
    }

    public void setHour17Status(int hour17Status) {
        this.hour17Status = hour17Status;
    }

    public int getHour18Status() {
        return hour18Status;
    }

    public void setHour18Status(int hour18Status) {
        this.hour18Status = hour18Status;
    }

    public int getHour19Status() {
        return hour19Status;
    }

    public void setHour19Status(int hour19Status) {
        this.hour19Status = hour19Status;
    }

    public int getHour20Status() {
        return hour20Status;
    }

    public void setHour20Status(int hour20Status) {
        this.hour20Status = hour20Status;
    }

    public int getHour21Status() {
        return hour21Status;
    }

    public void setHour21Status(int hour21Status) {
        this.hour21Status = hour21Status;
    }

    public int getHour22Status() {
        return hour22Status;
    }

    public void setHour22Status(int hour22Status) {
        this.hour22Status = hour22Status;
    }

    public int getHour23Status() {
        return hour23Status;
    }

    public void setHour23Status(int hour23Status) {
        this.hour23Status = hour23Status;
    }

    public int getHour24Status() {
        return hour24Status;
    }

    public void setHour24Status(int hour24Status) {
        this.hour24Status = hour24Status;
    }

    public int getHour2AStatus() {
        return hour2AStatus;
    }

    public void setHour2AStatus(int hour2AStatus) {
        this.hour2AStatus = hour2AStatus;

    }

}
