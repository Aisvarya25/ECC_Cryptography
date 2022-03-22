package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Users;
import net.javaguides.springboot.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class RegisterController {

	@Autowired
	private UserRepository userRepository;
	
	// get all users
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}		
	
	// create user rest api
	@PostMapping("/users")
	public Users createUser(@RequestBody Users users) {
		return userRepository.save(users);
	}
	
	// get user by id rest api
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable Long id) {
		Users user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(user);
	}
	
	// update user rest api
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users userDetails){
		Users users = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		users.setEmailId(userDetails.getEmailId());
		users.setPwd(userDetails.getPwd());
		users.setFirstName(userDetails.getFirstName());
		users.setLastName(userDetails.getLastName());
		users.setPhone(userDetails.getPhone());
		
		Users updatedUsers = userRepository.save(users);
		return ResponseEntity.ok(updatedUsers);
	}
	
	// delete user rest api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		Users user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
