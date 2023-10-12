package com.crud.service;

import java.util.List;

import org.hibernate.procedure.NoSuchParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.SignUp;
import com.crud.repository.SignUpRepository;

@Service
public class SignUpService {

	@Autowired
	SignUpRepository signuprepo;
	
	public List<SignUp> getAll(){
		return signuprepo.findAll();
	}
	
	public SignUp get(int id) {
		return signuprepo.findById(id).get();
	}
	
	public SignUp create(SignUp signup) {
		return signuprepo.save(signup);
	}
	
	public void delete() {
		signuprepo.deleteAll();
	}
	
	public void deleteId(int id) {
		signuprepo.deleteById(id);
	}
	
	public SignUp update(int id,SignUp signup) {
		SignUp updatedb = signuprepo.findById(id).orElseThrow(() -> new NoSuchParameterException("Id you are given is not found"));
		
		updatedb.setName(signup.getName());
		updatedb.setEmail(signup.getEmail());
		updatedb.setPassword(signup.getPassword());
		updatedb.setConfirmPassword(signup.getConfirmPassword());
	
		return signuprepo.save(updatedb);
	}
	
	
	
}
