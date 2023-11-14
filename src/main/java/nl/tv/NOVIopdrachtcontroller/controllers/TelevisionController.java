package nl.tv.NOVIopdrachtcontroller.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("product")
@RestController
public class TelevisionController {
    List<String> allTv = new ArrayList<>();
    @Autowired
    private ExceptionController exceptionController;

    @GetMapping
    public ResponseEntity<String> getAllTelevisions() {
        // Implementatie voor het ophalen van alle televisies
        return ResponseEntity.ok("Get all televisions " + allTv);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable int id) {

        // Implementatie voor het ophalen van één televisie op basis van ID
        try {
            return ResponseEntity.ok("Get television by id: " + id + " is " + allTv.get(id));
        } catch (IndexOutOfBoundsException ex) {
            // Als de index niet wordt gevonden, roep dan de exception handler op
            return exceptionController.handleRecordNotFoundException(new RecordNotFoundException("TV not found"));
        }
    }

    @PostMapping
    public ResponseEntity<String> createTelevision(@RequestParam String tv) {
        // Implementatie voor het aanmaken van één televisie
        allTv.add(tv);
        return ResponseEntity.created(null).body("Television created is " + tv);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestParam String tv) {

        // Implementatie voor het bijwerken van één televisie op basis van ID
        try {
            allTv.set(id, tv);
            return ResponseEntity.ok("Television updated: " + id + " to " + allTv.get(id));
        } catch (IndexOutOfBoundsException ex) {
            // Als de index niet wordt gevonden, roep dan de exception handler op
            return exceptionController.handleRecordNotFoundException(new RecordNotFoundException("TV not found"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        // Implementatie voor het verwijderen van één televisie op basis van ID
        try {
            String currentVal = allTv.get(id);
            allTv.remove(id);
            return ResponseEntity.ok(currentVal + " Television is verwijderd");
        } catch (IndexOutOfBoundsException ex) {
            // Als de index niet wordt gevonden, roep dan de exception handler op
            return exceptionController.handleRecordNotFoundException(new RecordNotFoundException("TV not found"));
        }
    }
}
