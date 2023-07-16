package com.mindtree.springmvcapp.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mindtree.springmvcapp.dto.TeamDto;
import com.mindtree.springmvcapp.entity.Team;



@Component
public class TeamConverter {
	public TeamDto entityToDto(Team team) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(team, TeamDto.class);
	}

	public Team dtoToEntity(TeamDto teamDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(teamDto, Team.class);

	}
}
