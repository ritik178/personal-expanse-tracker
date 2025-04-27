package net.javaguides.expansetrackerapp.service;

import net.javaguides.expansetrackerapp.dto.ExpanseDto;
import net.javaguides.expansetrackerapp.entity.MonthlyExpenseSummary;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ExpanseService {

    ExpanseDto createExpanse(ExpanseDto expanseDto);

    ExpanseDto getExpanseId(Long id);

    List<ExpanseDto> getAllExpanses();

    ExpanseDto updateExpanse(Long expanseId,ExpanseDto expanseDto);

    void deleteExpanse(Long expanseId);

    BigDecimal getTotalExpanse();

    List<MonthlyExpenseSummary> getMonthlyExpenseSummary();

    public List<Map<String, Object>> getCategorySummary();
}
