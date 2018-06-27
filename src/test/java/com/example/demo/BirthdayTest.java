package com.example.demo;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class BirthdayTest {

    @Test
    public void testIsBirthday() {
        Birthday birthday = new Birthday();

        Calendar cal = Calendar.getInstance();
        cal.set(2018, Calendar.SEPTEMBER, 1);

        Date date = cal.getTime();

        String r = birthday.isBirthday(date);
        assertEquals("Happy Birthday", r);


    }

}