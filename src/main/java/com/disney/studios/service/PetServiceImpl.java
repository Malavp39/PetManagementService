package com.disney.studios.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.disney.studios.dao.PetRepository;
import com.disney.studios.domain.Pet;
// Pet Service
@Component(value="petServiceImpl")
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;
    
	@Override
	public List<Pet> findByBreed(String breed) {
		return petRepository.findByBreed(breed);
	}

	@Override
	public Map<String, List<Pet>> findAll() {
		List<Pet> allPets = petRepository.findAll();
		Map<String, List<Pet>> allPetsByBreed = new HashMap<String, List<Pet>>();
		for(Pet pet : allPets) {
			List<Pet> breedGroup = allPetsByBreed.get(pet.getBreed());
			if(breedGroup==null) {
				breedGroup = new ArrayList<Pet>();
				allPetsByBreed.put(pet.getBreed(), breedGroup);
			}
			breedGroup.add(pet);
		}
		return allPetsByBreed;
	}

	private void findAndVote(long id, int vote) {
		Pet pet = find(id);
		// TODO; Duplicate vote check; Expect client id and validated against all voted client id list of Pet
		pet.setFavoriteCount(pet.getFavoriteCount()+vote);
		petRepository.save(pet);
		
	}
	
	@Override
	public void upVote(long id) {
		findAndVote(id, 1);
		
	}

	@Override
	public void downVote(long id) {
		findAndVote(id, -1);
		
	}

	@Override
	public Pet find(long id) {
		return petRepository.findOne(id);
		
	}

}
