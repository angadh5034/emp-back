package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;
@Repository
public interface Userrepository extends JpaRepository<User,Integer>{
	
	public User findByUsername(String username);

}
