package com.mindtree.springmvcapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.springmvcapp.converter.TeamConverter;
import com.mindtree.springmvcapp.dto.TeamDto;
import com.mindtree.springmvcapp.entity.Team;
import com.mindtree.springmvcapp.exception.dao.DuplicateTeamNameException;
import com.mindtree.springmvcapp.exception.service.TeamServiceException;
import com.mindtree.springmvcapp.repository.TeamRepository;
import com.mindtree.springmvcapp.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private TeamConverter teamConverter;

	@Override
	public Team createTeam(TeamDto teamDto) throws TeamServiceException{

		//return teamRepository.save(teamConverter.dtoToEntity(teamDto));
		if (this.getTeamByName(teamDto.getName())==null)
			return teamRepository.save(teamConverter.dtoToEntity(teamDto));
		else
		{
			try {
				throw new DuplicateTeamNameException("The team name '"+teamDto.getName()+"' has already been assigned to other team.");
			} catch (DuplicateTeamNameException e) {
				
				throw new TeamServiceException(e.getLocalizedMessage());
			}
		}

	}

	@Override
	public Team getTeamByName(String teamName)  {

		return teamRepository.findByName(teamName);
	}

	@Override
	public List<Team> getAllTeams(){

		return teamRepository.findAll();
	}

}
