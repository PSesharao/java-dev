package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Player;
import com.mindtree.exception.dao.PlayerAuctionDaoException;

public interface PlayerAuctionSystemDao {
	boolean insertIntoPlayer(int id, String name, String categeory, int highestScore, String bestFigures)
	throws PlayerAuctionDaoException;
	
	boolean insertIntoPlayer(int teamId , int playerId) throws PlayerAuctionDaoException;
	
	List<Player> getPlayersByTeam(String teamName) throws PlayerAuctionDaoException;
}
