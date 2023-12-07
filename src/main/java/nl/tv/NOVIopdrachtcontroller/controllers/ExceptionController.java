package nl.tv.NOVIopdrachtcontroller.controllers;


import nl.tv.NOVIopdrachtcontroller.model.entity.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RestController

public class ExceptionController {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Television> handleRecordNotFoundException(RecordNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
