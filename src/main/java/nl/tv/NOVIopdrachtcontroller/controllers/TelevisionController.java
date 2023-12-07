package nl.tv.NOVIopdrachtcontroller.controllers;


import jakarta.servlet.annotation.HandlesTypes;
import nl.tv.NOVIopdrachtcontroller.model.dto.GetTelevisionByIdDTO;
import nl.tv.NOVIopdrachtcontroller.model.dto.TelevisionDTO;
import nl.tv.NOVIopdrachtcontroller.model.dto.CreateTelevisionResponseDTO;
import nl.tv.NOVIopdrachtcontroller.model.entity.Television;
import nl.tv.NOVIopdrachtcontroller.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequestMapping("televisions")
@RestController
public class TelevisionController {
    @Autowired
    private final TelevisionService televisionService;

    public  TelevisionController(TelevisionService televisionService){
        this.televisionService = televisionService;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionDTO>> getAllTelevisions() {
        List<TelevisionDTO> dtoList = televisionService.getAllTelevision();
        if (!dtoList.isEmpty()) {
            return ResponseEntity.ok(dtoList);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(dtoList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity <GetTelevisionByIdDTO> getTelevisionById(@PathVariable Long id){
        GetTelevisionByIdDTO televisionDTO = televisionService.getTelevisionById(id);
        if (televisionDTO != null) {
            return ResponseEntity.ok(televisionDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateTelevisionResponseDTO> createTelevision(@RequestBody TelevisionDTO televisionDTO) {

        CreateTelevisionResponseDTO createdTelevisionDTO = televisionService.createTelevision(televisionDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTelevisionDTO);

    }


    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDTO> updateTelevision(@PathVariable Long id, @RequestBody TelevisionDTO televisionDTO) {
        TelevisionDTO updatedTelevisionDTO = televisionService.updateTelevision(id, televisionDTO);

        if (updatedTelevisionDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedTelevisionDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updatedTelevisionDTO);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTelevision(@PathVariable Long id) {
        boolean isDeleted = televisionService.deleteTelevision(id);

        if (isDeleted == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Television met id " + id + " is niet gevonden");

        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Television is verwijderd");
        }
    }

}
