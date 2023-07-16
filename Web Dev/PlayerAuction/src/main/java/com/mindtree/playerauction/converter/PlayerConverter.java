package com.mindtree.playerauction.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.playerauction.dto.PlayerDto;
import com.mindtree.playerauction.entity.Player;


@Component
public class PlayerConverter {
	public PlayerDto entityToDto(Player player) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(player, PlayerDto.class);
	}

	public Player dtoToEntity(PlayerDto playerDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(playerDto, Player.class);

	}
}
