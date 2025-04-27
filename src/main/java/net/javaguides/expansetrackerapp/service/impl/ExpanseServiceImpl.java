package net.javaguides.expansetrackerapp.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.expansetrackerapp.dto.ExpanseDto;
import net.javaguides.expansetrackerapp.entity.Category;
import net.javaguides.expansetrackerapp.entity.Expanse;
import net.javaguides.expansetrackerapp.entity.MonthlyExpenseSummary;
import net.javaguides.expansetrackerapp.exception.ResourceNotFoundException;
import net.javaguides.expansetrackerapp.mapper.ExpanseMapper;
import net.javaguides.expansetrackerapp.repository.CategoryRepository;
import net.javaguides.expansetrackerapp.repository.ExpanseRepository;
import net.javaguides.expansetrackerapp.service.ExpanseService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpanseServiceImpl implements ExpanseService {

    private ExpanseRepository expanseRepository;

    private CategoryRepository categoryRepository;

    @Override
    public ExpanseDto createExpanse(ExpanseDto expanseDto) {

        // convert ExpanseDto to expanse Entity
        Expanse expanse = ExpanseMapper.mapToExpanse(expanseDto);

        //save expanse entity to database
        Expanse savedExpanse = expanseRepository.save(expanse);

        //covert saved expense enity to ExpanseDto
        return ExpanseMapper.mapToExpanseDto(savedExpanse);
    }

    @Override
    public ExpanseDto getExpanseId(Long expanseId) {
        // get expanse enity is available or not
        Expanse expanse=expanseRepository.findById(expanseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expanse with id " + expanseId + " not found"));


        return ExpanseMapper.mapToExpanseDto(expanse);
    }

    @Override
    public List<ExpanseDto> getAllExpanses() {

       List<Expanse> expanses = expanseRepository.findAll();

       return expanses.stream()
               .map((expanse) -> ExpanseMapper.mapToExpanseDto(expanse))
               .collect(Collectors.toList());

    }

    @Override
    public ExpanseDto updateExpanse(Long expanseId, ExpanseDto expanseDto) {
        //check expanse id is available or not
       Expanse expanse = expanseRepository.findById(expanseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expanse with id " + expanseId + " not found"));


       // update expanse amount
        expanse.setAmount(expanseDto.amount());

        // update expanse date
        expanse.setExpanseDate(expanseDto.expanseDate());

        // update expanse category
        if(expanseDto.categoryDto()!=null) {
            // get category entity
           Category category = categoryRepository.findById(expanseDto.categoryDto().id())
                    .orElseThrow(() -> new ResourceNotFoundException("Category with id " + expanseDto.categoryDto().id()));

           expanse.setCategory(category);
        }
        // update expanse Entity
        Expanse updatedExpanse = expanseRepository.save(expanse);
        // convert expanse enity to dto
        return ExpanseMapper.mapToExpanseDto(updatedExpanse);
    }

    @Override
    public void deleteExpanse(Long expanseId) {
        Expanse expanse = expanseRepository.findById(expanseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expanse with id " + expanseId + " not found"));

        expanseRepository.delete(expanse);
    }

    @Override
    public BigDecimal getTotalExpanse() {
        return expanseRepository.getTotalExpanseFromDB();
    }

    @Override
    public List<MonthlyExpenseSummary> getMonthlyExpenseSummary() {

        List<Object[]> rawResults = expanseRepository.getMonthlyExpenseSummaryRaw();
        List<MonthlyExpenseSummary> summaryList = new ArrayList<>();

        for (Object[] row : rawResults) {
            String month = row[0].toString(); // Example: "January"
            int year = Integer.parseInt(row[1].toString());
            BigDecimal totalAmount = new BigDecimal(row[2].toString());

            summaryList.add(new MonthlyExpenseSummary(month, year, totalAmount));
        }

        return summaryList;
    }

    @Override
    public List<Map<String, Object>> getCategorySummary() {

        return expanseRepository.findCategorySummary();
    }


}
