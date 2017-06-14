package com.pet.services;

import com.pet.model.User;

public interface UserService {

	/**
	 * List all users from pet store
	 * @return
	 */
	Iterable<User> listAllUsers();
	
	/**
	 * Get pet store user by ID
	 * @param id
	 * 			User ID
	 * @return
	 * 			User
	 */
	User getUserById(Integer id);
	
	/**
	 * Get pet store user by user name
	 * @param userName
	 * 		User Name
	 * @return
	 * 		User
	 */
	User getUserByUserName(String userName);
	
	/**
	 * Save user in database
	 * @param user
	 * 			Pet Store User
	 * @return
	 * 		Updated User
	 */
	User saveUser(User user);
	
	/**
	 * Delete Pet Store User
	 * @param userName
	 * 			User Name
	 */
	void deleteUser(String userName);
}
