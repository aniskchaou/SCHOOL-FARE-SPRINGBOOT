package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.ClassRoutine;
import com.dev.delta.repositories.ClassRoutineRepository;

@Service
public class ClassRoutineService {
	/**
	 * classRoutineRepository
	 */
	@Autowired
	private ClassRoutineRepository classRoutineRepository;
	

	/**
	 * getClassRoutines
	 * @return
	 */
	public java.util.List<ClassRoutine> getClassRoutines()
	{
		return classRoutineRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return classRoutineRepository.count();
	}

	/**
	 * save
	 * @param classRoutine
	 */
	public void save(ClassRoutine classRoutine)
	{
		classRoutineRepository.save(classRoutine);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<ClassRoutine> findById(Long id) {
		return classRoutineRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		classRoutineRepository.delete(classRoutineRepository.findById(id).get());
	}
}
