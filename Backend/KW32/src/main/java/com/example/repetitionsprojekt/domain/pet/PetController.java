package com.example.repetitionsprojekt.domain.pet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> getAllSuppliers() {
        return ResponseEntity.ok().body(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable("id") long id) throws InstanceNotFoundException {
        return ResponseEntity.ok()
                .body(petService.getPet(id));
    }

    @PostMapping({"/"})
    public ResponseEntity<Pet> createSupplier( @RequestBody Pet pet) throws InstanceNotFoundException {
        return ResponseEntity.ok().body(petService.createPet(pet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updateSupplier(@PathVariable("id") Long id, @RequestBody Pet pet) throws InstanceNotFoundException {
        return ResponseEntity.ok().body(petService.updatePet(id, pet));
    }

    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable("id") Long id) throws InstanceNotFoundException {
        return petService.deletePet(id);
    }

    @ExceptionHandler(InstanceNotFoundException.class)
    public ResponseEntity<String> exceptionHandler(InstanceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}