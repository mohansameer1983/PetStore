package com.pet.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.model.Pet;
import com.pet.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private PetRepository petRepository;


	@Autowired
	public void setPetRepository(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	/**
	 * Get pet by ID
	 * @param id
	 * 			Pet ID
	 * @return
	 * 			Pet
	 */
	@Override
	public Pet getPetById(Integer id) {
		logger.debug("getPetById called - "+ id);
		return petRepository.findOne(id);
	}

	/**
	 * Get pet by status
	 * @param status
	 * 		status
	 * @return
	 * 		Pet
	 */
	@Override
	public List<Pet> findPetByStatus(String status) {
		logger.debug("findPetByStatus called - "+ status);
		return petRepository.findByStatus(status);
	}


	/**
	 * Save pet in database
	 * @param pet
	 * 			Pet 
	 * @return
	 * 		Updated Pet
	 */
	@Override
	public Pet savePet(Pet pet) {
		logger.debug("savePet called - "+ pet);
		return petRepository.save(pet);
	}

	/**
	 * Delete Pet 
	 * @param petId
	 * 			Pet ID
	 */
	@Override
	public void deletePet(Integer petId) {
		logger.debug("deletePet called - "+ petId);
		petRepository.delete(petId);
	}

}
