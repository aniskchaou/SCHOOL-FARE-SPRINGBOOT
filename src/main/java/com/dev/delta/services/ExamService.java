package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Exam;
import com.dev.delta.repositories.ExamRepository;
@Service
public class ExamService {
	/**
	 * examRepository
	 */
	@Autowired
	private ExamRepository examRepository;
	

	/**
	 * getExams
	 * @return
	 */
	public java.util.List<Exam> getExams()
	{
		return examRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return examRepository.count();
	}

	/**
	 * save
	 * @param exam
	 */
	public void save(Exam exam)
	{
		examRepository.save(exam);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<Exam> findById(Long id) {
		return examRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		examRepository.delete(examRepository.findById(id).get());
	}
}
