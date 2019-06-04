package com.produce.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.produce.domain.User;

@Repository
public class UserRepository {

	public List<User> getAlltheUser() {
		List<User> users = new ArrayList<>();
		users.add(new User(1L, "Kelly"));
		users.add(new User(2L, "James"));
		users.add(new User(3L, "Kelly"));
		
		return users;
	}

	public User getById(Long id) {
		
		User user = getAlltheUser().stream()
				  .filter(usr -> id.equals(usr.getId()))
				  .findAny()
				  .orElse(null);
		return user;
	}

}
