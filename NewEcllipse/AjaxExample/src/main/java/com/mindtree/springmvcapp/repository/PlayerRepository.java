package com.mindtree.springmvcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.springmvcapp.entity.Player;


public interface PlayerRepository extends JpaRepository<Player, Long> {
		
	
}
