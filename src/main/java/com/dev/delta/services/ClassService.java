package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Class;
import com.dev.delta.repositories.ClassRepository;

@Service
public class ClassService {
	/**
	 * classRepository
	 */
	@Autowired
	private ClassRepository classRepository;
	

	/**
	 * getClasss
	 * @return
	 */
	public java.util.List<Class> getClasss()
	{
		return classRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return classRepository.count();
	}

	/**
	 * save
	 * @param class
	 */
	public void save(Class classs)
	{
		classRepository.save(classs);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Class> findById(Long id) {
		return classRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		classRepository.delete(classRepository.findById(id).get());
	}
}
