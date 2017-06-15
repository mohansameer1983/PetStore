package com.pet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pet.model.UserAuth;

@RepositoryRestResource
public interface UserAuthRepository extends CrudRepository<UserAuth, String>{
	
}