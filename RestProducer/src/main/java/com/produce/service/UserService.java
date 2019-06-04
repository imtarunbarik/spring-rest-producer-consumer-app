package com.produce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produce.domain.User;
import com.produce.dto.UserDTO;
import com.produce.repository.impl.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> getAlltheUser(){
		 List<User> users = userRepository.getAlltheUser();
        return users.stream()
                .map(usr -> convertToDto(usr))
                .collect(Collectors.toList());
	}

	public UserDTO getUser(Long id) {
        return convertToDto(userRepository.getById(id));
    }
	
	private UserDTO convertToDto(User userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId().toString());
		userDTO.setName(userEntity.getName());
	    return userDTO;
	}
}
