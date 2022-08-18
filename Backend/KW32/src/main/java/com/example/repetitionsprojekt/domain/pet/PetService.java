package com.example.repetitionsprojekt.domain.pet;

import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.List;

@Service
public class PetService {
    PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPet(Long id) throws InstanceNotFoundException {
        return petRepository.findById(id).orElseThrow(() -> new InstanceNotFoundException("Pet not found!"));
    }

    public Pet createPet(Pet pet) throws InstanceNotFoundException {
        if (petRepository.existsById(pet.getId())) {
            throw new InstanceNotFoundException("Id was already assigned to a different pet.");
        } else if (petRepository.existsById(pet.getId())) {
            throw new InstanceNotFoundException("Pet with ID already exists.");
        }
        return petRepository.save(pet);
    }

    public Pet updatePet(Long id, Pet newPet) throws InstanceNotFoundException {

        Pet pet = petRepository.findById(id).orElseThrow(() -> new InstanceNotFoundException("Pet not found."));
        pet.setName(newPet.getName());
        pet.setAge(newPet.getAge());
        pet.setBreed(newPet.getBreed());
        pet.setUrl(newPet.getUrl());
        pet.setGender(newPet.getGender());

        return petRepository.save(pet);
    }


    public String deletePet(Long id) throws InstanceNotFoundException {
        if (!petRepository.existsById(id)) {
            throw new InstanceNotFoundException("Pet not found.");
        }
        petRepository.deleteById(id);
        return "Pet deleted.";
    }
}
