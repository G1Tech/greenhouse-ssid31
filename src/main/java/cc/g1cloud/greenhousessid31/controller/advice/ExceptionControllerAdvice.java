package cc.g1cloud.greenhousessid31.controller.advice;

import cc.g1cloud.greenhousessid31.controller.dto.response.ErrorResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
@Log4j2
public class ExceptionControllerAdvice {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponseDto> handleException(Exception exception) {
        var uuid = UUID.randomUUID();
        log.error("Controller UUID Error: {}, message: {}", uuid, exception);
        return new ResponseEntity<>(
                new ErrorResponseDto(uuid, System.currentTimeMillis(), exception.getMessage()),
                null,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponseDto> methodArgumentNotValidException(Exception exception) {
        var uuid = UUID.randomUUID();
        log.error("Controller UUID Error: {}, message: {}", uuid, exception);
        return new ResponseEntity<>(
                new ErrorResponseDto(uuid, System.currentTimeMillis(), "Bad Request"),
                null,
                HttpStatus.BAD_REQUEST);
    }

}
