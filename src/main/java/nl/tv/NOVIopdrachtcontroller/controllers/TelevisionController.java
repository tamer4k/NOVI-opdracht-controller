package nl.tv.NOVIopdrachtcontroller.controllers;


import nl.tv.NOVIopdrachtcontroller.model.Television;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("product")
@RestController
public class TelevisionController {
   private ArrayList<Television> allTv = new ArrayList<>();
    @Autowired
    private ExceptionController exceptionController;

    @GetMapping
    public ResponseEntity<ArrayList<Television>> getAllTelevisions() {
        return new ResponseEntity<>(this.allTv, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(allTv.get(id));
        } catch (IndexOutOfBoundsException ex) {

            return exceptionController.handleRecordNotFoundException(new RecordNotFoundException("TV not found"));

        }
    }

    @PostMapping
    public ResponseEntity<Television> createTelevision(@RequestBody Television tv) {
        this.allTv.add(tv);
        return new ResponseEntity<>(tv, HttpStatus.CREATED);    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable int id, @RequestBody Television tv) {

        try {
            this.allTv.set(id, tv);
            return new ResponseEntity<>(tv, HttpStatus.OK);
        } catch (IndexOutOfBoundsException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable int id) {
        try {
            Television currentVal = allTv.get(id);
            allTv.remove(id);
            return new ResponseEntity<>(currentVal, HttpStatus.OK);
        } catch (IndexOutOfBoundsException ex) {
            return exceptionController.handleRecordNotFoundException(new RecordNotFoundException("TV not found"));

        }
    }
}
