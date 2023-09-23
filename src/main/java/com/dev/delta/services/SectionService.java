package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Section;
import com.dev.delta.repositories.SectionRepository;

@Service
public class SectionService {
	/**
	 * sectionRepository
	 */
	@Autowired
	private SectionRepository sectionRepository;
	

	/**
	 * getSections
	 * @return
	 */
	public java.util.List<Section> getSections()
	{
		return sectionRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return sectionRepository.count();
	}

	/**
	 * save
	 * @param section
	 */
	public void save(Section section)
	{
		sectionRepository.save(section);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Section> findById(Long id) {
		return sectionRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		sectionRepository.delete(sectionRepository.findById(id).get());
	}
}
