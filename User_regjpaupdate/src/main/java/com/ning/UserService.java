package com.ning;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<ResUser> listAll() {
		return repo.findAll();
	}
	
	public void save(ResUser user) {
		repo.save(user);
	}
	
	public ResUser get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	
	
}
