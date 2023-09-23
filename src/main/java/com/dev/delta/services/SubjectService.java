package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Subject;
import com.dev.delta.repositories.SubjectRepository;

@Service
public class SubjectService {
	/**
	 * subjectRepository
	 */
	@Autowired
	private SubjectRepository subjectRepository;
	

	/**
	 * getSubjects
	 * @return
	 */
	public java.util.List<Subject> getSubjects()
	{
		return subjectRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return subjectRepository.count();
	}

	/**
	 * save
	 * @param subject
	 */
	public void save(Subject subject)
	{
		subjectRepository.save(subject);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Subject> findById(Long id) {
		return subjectRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		subjectRepository.delete(subjectRepository.findById(id).get());
	}
}
