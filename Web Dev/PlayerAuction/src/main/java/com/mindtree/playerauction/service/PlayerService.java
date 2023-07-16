package com.mindtree.playerauction.service;

import java.util.List;

import com.mindtree.playerauction.dto.PlayerDto;
import com.mindtree.playerauction.entity.Player;
import com.mindtree.playerauction.exception.service.PlayerServiceException;

public interface PlayerService {
	 Player createPlayer(PlayerDto playerDto , String teamName) throws PlayerServiceException;
	
	 int getTotalPriceOfPlayers(List<Player> playerList) throws PlayerServiceException;
	 
	 int getNoOfPlayersOnSkill(List<Player> playerList , String skill)  throws PlayerServiceException;
	 
	Player getPlayerById(long playerId)  throws PlayerServiceException;
	
	Player updatePlayer(long playerId , PlayerDto playerDto) throws PlayerServiceException ;
	
	List<Player> sortPlayersOnPrice(List<Player> playerList) throws PlayerServiceException;
}
