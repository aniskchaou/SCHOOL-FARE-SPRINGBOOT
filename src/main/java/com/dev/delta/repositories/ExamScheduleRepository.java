package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.ExamSchedule;

public interface ExamScheduleRepository extends JpaRepository<ExamSchedule, Long> {

}
