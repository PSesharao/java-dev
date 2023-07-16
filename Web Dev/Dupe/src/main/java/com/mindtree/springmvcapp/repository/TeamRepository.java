package com.mindtree.springmvcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.springmvcapp.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	
	public Team findByName(String teamName);

}
