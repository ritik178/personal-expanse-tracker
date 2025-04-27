package net.javaguides.expansetrackerapp.mapper;

import net.javaguides.expansetrackerapp.dto.CategoryDto;
import net.javaguides.expansetrackerapp.dto.ExpanseDto;
import net.javaguides.expansetrackerapp.entity.Category;
import net.javaguides.expansetrackerapp.entity.Expanse;

public class ExpanseMapper {

    public static ExpanseDto mapToExpanseDto(Expanse expanse) {
        return new ExpanseDto(
                expanse.getId(),
                expanse.getAmount(),
                expanse.getExpanseDate(),
                new CategoryDto(
                        expanse.getCategory().getId(),
                        expanse.getCategory().getName()
                )
        );
    }

    public static Expanse mapToExpanse(ExpanseDto expanseDto) {
        Category category = new Category();
        category.setId(expanseDto.categoryDto().id());

        Expanse expanse = new Expanse(
                expanseDto.id(),
                expanseDto.amount(),
                expanseDto.expanseDate(),
                category
        );

        return expanse;
    }
}
