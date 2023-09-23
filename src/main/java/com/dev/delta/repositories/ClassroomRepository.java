package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>{

}
