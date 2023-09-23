package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.User;
import com.dev.delta.repositories.UserRepository;

@Service
public class UserService {
	/**
	 * userRepository
	 */
	@Autowired
	private UserRepository userRepository;
	

	/**
	 * getUsers
	 * @return
	 */
	public java.util.List<User> getUsers()
	{
		return userRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return userRepository.count();
	}

	/**
	 * save
	 * @param user
	 */
	public void save(User user)
	{
		userRepository.save(user);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		userRepository.delete(userRepository.findById(id).get());
	}
}
