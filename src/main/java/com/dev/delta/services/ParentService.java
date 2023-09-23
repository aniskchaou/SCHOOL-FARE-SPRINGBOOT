package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Parent;
import com.dev.delta.repositories.ParentRepository;

@Service
public class ParentService {
	/**
	 * parentRepository
	 */
	@Autowired
	private ParentRepository parentRepository;
	

	/**
	 * getParents
	 * @return
	 */
	public java.util.List<Parent> getParents()
	{
		return parentRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return parentRepository.count();
	}

	/**
	 * save
	 * @param parent
	 */
	public void save(Parent parent)
	{
		parentRepository.save(parent);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Parent> findById(Long id) {
		return parentRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		parentRepository.delete(parentRepository.findById(id).get());
	}
}
