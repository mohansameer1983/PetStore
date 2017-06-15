package com.pet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pet.model.Pet;

@RepositoryRestResource
public interface PetRepository extends CrudRepository<Pet, Integer>{
	
	List<Pet> findByStatus(@Param("status") String status);
	
}