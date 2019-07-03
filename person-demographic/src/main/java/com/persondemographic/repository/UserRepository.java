package com.persondemographic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persondemographic.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
    public List<User> findAllByOrderByCreationDateDesc();
    public User findByPpsNumber(String ppsNumber);

	
}