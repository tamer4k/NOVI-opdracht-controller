package nl.tv.NOVIopdrachtcontroller.controllers;


import nl.tv.NOVIopdrachtcontroller.model.Television;
import nl.tv.NOVIopdrachtcontroller.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("televisions")
@RestController
public class TelevisionController {
    @Autowired
   private TelevisionRepository televisionRepository;

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions() {
        List<Television> televisions = televisionRepository.findAll();
        return ResponseEntity.ok(televisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable Long id) {
        return televisionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
        Television savedTelevision = televisionRepository.save(television);
        return ResponseEntity.created(null).body(savedTelevision);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television updatedTelevision) {
        return televisionRepository.findById(id)
                .map(existingTelevision -> {
                    existingTelevision.setType(updatedTelevision.getType());
                    existingTelevision.setBrand(updatedTelevision.getBrand());
                    // Update other fields as needed

                    Television savedTelevision = televisionRepository.save(existingTelevision);
                    return ResponseEntity.ok(savedTelevision);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        televisionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
