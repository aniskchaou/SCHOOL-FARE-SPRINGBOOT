package com.dev.delta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.ExamSchedule;
import com.dev.delta.repositories.ExamScheduleRepository;

@Service
public class ExamScheduleService {
	/**
	 * examScheduleRepository
	 */
	@Autowired
	private ExamScheduleRepository examScheduleRepository;
	

	/**
	 * getExamSchedules
	 * @return
	 */
	public java.util.List<ExamSchedule> getExamSchedules()
	{
		return examScheduleRepository.findAll();
	}
	
	/**
	 * getCount
	 * @return
	 */
	public long getCount()
	{
		return examScheduleRepository.count();
	}

	/**
	 * save
	 * @param examSchedule
	 */
	public void save(ExamSchedule examSchedule)
	{
		examScheduleRepository.save(examSchedule);
	}

    /**
     * findById
     * @param id
     * @return
     */
	public Optional<ExamSchedule> findById(Long id) {
		return examScheduleRepository.findById(id);
	}

	/**
	 * delete
	 * @param id
	 */
	public void delete(Long id) {
		examScheduleRepository.delete(examScheduleRepository.findById(id).get());
	}
}
