package com.disney.studios.service;

import java.util.List;
import java.util.Map;

import com.disney.studios.domain.Pet;

public interface PetService {

	public List<Pet> findByBreed(String breed);
	public Map<String, List<Pet>> findAll();
	public void upVote(long id);
	public void downVote(long id);
	public Pet find(long id);
}
