package com.mindtree.playerauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.playerauction.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
		
	
}
