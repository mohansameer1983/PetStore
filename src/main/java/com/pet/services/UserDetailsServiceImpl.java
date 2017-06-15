package com.pet.services;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pet.model.UserAuth;
import com.pet.repository.UserAuthRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserAuthRepository userAuthRepository;
	
	/**
	 * Get User Auth Details by user name
	 * @param userName
	 * 		User Name
	 * @return
	 * 		UserAuth
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		logger.debug("getUserByUserName called - "+ userName);
		UserAuth userAuth = userAuthRepository.findOne(userName);

		if (userAuth == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}

		return new User(userName, userAuth.getPassword(), true, true, true,
				true, AuthorityUtils.createAuthorityList(userAuth.getRole()));
	}

	/**
	 * Add users at startup for testing
	 */
	@PostConstruct
	public void loadUsers() {
		List<UserAuth> userAuthList = Arrays.asList(
							new UserAuth("user", "password", "USER"),
							new UserAuth("admin", "password", "ADMIN"));
		userAuthRepository.save(userAuthList);
	}

}
