package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
