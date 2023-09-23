package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.entities.Subject;

public interface SubjectRepository extends  JpaRepository<Subject, Long> {

}
