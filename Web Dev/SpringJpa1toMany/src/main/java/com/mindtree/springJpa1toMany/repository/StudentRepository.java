package com.mindtree.springJpa1toMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springJpa1toMany.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
