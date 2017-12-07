package com.disney.studios.service;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.disney.studios.Application;
import com.disney.studios.domain.Pet;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PetServiceTest {
	
	@Autowired
	PetService PetServiceImpl;
	
	@Test
	public void testFindAll() {
		Map<String, List<Pet>> allPets = PetServiceImpl.findAll();
		Assert.assertNotNull(allPets);
		Assert.assertTrue(allPets.keySet().size() > 0);
		Assert.assertTrue(allPets.values().size() > 0);
	}
	
	@Test
	public void testFindByBreed() {
		Assert.assertTrue(PetServiceImpl.findByBreed("Retriever").size() > 0);
		Assert.assertTrue(PetServiceImpl.findByBreed("Pug").size() > 0);
	}
	
	@Test
	public void testUpVote() {
		PetServiceImpl.upVote(1);
		Assert.assertEquals(PetServiceImpl.find(1).getFavoriteCount(), 1);
	}
	
	@Test
	public void testDownVote() {
		PetServiceImpl.downVote(2);
		Assert.assertEquals(PetServiceImpl.find(2).getFavoriteCount(), -1);
	}
}
