package com.example.Thomas_Dohle_JPA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import com.example.Thomas_Dohle_JPA.model.User;
import com.example.Thomas_Dohle_JPA.repositories.UserRepository;

@CrossOrigin(allowCredentials="true")
@RestController
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	/**
	 * Register a new user
	 * @param user
	 * @param session
	 * @return
	 */

	@PostMapping("/api/register")
	public User register (@RequestBody User user,
			HttpSession session) {
		System.out.println("User sent to register: " + user.toString());
		userRepository.save(user);
		session.setAttribute("currentUser", user);
		boolean current = session.getAttribute("currentUser")==null;
		System.out.println("currentUser? " + current);
		if (! current) {
			System.out.println("Current user in register is: " + session.getAttribute("currentUser").toString());
		}
		return user;
	}
	
	@PostMapping("/api/login")
	public User login(	@RequestBody User credentials,
	HttpSession session) {
		System.out.println("attempting to log in user with un: " +credentials.getUsername() + " and pw: " + credentials.getPassword());
		List<User> users = (List<User>) userRepository.findAll();
		for (User user : users) {
			if( user.getUsername().equals(credentials.getUsername())
					&& user.getPassword().equals(credentials.getPassword())) {
			    session.setAttribute("currentUser", user);
			    System.out.println("Successfully logged in user " + session.getAttribute("currentUser").toString());
			    return user;
			  }
	 }
	 System.out.println("could not find user");
	 return null;
	}

	
	
	/**
	 * Return the currently logged in user
	 * @param session
	 * @return
	 */
	@PostMapping("/api/profile")
	public User profile(HttpSession session) {
		User currentUser = (User)session.getAttribute("currentUser");
		boolean current = session.getAttribute("currentUser") ==null;
		System.out.println(current);
		if (!current) {
			System.out.println("From profile: current user is " + session.getAttribute("currentUser"));
		}
		if (currentUser == null) {
			System.out.println("From profile: Current user is null");
			return null;
		}
		return currentUser;
	}
	
	@PostMapping("/api/logout")
	public void logout (HttpSession session) {
		System.out.println("User logged out");
		session.invalidate();
	}

	/**
	 * Handles GET request to return all User
	 * @return JSON containing all users stored on the server
	 */
	@GetMapping("/api/user")
	@CrossOrigin
	public List<User> findAllUser() {
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}
	

	
	/**
	 * Handles GET request to return a specific user
	 * @param id is the unique userId
	 * @return the user with the given ID
	 */
	@GetMapping("/api/user/{userId}")
	public User findUserById(
			@PathVariable("userId") Integer id) {
		User user = (User)userRepository.findById(id).get();
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}
}
