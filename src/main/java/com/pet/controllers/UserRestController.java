package com.pet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pet.model.User;
import com.pet.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user/")
@Api(value="user", description="Operations about user")
public class UserRestController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "View a list of available users",response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "Users not found")
	})
	@RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/xml")
	public Iterable<User> list(){
		return userService.listAllUsers();
	}

	@ApiOperation(value = "Get user by ID",response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "Invalid Id supplied"),
			@ApiResponse(code = 404, message = "User not found"),
	})
	@RequestMapping(value = "/{id}", method= RequestMethod.GET, produces = "application/json")
	public User getUserById(@PathVariable Integer id){
		return userService.getUserById(id);
	}

	@ApiOperation(value = "Get user by user name",response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "Invalid Id supplied"),
			@ApiResponse(code = 404, message = "User not found"),
	})
	@RequestMapping(value = "/findByUserName/{userName}", method= RequestMethod.GET, produces = "application/json")
	public User getUserByUserName(@PathVariable String userName){
		return userService.getUserByUserName(userName);
	}

	@ApiOperation(value = "Create user")
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveUser(@RequestBody User user){
		userService.saveUser(user);
		return new ResponseEntity("successful operation", HttpStatus.OK);
	}
	

    @ApiOperation(value = "Update a user")
    @RequestMapping(value = "/{userName}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateUser(@PathVariable String userName, @RequestBody User newUser){
    	User user = userService.getUserByUserName(userName);
    	user.setId(newUser.getId());
    	user.setEmail(newUser.getEmail());
    	user.setFirstName(newUser.getFirstName());
    	user.setLastName(newUser.getLastName());
    	user.setPassword(newUser.getPassword());
    	user.setPhone(newUser.getPhone());
    	user.setUserName(newUser.getUserName());
    	user.setUserStatus(newUser.getUserStatus());
        userService.saveUser(user);
        return new ResponseEntity("successful operation", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete user")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successful operation"),
			@ApiResponse(code = 400, message = "Invalid username supplied"),
			@ApiResponse(code = 404, message = "User not found"),
	})
    @RequestMapping(value="/{userName}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable String userName){
    	userService.deleteUser(userName);
        return new ResponseEntity("successful operation", HttpStatus.OK);

    }

}
