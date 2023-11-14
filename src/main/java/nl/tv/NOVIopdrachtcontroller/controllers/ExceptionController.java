package nl.tv.NOVIopdrachtcontroller.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
public class ExceptionController {
    public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundException ex) {
        // Implementatie voor het afhandelen van RecordNotFoundException
        return ResponseEntity.status(404).body("Record not found: " + ex.getMessage());
    }
}
