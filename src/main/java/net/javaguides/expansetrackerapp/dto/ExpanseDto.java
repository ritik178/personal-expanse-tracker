package net.javaguides.expansetrackerapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "Expanse DTO (DATA TRANSFER OBJECT) TO transfer the data between client and server"
)
public record ExpanseDto(Long id,@Schema(
        description = "Expanse Amount"
) BigDecimal amount,
                         @Schema(
                                 description = "Expanse created date"
                         )
                         LocalDate expanseDate,
                         @Schema(
                                 description = "Associated expanse category"
                         )
                         CategoryDto categoryDto) {
}
