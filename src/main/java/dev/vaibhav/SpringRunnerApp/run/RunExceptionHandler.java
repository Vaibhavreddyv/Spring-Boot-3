package dev.vaibhav.SpringRunnerApp.run;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RunExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<RunErrorResponse> handleExceptin (RunNotFoundException exc){

        RunErrorResponse error = new RunErrorResponse(HttpStatus.NOT_FOUND.value(),exc.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
