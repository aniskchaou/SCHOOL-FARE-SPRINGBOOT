package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}
