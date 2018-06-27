package com.example.demo;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

public class BudgetTest {

    private Budget budget = new Budget();

    @Before
    public void before() {
        Map<String, Float> map = new LinkedHashMap() {{
            put("20186", 3000F);
        }};
        budget.setBudgets(map);
    }

    @Test
    public void testTheSameDay() {
        LocalDate today = LocalDate.of(2018, 06, 26);
        LocalDate tomorrow = LocalDate.of(2018,06,26);

        assertEquals(new Float(100), budget.query(today, tomorrow));
    }

    @Test
    public void testLessThanOneMonthSameMonth() {

        LocalDate today = LocalDate.of(2018, 06, 25);
        LocalDate tomorrow = LocalDate.of(2018,06,26);

        assertEquals(new Float(200), budget.query(today, tomorrow));

    }

    @Test
    public void testLessThanOneMonthDifMonth() {

        LocalDate today = LocalDate.of(2018, 06, 30);
        LocalDate tomorrow = LocalDate.of(2018,07,01);

        assertEquals(new Float(200), budget.query(today, tomorrow));

    }
}
