package com.disney.studios.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disney.studios.domain.Pet;

//Pet Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByBreed(String breed);
}
