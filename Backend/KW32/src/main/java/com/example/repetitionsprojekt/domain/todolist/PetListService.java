package com.example.repetitionsprojekt.domain.todolist;

import org.springframework.stereotype.Service;

@Service
public class PetListService {
    PetRepository petRepository;

    public PetListService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
}
