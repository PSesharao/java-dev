package com.mindtree.service.impl;

import java.util.List;

import com.mindtree.dao.PlayerAuctionSystemDao;
import com.mindtree.dao.PlayerAuctionSystemDaoImpl;
import com.mindtree.entity.Player;
import com.mindtree.entity.Team;
import com.mindtree.exception.dao.PlayerAuctionDaoException;
import com.mindtree.exception.manager.DuplicateEntryException;
import com.mindtree.exception.manager.InvalidCategoryException;
import com.mindtree.exception.manager.InvalidTeamNameException;
import com.mindtree.exception.manager.NotABatsmanException;
import com.mindtree.exception.manager.NotABowlerException;
import com.mindtree.exception.manager.PlayerAuctionManagerException;
import com.mindtree.service.PlayerAuctionSystemManager;

public class PlayerAuctionSystemManagerImpl implements PlayerAuctionSystemManager {

	private static PlayerAuctionSystemDao dao = new PlayerAuctionSystemDaoImpl();

	@Override
	public boolean insertIntoPlayer(int id, String name, String categeory, int highestScore, String bestFigures)
			throws PlayerAuctionManagerException {

		if (categeory.compareToIgnoreCase("Batsman") != 0 && categeory.compareToIgnoreCase("Bowler") != 0
				&& categeory.compareToIgnoreCase("Allrounder") != 0)
			throw new InvalidCategoryException("Invalid category name please check your input");
		
		if(categeory.compareToIgnoreCase("Batsman")==0  )
		{
			if( !(highestScore>=50 && highestScore<=200))
				throw new NotABatsmanException("Invalid Batsman, please check your input");
		}
		
		if(categeory.compareToIgnoreCase("Bowler")==0)
		{
			if(bestFigures == null || highestScore<0)
				throw new NotABowlerException("Invalid Bowler, please check your input");
		}
		try {
			return dao.insertIntoPlayer(id, name, categeory, highestScore, bestFigures);
		} catch (PlayerAuctionDaoException e) {
			throw new PlayerAuctionManagerException("Player Details could not be inserted ", e);
		}
	}

	@Override
	public boolean insertIntoTeamPlayer(int teamId, int playerId) throws PlayerAuctionManagerException {

		try {
			return dao.insertIntoTeamPlayer(teamId, playerId);
		} catch (PlayerAuctionDaoException e) {
			throw new PlayerAuctionManagerException("TeamPlayer Details could not be inserted ", e);
			
		}
	}

	@Override
	public List<Player> getPlayersByTeam(String teamName) throws PlayerAuctionManagerException {

		try {
			return dao.getPlayersByTeam(teamName);
		} catch (PlayerAuctionDaoException e) {
			throw new PlayerAuctionManagerException("Exception while getting players",e);
		}
	}

	@Override
	public int findTeam(String teamName) throws PlayerAuctionManagerException {
		int index = -1;
		String teamList[] = { "CSK", "RCB", "MI", "RR", "SRH", "KKR" };
		for (int i = 0; i < teamList.length; i++) {
			if (teamList[i].compareTo(teamName) == 0) {
				index = i;
				break;
			}

		}
		if (index == -1)
			throw new InvalidTeamNameException("Invalid team name, please check your input");
		return index;
	}

	@Override
	public boolean lookForDupPlayer(String playerName, Team team) throws PlayerAuctionManagerException {
		for (Player player : team.getPlayerList()) {
			if (player.getName().compareTo(playerName) == 0)
				throw new DuplicateEntryException("Player details already exist in the database");
		}
		return false;
	}

}
