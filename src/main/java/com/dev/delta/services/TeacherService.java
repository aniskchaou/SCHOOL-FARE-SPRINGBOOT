package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Teacher;
import com.dev.delta.repositories.TeacherRepository;

@Service
public class TeacherService {
	/**
	 * teacherRepository
	 */
	@Autowired
	private TeacherRepository teacherRepository;
	

	/**
	 * getTeachers
	 * @return
	 */
	public java.util.List<Teacher> getTeachers()
	{
		return teacherRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return teacherRepository.count();
	}

	/**
	 * save
	 * @param teacher
	 */
	public void save(Teacher teacher)
	{
		teacherRepository.save(teacher);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Teacher> findById(Long id) {
		return teacherRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		teacherRepository.delete(teacherRepository.findById(id).get());
	}
}
