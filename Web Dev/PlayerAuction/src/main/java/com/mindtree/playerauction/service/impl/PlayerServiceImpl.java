package com.mindtree.playerauction.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.playerauction.converter.PlayerConverter;
import com.mindtree.playerauction.dto.PlayerDto;
import com.mindtree.playerauction.entity.Player;
import com.mindtree.playerauction.entity.Team;
import com.mindtree.playerauction.exception.PlayerException;
import com.mindtree.playerauction.exception.dao.BatsmanExceedException;
import com.mindtree.playerauction.exception.dao.TeamBudgetExceedException;
import com.mindtree.playerauction.exception.service.PlayerServiceException;
import com.mindtree.playerauction.exception.service.TeamServiceException;
import com.mindtree.playerauction.repository.PlayerRepository;
import com.mindtree.playerauction.service.PlayerService;
import com.mindtree.playerauction.service.TeamService;

class SortDescending implements Comparator<Player> {

	@Override
	public int compare(Player player1, Player player2) {
		return (player2.getPurchasePrice() - player1.getPurchasePrice());
	}

}

@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private TeamService teamService;

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private PlayerConverter playerConverter;

	@Override
	public Player createPlayer(PlayerDto playerDto, String teamName) throws PlayerServiceException {
		Team team = null;
		try {
			team = teamService.getTeamByName(teamName);
		} catch (TeamServiceException e) {

			throw new PlayerServiceException(e.getLocalizedMessage());
		}

		if (team.getPlayerList().size() + 1 > 5)
			try {
				throw new PlayerException("Players exceeded more than 5 for team " + team.getName());
			} catch (PlayerException e1) {
				throw new PlayerServiceException(e1.getLocalizedMessage());
			}

		if (getTotalPriceOfPlayers(team.getPlayerList()) + playerDto.getPurchasePrice() > team.getMaxBudget()) {
			try {
				throw new TeamBudgetExceedException("Team budget exceeded more than " + team.getMaxBudget());
			} catch (TeamBudgetExceedException e) {

				throw new PlayerServiceException(e.getLocalizedMessage());
			}
		}

		if (playerDto.getSkill().equals("batsman")) {
			if (getNoOfPlayersOnSkill(team.getPlayerList(), "batsman") + 1 > 2)
				try {
					throw new BatsmanExceedException("Batsman Exceeded more than 2 for team " + team.getName());
				} catch (BatsmanExceedException e) {
					throw new PlayerServiceException(e.getLocalizedMessage());
				}
		}

		if (playerDto.getSkill().equals("bowler")) {
			if (getNoOfPlayersOnSkill(team.getPlayerList(), "bowler") + 1 > 2)
				try {
					throw new BatsmanExceedException("Bowlers Exceeded more than 2 for team " + team.getName());
				} catch (BatsmanExceedException e) {
					throw new PlayerServiceException(e.getLocalizedMessage());
				}
		}

		if (playerDto.getSkill().equals("allrounder")) {
			if (getNoOfPlayersOnSkill(team.getPlayerList(), "allrounder") + 1 > 3)
				try {
					throw new BatsmanExceedException("Allrounders Exceeded more than 3 for team " + team.getName());
				} catch (BatsmanExceedException e) {
					throw new PlayerServiceException(e.getLocalizedMessage());
				}
		}

		Player player = playerConverter.dtoToEntity(playerDto);
		player.setTeam(team);
		team.getPlayerList().add(player);

		return playerRepository.save(player);
	}

	@Override
	public int getTotalPriceOfPlayers(List<Player> playerList) throws PlayerServiceException {

		Integer totalPrice = playerList.stream().mapToInt(x -> x.getPurchasePrice()).sum();
		return totalPrice;
	}

	@Override
	public int getNoOfPlayersOnSkill(List<Player> playerList, String skill) throws PlayerServiceException {

		return (int) playerList.stream().filter(player -> player.getSkill().equals(skill)).count();
	}

	@Override
	public Player getPlayerById(long playerId) throws PlayerServiceException {

		return playerRepository.findById(playerId).orElse(null);
	}

	@Override
	public Player updatePlayer(long playerId, PlayerDto playerDto) throws PlayerServiceException {
		Player existingPlayer = getPlayerById(playerId);
		
		Team team = existingPlayer.getTeam();
		if (team.getPlayerList().size() + 1 > 5)
			try {
				throw new PlayerException("Players exceeded more than 5 for team " + team.getName());
			} catch (PlayerException e1) {
				throw new PlayerServiceException(e1.getLocalizedMessage());
			}

		if (getTotalPriceOfPlayers(team.getPlayerList()) + playerDto.getPurchasePrice() > team.getMaxBudget()) {
			try {
				throw new TeamBudgetExceedException("Team budget exceeded more than " + team.getMaxBudget());
			} catch (TeamBudgetExceedException e) {

				throw new PlayerServiceException(e.getLocalizedMessage());
			}
		}

		if (playerDto.getSkill().equals("batsman")) {
			if (getNoOfPlayersOnSkill(team.getPlayerList(), "batsman") + 1 > 2)
				try {
					throw new BatsmanExceedException("Batsman Exceeded more than 2 for team " + team.getName());
				} catch (BatsmanExceedException e) {
					throw new PlayerServiceException(e.getLocalizedMessage());
				}
		}

		if (playerDto.getSkill().equals("bowler")) {
			if (getNoOfPlayersOnSkill(team.getPlayerList(), "bowler") + 1 > 2)
				try {
					throw new BatsmanExceedException("Bowlers Exceeded more than 2 for team " + team.getName());
				} catch (BatsmanExceedException e) {
					throw new PlayerServiceException(e.getLocalizedMessage());
				}
		}

		if (playerDto.getSkill().equals("allrounder")) {
			if (getNoOfPlayersOnSkill(team.getPlayerList(), "allrounder") + 1 > 3)
				try {
					throw new BatsmanExceedException("Allrounders Exceeded more than 3 for team " + team.getName());
				} catch (BatsmanExceedException e) {
					throw new PlayerServiceException(e.getLocalizedMessage());
				}
		}
		existingPlayer.setName(playerDto.getName());
		existingPlayer.setAge(playerDto.getAge());
		existingPlayer.setSkill(playerDto.getSkill());
		existingPlayer.setPurchasePrice(playerDto.getPurchasePrice());
		return playerRepository.save(existingPlayer);

	}

	@Override
	public List<Player> sortPlayersOnPrice(List<Player> playerList) throws PlayerServiceException {
		return 
		playerList.
		stream().
		sorted(new SortDescending()).
		collect(Collectors.toList());
	}

}
