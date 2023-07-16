package com.mindtree.springmvcapp.service;

import java.util.List;

import com.mindtree.springmvcapp.dto.PlayerDto;
import com.mindtree.springmvcapp.entity.Player;

public interface PlayerService {
	 Player createPlayer(PlayerDto playerDto , String teamName) ;
	
	 int getTotalPriceOfPlayers(List<Player> playerList) ;
	 
	 int getNoOfPlayersOnSkill(List<Player> playerList , String skill) ;
	 
	Player getPlayerById(long playerId) ;
	
	Player updatePlayer(long playerId , PlayerDto playerDto);
	
	List<Player> sortPlayersOnPrice(List<Player> playerList) ;
}
