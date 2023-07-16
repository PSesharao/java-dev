package com.mindtree.springmvcapp.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springmvcapp.converter.PlayerConverter;
import com.mindtree.springmvcapp.dto.PlayerDto;
import com.mindtree.springmvcapp.entity.Player;
import com.mindtree.springmvcapp.repository.PlayerRepository;
import com.mindtree.springmvcapp.service.PlayerService;



class SortDescending implements Comparator<Player> {

	@Override
	public int compare(Player player1, Player player2) {
		return (player2.getPurchasePrice() - player1.getPurchasePrice());
	}

}

@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private PlayerConverter playerConverter;

	@Override
	public Player createPlayer(PlayerDto playerDto) {
		
		Player player = playerConverter.dtoToEntity(playerDto);
	
		
		return playerRepository.save(player);
	}

	@Override
	public int getTotalPriceOfPlayers(List<Player> playerList) {

		Integer totalPrice = playerList.stream().mapToInt(x -> x.getPurchasePrice()).sum();
		return totalPrice;
	}

	@Override
	public int getNoOfPlayersOnSkill(List<Player> playerList, String skill)  {

		return (int) playerList.stream().filter(player -> player.getSkill().equals(skill)).count();
	}

	@Override
	public Player getPlayerById(long playerId) {

		return playerRepository.findById(playerId).orElse(null);
	}

	@Override
	public Player updatePlayer(long playerId, PlayerDto playerDto) {
		Player existingPlayer = getPlayerById(playerId);
		
		existingPlayer.setName(playerDto.getName());
		existingPlayer.setAge(playerDto.getAge());
		existingPlayer.setSkill(playerDto.getSkill());
		existingPlayer.setPurchasePrice(playerDto.getPurchasePrice());
		return playerRepository.save(existingPlayer);

	}

	@Override
	public List<Player> sortPlayersOnPrice(List<Player> playerList) {
		return 
		playerList.
		stream().
		sorted(new SortDescending()).
		collect(Collectors.toList());
	}

}
