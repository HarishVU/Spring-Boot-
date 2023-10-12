package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.crud.entity.SignUp;
import com.crud.service.SignUpService;

@RestController
public class SignUpController {

	@Autowired
	SignUpService signupserv;
	
	@PostMapping("/created")
	private SignUp createUsers(@RequestBody SignUp signUp) {
		return signupserv.create(signUp);
	}
	
	@GetMapping("/get/{id}")
	private SignUp getById(@PathVariable ("id") int id) {
		return signupserv.get(id);
	}
	
	@GetMapping("/getAll")
	private List<SignUp> getAllUsers(){
		return signupserv.getAll();
	}
	
	@DeleteMapping("/deleteAll")
	private String deleteAll() {
		signupserv.delete();
		return "deleted successfully";
	}
	
	@DeleteMapping("/deleteById/{id}")
	private String deleteById(@PathVariable ("id") int id) {
		signupserv.deleteId(id);
		return "deleted upon id successfully";
	}
	
	@PutMapping("/update/{id}")
	private SignUp updates(@PathVariable ("id") int id, @RequestBody SignUp Up) {
		signupserv.update(id, Up);
		return Up;
	}
}
