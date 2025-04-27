package net.javaguides.expansetrackerapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MonthlyExpenseSummary {
    private String month;
    private int year;
    private BigDecimal totalAmount;

    public MonthlyExpenseSummary(String month,int year, BigDecimal totalAmount) {
        this.month = month;
        this.year = year;
        this.totalAmount = totalAmount;
    }
}
