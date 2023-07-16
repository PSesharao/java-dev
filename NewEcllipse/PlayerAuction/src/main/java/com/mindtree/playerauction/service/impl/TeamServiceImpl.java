package com.mindtree.playerauction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.playerauction.converter.TeamConverter;
import com.mindtree.playerauction.dto.TeamDto;
import com.mindtree.playerauction.entity.Team;
import com.mindtree.playerauction.exception.dao.DuplicateTeamNameException;
import com.mindtree.playerauction.exception.service.TeamServiceException;
import com.mindtree.playerauction.repository.TeamRepository;
import com.mindtree.playerauction.service.TeamService;
@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private TeamConverter teamConverter;

	@Override
	public Team createTeam(TeamDto teamDto) throws TeamServiceException {
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
	public Team getTeamByName(String teamName) throws TeamServiceException {

		return teamRepository.findByName(teamName);
	}

	
	@Override
	public List<Team> getAllTeams() throws TeamServiceException {
		
		return teamRepository.findAll();
	}

}
