package com.persondemographic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.persondemographic.model.User;
import com.persondemographic.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired 
	UserRepository userRepository;
	
	@Override
	public void createUser(User user) {
		if(this.userRepository.findByPpsNumber(user.getPpsNumber())!=null)
			throw new DuplicateKeyException("PPS number already registered");
		this.userRepository.save(user);
	}

	@Override
	public List<User> listUsers() {
		return this.userRepository.findAllByOrderByCreationDateDesc();
	}

}
