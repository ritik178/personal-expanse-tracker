package net.javaguides.expansetrackerapp.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(
        description = "error DTO (DATA TRANSFER OBJECT) TO transfer the error between client and server"
)
@Getter
@Setter
public class ErrorDetails {

    @Schema(
            description = "error occurred date and time"
    )
    private LocalDateTime timestamp;
    @Schema(
            description = "error occurred message"
    )
    private String message;
    @Schema(
            description = "error details "
    )
    private String details;
    @Schema(
            description = "error occurred with errorcode"
    )
    private String errorCode;
}
