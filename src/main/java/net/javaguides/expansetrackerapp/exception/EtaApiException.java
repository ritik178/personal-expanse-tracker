package net.javaguides.expansetrackerapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class EtaApiException extends RuntimeException{

    private HttpStatus status;
    private String message;
}
