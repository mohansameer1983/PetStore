package com.pet.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.model.User;
import com.pet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserRepository userRepository;


	@Autowired
	public void setProductRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * List all users from pet store
	 * @return
	 */
	@Override
	public Iterable<User> listAllUsers() {
		logger.debug("listAllUsers called");
		return userRepository.findAll();
	}

	/**
	 * Get pet store user by ID
	 * @param id
	 * 			User ID
	 * @return
	 * 			User
	 */
	@Override
	public User getUserById(Integer id) {
		logger.debug("getUserById called - "+ id);
		return userRepository.findOne(id);
	}

	/**
	 * Get pet store user by user name
	 * @param userName
	 * 		User Name
	 * @return
	 * 		User
	 */
	@Override
	public User getUserByUserName(String userName) {
		logger.debug("getUserByUserName called - "+ userName);
		return userRepository.findByUserName(userName);
	}


	/**
	 * Save user in database
	 * @param user
	 * 			Pet Store User
	 * @return
	 * 		Updated User
	 */
	@Override
	public User saveUser(User user) {
		logger.debug("saveUser called - "+ user);
		return userRepository.save(user);
	}

	/**
	 * Delete Pet Store User
	 * @param userName
	 * 			User Name
	 */
	@Override
	public void deleteUser(String userName) {
		logger.debug("deleteUser called - "+ userName);
		userRepository.deleteUserByUserName(userName);
	}

}
