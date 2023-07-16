package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Player;
import com.mindtree.entity.Team;
import com.mindtree.exception.manager.PlayerAuctionManagerException;

public interface PlayerAuctionSystemManager {
	boolean insertIntoPlayer(int id, String name, String categeory, int highestScore, String bestFigures)
			throws PlayerAuctionManagerException;
	
	boolean insertIntoTeamPlayer(int teamId , int playerId) throws PlayerAuctionManagerException;
	
	List<Player> getPlayersByTeam(String teamName) throws PlayerAuctionManagerException;
	
	int findTeam(String teamName) throws PlayerAuctionManagerException;
	
	boolean lookForDupPlayer(String playerName , Team team) throws PlayerAuctionManagerException;
	
}
