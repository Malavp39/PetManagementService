package com.disney.studios.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.disney.studios.domain.Pet;
import com.disney.studios.service.PetService;
// Pet Rest API
@RestController
public class PetRestController {
	
	@Autowired
	PetService petServiceImpl;
	
	/**
	 * API to get All Pets Grouped by Breed
	 * @return Pets Grouped by Breed
	 */
	@RequestMapping(value="/pets", method = RequestMethod.GET)
	Map<String, List<Pet>> findAll() {
		return petServiceImpl.findAll();
	}

	/**
	 * API to get A Pet by id
	 * @return Pet
	 */
	@RequestMapping(value="/pets/{petId}", method = RequestMethod.GET)
	Pet find(@PathVariable long petId) {
		return petServiceImpl.find(petId);
	}
	
	/**
	 * API to get All Pets of a specific breed
	 * @return Pets of breed requested
	 */
	@RequestMapping(value="/pets/breed/{breed}", method = RequestMethod.GET)
	List<Pet> findByBreed(@PathVariable String breed) {
		return petServiceImpl.findByBreed(breed);
	}
	
	/**
	 * API to upVote A Pet
	 * @return OK/Failure
	 */
	@RequestMapping(value="/pets/{petId}/upVote", method = RequestMethod.POST)
	void upVote(@PathVariable long petId) {
		petServiceImpl.upVote(petId);
	}
	
	/**
	 * API to downVote A Pet
	 * @return OK/Failure
	 */
	@RequestMapping(value="/pets/{petId}/downVote", method = RequestMethod.POST)
	void downVote(@PathVariable long petId) {
		petServiceImpl.downVote(petId);
	}
	
}
