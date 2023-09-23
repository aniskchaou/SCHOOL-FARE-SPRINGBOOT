package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Assignement;
import com.dev.delta.repositories.AssignementRepository;

@Service
public class AssignementService {
	/**
	 * assignementRepository
	 */
	@Autowired
	private AssignementRepository assignementRepository;
	

	/**
	 * getAssignements
	 * @return
	 */
	public java.util.List<Assignement> getAssignements()
	{
		return assignementRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return assignementRepository.count();
	}

	/**
	 * save
	 * @param assignement
	 */
	public void save(Assignement assignement)
	{
		assignementRepository.save(assignement);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Assignement> findById(Long id) {
		return assignementRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		assignementRepository.delete(assignementRepository.findById(id).get());
	}
}
