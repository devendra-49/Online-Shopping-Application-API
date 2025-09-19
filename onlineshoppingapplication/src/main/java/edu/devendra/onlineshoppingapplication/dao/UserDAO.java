package edu.devendra.onlineshoppingapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.devendra.onlineshoppingapplication.entity.User;
import edu.devendra.onlineshoppingapplication.exception.NoDataExist;
import edu.devendra.onlineshoppingapplication.exception.UserNotFoundException;
import edu.devendra.onlineshoppingapplication.repository.UserJPARepository;

@Repository
public class UserDAO {

	@Autowired
	private UserJPARepository ujpa;
	
	public String addUser(User users) {
		ujpa.save(users);
		return "User Added...";
	}
	
	public List<User> findAll(){
		List<User> li = ujpa.findAll();
		if(li.isEmpty()) {
			throw new NoDataExist();
		}
		return li;
	}
	
	public Optional<User> findUsingId(int id) {
		 Optional<User> obj = ujpa.findById(id);
		 if(obj.isPresent()) {
			return obj;
		 }
		 else {
			 throw new UserNotFoundException();
		 }
	}
	
	public Optional<User> findUsingName(String name){
		return ujpa.findByName(name);
	}
	
	public void deleteUsingId(int id){
		 ujpa.deleteById(id);
	}
	
//	public Optional<User> updateUsingId(int id, User users){
//	 Optional<User> lastUpdatedUser = ujpa.findById(id);
//	 if(lastUpdatedUser.isPresent()) {
//		 Optional<User> updatedUser = 
//		 lastUpdatedUser.setName(users);
//		 lastUpdatedUser.setEmail("dd");
//		 lastUpdatedUser.setPassword("fsd");
//		 lastUpdatedUser.setRole("sf");
//		 return updatedUser;
//	 }
//	 else {
//		 throw new RuntimeException("User not fount with id "+id );
//	 }
//	 
//	 
//  }
	
	public User updateUsingId(int id, User users) {
	    Optional<User> optionalUser = ujpa.findById(id);

	    if (optionalUser.isPresent()) {
	        User existingUser = optionalUser.get();

	        if (users.getName() != null && !users.getName().isEmpty()) {
	            existingUser.setName(users.getName());
	        }
	        else if (users.getEmail() != null && !users.getEmail().isEmpty()) {
	            existingUser.setEmail(users.getEmail());
	        }
	        else if (users.getPassword() != null && !users.getPassword().isEmpty()) {
	            existingUser.setPassword(users.getPassword());
	        }
	        else if (users.getRole() != null && !users.getRole().isEmpty()) {
	            existingUser.setRole(users.getRole());
	        }
	        return ujpa.save(existingUser);
	    } else {
	        throw new RuntimeException("User not found with id " + id);
	    }
	}
}
