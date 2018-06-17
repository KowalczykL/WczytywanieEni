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
//aggregated data for POB
public class PobDay {

    String osd;
    String fileName;
    String tableName = "POB_DAY";
    String tableFieldsList = "OSD,FILE_NAME,DATE_L,VERSION,NUMBER_OF_HOURS";
    long dateL;
    int version;
    int numberOfHours;
    double[] valuesAD;
    int[] statusesAI;

    public String getOsd() {
        return osd;
    }

    public void setOsd(String osd) {
        this.osd = osd;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getDateL() {
        return dateL;
    }

    public void setDateL(long dateL) {
        this.dateL = dateL;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getNubberOfHours() {
        return numberOfHours;
    }

    public void setNubberOfHours(int nubberOfHours) {
        this.numberOfHours = nubberOfHours;
    }

    public double[] getValuesAD() {
        return valuesAD;
    }

    public void setValuesAD(double[] valuesAD) {
        this.valuesAD = valuesAD;
    }

    public void setValuesAD(int index, double value) {
        this.valuesAD[index] = value;
    }

    public int[] getStatusesAI() {
        return statusesAI;
    }

    public void setStatusesAI(int[] statusesAI) {
        this.statusesAI = statusesAI;
    }

    public void setStatusesAI(int index, int status) {
        this.statusesAI[index] = status;
    }

    @Override
    public String toString() {
        String start = "PobDay{" + "osd=" + osd + ", fileName=" + fileName + ", dateL=" + dateL + ", version=" + version + ", nubberOfHours=" + numberOfHours + '}';
        String vals = "";
        String stats = "";
        for (double val : valuesAD) {
            vals = vals + " | " + val;
        }
        for (int stat : statusesAI) {
            stats = stats + " | " + stat;
        }
        return start + vals + stats;
    }

    public String returnSavingQuery() {
        String saveQuery = "";
        String start = "INSERT INTO";
        String tableNames = "";
        String tableVals = "";
        tableNames += this.tableFieldsList;

        for (int i = 1; i <= this.numberOfHours + 1; i++) {
            tableNames += ",HR" + i + "VAL";
        }

        for (int i = 1; i <= this.numberOfHours + 1; i++) {
            tableNames += ",HR" + i + "STAT";
        }
        tableVals += "'" + this.osd + "','" + this.fileName + "','" + this.dateL + "','" + this.version + "','" + this.numberOfHours + "'";

        for (double val : valuesAD) {
            tableVals += "," + "'" + val + "'";

        }
        for (int stat : statusesAI) {
            tableVals += "," + "'" + stat + "'";

        }
        saveQuery = start + " " + this.tableName + " (" + tableNames + ") VALUES (" + tableVals + ")";
        return saveQuery;
    }

    public String[] returnSavingQueryElements() {
        String[] elements = new String[3];
        elements[0] = this.tableName;
        String tableFields = "(";

        tableFields += this.tableFieldsList;

        for (int i = 1; i <= this.numberOfHours + 1; i++) {
            tableFields += ",HR" + i + "VAL";
        }

        for (int i = 1; i <= this.numberOfHours + 1; i++) {
            tableFields += ",HR" + i + "STAT";
        }
        tableFields += ")";
        elements[1] = tableFields;

        String tableValues = "(";

        tableValues += "'" + this.osd + "','" + this.fileName + "','" + this.dateL + "','" + this.version + "','" + this.numberOfHours + "'";

        for (double val : valuesAD) {
            tableValues += "," + "'" + val + "'";

        }
        for (int stat : statusesAI) {
            tableValues += "," + "'" + stat + "'";
        }
        tableValues += ")";

        elements[2] = tableValues;
        return elements;

    }

    public String isInBaseQuery() {

        return "not yet";
    }

}
