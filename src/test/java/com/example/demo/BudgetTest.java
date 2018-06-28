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
                    put("201806", 3000F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 06, 26);
        LocalDate endDate = LocalDate.of(2018, 06, 26);

        assertEquals(100F, budget.query(startDate, endDate));
    }

    @Test
    public void testLessThanOneMonthSameMonth() {
        givenBudget(
                new LinkedHashMap() {{
                    put("201806", 3000F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 06, 25);
        LocalDate endDate = LocalDate.of(2018, 06, 26);

        assertEquals(200F, budget.query(startDate, endDate));

    }

    @Test
    public void testOneMonth() {
        givenBudget(
                new LinkedHashMap() {{
                    put("201806", 3000F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 06, 1);
        LocalDate endDate = LocalDate.of(2018, 06, 30);

        assertEquals(3000F, budget.query(startDate, endDate));

    }

    @Test
    public void testLessThanOneMonthDifMonth() {
        givenBudget(
                new LinkedHashMap() {{
                    put("201806", 3000F);
                    put("201807", 3100F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 06, 30);
        LocalDate endDate = LocalDate.of(2018, 07, 01);

        assertEquals(200F, budget.query(startDate, endDate));

    }

    @Test
    public void testMoreThanOneMonth() {
        givenBudget(
                new LinkedHashMap() {{
                    put("201806", 3000F);
                    put("201807", 3100F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 06, 15);
        LocalDate endDate = LocalDate.of(2018, 07, 15);

        assertEquals(3100F, budget.query(startDate, endDate));

    }
    @Test
    public void testMoreThanOneMonthCrossMonth() {
        givenBudget(
                new LinkedHashMap() {{
                    put("201806", 3000F);
                    put("201807", 3100F);
                    put("201808", 3100F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 06, 15);
        LocalDate endDate = LocalDate.of(2018, 8, 15);

        assertEquals(6200F, budget.query(startDate, endDate));

    }
    @Test
    public void testNoBudgetAtStartMonth() {
        givenBudget(
                new LinkedHashMap() {{
                    put("201807", 3100F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 06, 30);
        LocalDate endDate = LocalDate.of(2018, 07, 01);

        assertEquals(100F, budget.query(startDate, endDate));

    }

    @Test
    public void testNoBudgetAtEndMonth() {
        givenBudget(
                new LinkedHashMap() {{
                    put("201806", 3000F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 06, 30);
        LocalDate endDate = LocalDate.of(2018, 07, 01);

        assertEquals(100F, budget.query(startDate, endDate));

    }

    @Test
    public void testNoBudgetAtMiddleMonth() {
        givenBudget(
                new LinkedHashMap() {{
                    put("201806", 3000F);
                    put("201808", 3100F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 06, 30);
        LocalDate endDate = LocalDate.of(2018, 8, 01);

        assertEquals(200F, budget.query(startDate, endDate));

    }

    @Test
    public void testNoBudget() {
        givenBudget(
                new LinkedHashMap() {{
                    put("201806", 3000F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 7, 30);
        LocalDate endDate = LocalDate.of(2018, 8, 01);

        assertEquals(0F, budget.query(startDate, endDate));

    }

    @Test
    public void testLessThanOneMonthCrossYear() {
        givenBudget(
                new LinkedHashMap() {{
                    put("201812", 3100F);
                    put("201901", 3100F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 12, 31);
        LocalDate endDate = LocalDate.of(2019, 01, 01);

        assertEquals(200F, budget.query(startDate, endDate));

    }

    @Test
    public void testMoreThanOneMonthCrossYear() {
        givenBudget(
                new LinkedHashMap() {{
                    put("201812", 3100F);
                    put("201901", 3100F);
                    put("201902", 2800F);
                }}
        );

        LocalDate startDate = LocalDate.of(2018, 12, 31);
        LocalDate endDate = LocalDate.of(2019, 02, 01);

        assertEquals(3300F, budget.query(startDate, endDate));

    }

    private void givenBudget(LinkedHashMap linkedHashMap) {
        Map<String, Float> map = linkedHashMap;
        budget.setBudgets(map);
    }
}
