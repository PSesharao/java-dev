package com.mindtree.springJpaManytoMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springJpaManytoMany.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
