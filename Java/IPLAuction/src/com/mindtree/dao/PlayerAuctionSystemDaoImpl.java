package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Player;
import com.mindtree.exception.dao.PlayerAuctionDaoException;

public class PlayerAuctionSystemDaoImpl implements PlayerAuctionSystemDao {

	@Override
	public boolean insertIntoPlayer(int id, String name, String categeory, int highestScore, String bestFigures)
			throws PlayerAuctionDaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertIntoTeamPlayer(int teamId, int playerId) throws PlayerAuctionDaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Player> getPlayersByTeam(String teamName) throws PlayerAuctionDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
