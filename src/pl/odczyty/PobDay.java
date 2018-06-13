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
    long dateL;
    int version;
    int nubberOfHours;
    double[] valuesAD;
    ArrayList<Double> values;
    int[] statusesAI;
    ArrayList<Integer> statuses;

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
        return nubberOfHours;
    }

    public void setNubberOfHours(int nubberOfHours) {
        this.nubberOfHours = nubberOfHours;
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

    public ArrayList<Double> getValues() {
        return values;
    }

    public void setValues(ArrayList<Double> values) {
        this.values = values;
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

    public ArrayList<Integer> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<Integer> statuses) {
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "PobDay{" + "osd=" + osd + ", fileName=" + fileName + ", dateL=" + dateL + ", version=" + version + ", nubberOfHours=" + nubberOfHours + ", valuesAD0=" + valuesAD[0] + ", statusesAI0=" + statusesAI[0] + ", valuesAD10=" + valuesAD[10] + ", statusesAI10=" + statusesAI[10] + ", valuesAD24=" + valuesAD[23] + ", statusesAI24=" + statusesAI[23] + '}';
        
    }



}
