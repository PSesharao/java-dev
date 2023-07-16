package com.mindtree.springJpaManytoMany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springJpaManytoMany.entity.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
		List<Subject> findAllByName(String subjectName);
}
