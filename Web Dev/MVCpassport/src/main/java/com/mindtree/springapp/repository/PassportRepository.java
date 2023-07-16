package com.mindtree.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springapp.entity.Passport;
@Repository
public interface PassportRepository extends JpaRepository<Passport, String> {

}
