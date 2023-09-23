package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Syllabus;
import com.dev.delta.repositories.SyllabusRepository;

@Service
public class SyllabusService {
	/**
	 * syllabusRepository
	 */
	@Autowired
	private SyllabusRepository syllabusRepository;
	

	/**
	 * getSyllabuss
	 * @return
	 */
	public java.util.List<Syllabus> getSyllabuss()
	{
		return syllabusRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return syllabusRepository.count();
	}

	/**
	 * save
	 * @param syllabus
	 */
	public void save(Syllabus syllabus)
	{
		syllabusRepository.save(syllabus);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Syllabus> findById(Long id) {
		return syllabusRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		syllabusRepository.delete(syllabusRepository.findById(id).get());
	}
}
