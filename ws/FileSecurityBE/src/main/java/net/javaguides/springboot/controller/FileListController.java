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
public class FileListController {

	@Autowired
	private FileRegisterRepository fileRegisterRepository;
	
	// get all employees
	@GetMapping("/filesList")
	public List<Files> getAllFiles(){
		return fileRegisterRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/filesList")
	public Files createEmployee(@RequestBody Files employee) {
		return fileRegisterRepository.save(employee);
	}
	
	// get employee by id rest api
	@GetMapping("/filesList/{id}")
	public ResponseEntity<Files> getFileById(@PathVariable Long id) {
		Files employee = fileRegisterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("File not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	
	// update employee rest api	
	@PutMapping("/filesList/{id}")
	public ResponseEntity<Files> updateFile(@PathVariable Long id, @RequestBody Files fileDetails){
		Files file = fileRegisterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("File not exist with id :" + id));
		
		file.setId(fileDetails.getId());
		file.setEmailId(fileDetails.getEmailId());
		file.setDescr(fileDetails.getDesct());
		file.setFileName(fileDetails.getFileName());
		
		
		Files updatedFiles = fileRegisterRepository.save(file);
		return ResponseEntity.ok(updatedFiles);
	}
	
	// delete employee rest api
	@DeleteMapping("/filesList/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteFile(@PathVariable Long id){
		Files files = fileRegisterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("File not exist with id :" + id));
		
		fileRegisterRepository.delete(files);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
