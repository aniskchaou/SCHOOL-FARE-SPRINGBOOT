package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Classroom;
import com.dev.delta.repositories.ClassroomRepository;

@Service
public class ClassroomService {
	/**
	 * classroomRepository
	 */
	@Autowired
	private ClassroomRepository classroomRepository;
	

	/**
	 * getClassrooms
	 * @return
	 */
	public java.util.List<Classroom> getClassrooms()
	{
		return classroomRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return classroomRepository.count();
	}

	/**
	 * save
	 * @param classroom
	 */
	public void save(Classroom classroom)
	{
		classroomRepository.save(classroom);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Classroom> findById(Long id) {
		return classroomRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		classroomRepository.delete(classroomRepository.findById(id).get());
	}
}
