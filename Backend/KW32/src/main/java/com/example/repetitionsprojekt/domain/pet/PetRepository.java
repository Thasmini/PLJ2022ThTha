package com.example.repetitionsprojekt.domain.pet;

import com.example.repetitionsprojekt.domain.pet.Pet;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    boolean existsById(String id);

    Pet findById(@NotNull String id);

}
