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
import net.javaguides.springboot.model.Files;
import net.javaguides.springboot.repository.FileRegisterRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class FileRegisterController {

	@Autowired
	private FileRegisterRepository fileRegisterRepository;
	

	// create user rest api
	@PostMapping("/fileRegister")
	public Files createFileRegistery(@RequestBody Files users) {
		return fileRegisterRepository.save(users);
	}
	
	// get user by id rest api
	@GetMapping("/fileRegister/{id}")
	public ResponseEntity<Files> getUserById(@PathVariable Long id) {
		Files user = fileRegisterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("File not exist with id :" + id));
		return ResponseEntity.ok(user);
	}
	
	// update user rest api
	
	@PutMapping("/fileRegister/{id}")
	public ResponseEntity<Files> updateUser(@PathVariable Long id, @RequestBody Files userDetails){
		Files files = fileRegisterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("File not exist with id :" + id));
		
		files.setEmailId(userDetails.getEmailId());
		files.setDescr(userDetails.getDesct());
		files.setFileName(userDetails.getFileName());
	
		Files updatedUsers = fileRegisterRepository.save(files);
		return ResponseEntity.ok(updatedUsers);
	}
	
	// delete user rest api
	@DeleteMapping("/fileRegister/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		Files user = fileRegisterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("File not exist with id :" + id));
		
		fileRegisterRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}		
}
