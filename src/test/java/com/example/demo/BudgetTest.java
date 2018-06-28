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

    @Test
    public void testTheSameDay() {
        givenBudget(
                new LinkedHashMap() {{
                    put("20186", 3000F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 06, 26);
        LocalDate endDate = LocalDate.of(2018, 06, 26);

        assertEquals(new Float(100), budget.query(startDate, endDate));
    }

    @Test
    public void testLessThanOneMonthSameMonth() {
        givenBudget(
                new LinkedHashMap() {{
                    put("20186", 3000F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 06, 25);
        LocalDate endDate = LocalDate.of(2018, 06, 26);

        assertEquals(new Float(200), budget.query(startDate, endDate));

    }

    @Test
    public void testLessThanOneMonthDifMonth() {
        givenBudget(
                new LinkedHashMap() {{
                    put("20186", 3000F);
                    put("20187", 3100F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 06, 30);
        LocalDate endDate = LocalDate.of(2018, 07, 01);

        assertEquals(new Float(200), budget.query(startDate, endDate));

    }

    private void givenBudget(LinkedHashMap linkedHashMap) {
        Map<String, Float> map = linkedHashMap;
        budget.setBudgets(map);
    }
}
