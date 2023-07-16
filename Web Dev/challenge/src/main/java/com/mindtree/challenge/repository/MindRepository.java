package com.mindtree.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.challenge.entity.Mind;

public interface MindRepository extends JpaRepository<Mind, Integer> {

}
