package com.example.demo;

import java.util.Calendar;
import java.util.Date;

public class Birthday {

    public String isBirthday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int m = cal.get(Calendar.MONTH);
        int d = cal.get(Calendar.DAY_OF_MONTH);

        if (m == 8 && d == 1) {
            return "Happy Birthday";
        } else {
            return "N";
        }
    }
}
