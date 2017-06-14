package com.pet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pet.model.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Integer>{
	
	User findByUserName(@Param("userName") String userName);
	
	void deleteUserByUserName(@Param("userName") String userName);
}