/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.odczyty;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Łukasz Kowalczyk
 */
public class TestObjectsFactory {

    public static DdgHour returnDdgHour() {
        DdgHour ddgHour = new DdgHour("ENID_4081037156", "22.04.2018", 13.408, 1, 6);

        return ddgHour;
    }

    public static DdgDay returnDdgDay() {

        LocalDate data = LocalDate.now();
        DdgDay ddgDay = new DdgDay(1, "TAU", "SOME_PPE", "SOME_DATE", "SOME_FILE_NAME", 11, 27, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        return ddgDay;
    }

    public static PobDay returnPobDay() {
        PobDay pobDay = new PobDay();
        pobDay.setOsd("RWE");
        pobDay.setFileName("someFile");
        pobDay.setDateL(1529054359282L);
        pobDay.setVersion(99);
        pobDay.setNubberOfHours(24);
        double[] values = {1.1, 2.2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23.23, 24.24, 25.25};
        pobDay.setValuesAD(values);
        int[] statuses = {11, 22, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 2323, 2424, 2525};
        pobDay.setStatusesAI(statuses);

        return pobDay;
    }

}
