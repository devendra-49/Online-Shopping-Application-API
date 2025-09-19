package edu.onlineshoppingapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.onlineshoppingapplication.entity.User;

public interface UserJPARepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findByName(String Name);
	public Optional<User> findByEmail(String Email);
	public Optional<User> findByEmailAndPassword(String email, String password);
	public Optional<User> findByEmailAndName(String email, String Name); 

}
