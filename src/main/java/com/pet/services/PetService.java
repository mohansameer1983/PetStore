package com.pet.services;

import java.util.List;

import com.pet.model.Pet;

public interface PetService {

	
	/**
	 * Get pet by ID
	 * @param id
	 * 			Pet ID
	 * @return
	 * 			Pet
	 */
	Pet getPetById(Integer id);
	
	/**
	 * Get pet store Pet by status
	 * @param status
	 * 		status
	 * @return
	 * 		Pet
	 */
	List<Pet> findPetByStatus(String status);
	
	/**
	 * Save Pet in database
	 * @param Pet
	 * 			Pet
	 * @return
	 * 		Updated Pet
	 */
	Pet savePet(Pet Pet);
	
	/**
	 * Delete  Pet
	 * @param PetName
	 * 			Pet Name
	 */
	void deletePet(Integer id);
	
	
}
