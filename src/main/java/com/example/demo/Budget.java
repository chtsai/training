package com.example.demo;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class Budget {

    // 20181: 31
    // 20182: 28
    // 201812: 28
    private Map<String, Float> budgets = new LinkedHashMap<>();

    public Budget() {
    }

    public void setBudgets(Map<String, Float> budgets) {
        this.budgets = budgets;
    }

    private boolean isSameMonth(LocalDate stateDate, LocalDate endDate) {
        if (stateDate.getYear() != endDate.getYear()) {
            return false;
        } else {
            return stateDate.getMonth().equals(endDate.getMonth());
        }
    }

    private String getYearMonth(LocalDate date) {
        return String.valueOf(date.getYear()) + String.valueOf(date.getMonthValue());
    }

    public float query(LocalDate startDate, LocalDate endDate) {
        float total = 0;

        if (isSameMonth(startDate, endDate)) {
            // same month
            int days = endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1;
            float amount = this.budgets.getOrDefault(this.getYearMonth(startDate), 0F);
            amount = amount * days / startDate.lengthOfMonth();

            total += amount;
        } else {
            // different month
            for (LocalDate currentDate = LocalDate.of(startDate.getYear(), startDate.getMonthValue(), 1);
                 currentDate.isBefore(endDate);
                 currentDate.plusMonths(1)) {
                System.out.printf(currentDate.toString());

                float amount = this.budgets.getOrDefault(this.getYearMonth(currentDate), 0F);

                if (isSameMonth(currentDate, startDate)) {
                    // first month
                    int days = startDate.lengthOfMonth() - startDate.getDayOfMonth() + 1;
                    amount = amount * days / startDate.lengthOfMonth();
                } else if (isSameMonth(currentDate, endDate)) {
                    // last month
                    int days = endDate.getDayOfMonth();
                    amount = amount * days / endDate.lengthOfMonth();
                } else {
                    // months in the middle
                    amount = amount;
                }
                total += amount;
            }
        }

        return total;
    }
}
