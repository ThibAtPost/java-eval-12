package lu.post.eval.entrypoint.main.handler;

import lombok.extern.slf4j.Slf4j;
import lu.post.eval.domain.exception.InvalidInputException;
import lu.post.gen.eval.application.model.ErrorOA;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "lu.post.eval.entrypoint.main.controller")
@Order(value = 1)
@Slf4j
public class MainEntrypointHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorOA> handle(InvalidInputException ex) {
        log.error("Managed response", ex);
        return new ResponseEntity<>(new ErrorOA().message("Invalid Input"), HttpStatus.BAD_REQUEST);
    }
}
