package com.mindtree.playerauction.service;

import java.util.List;

import com.mindtree.playerauction.dto.TeamDto;
import com.mindtree.playerauction.entity.Team;
import com.mindtree.playerauction.exception.service.TeamServiceException;

public interface TeamService {
	public Team createTeam(TeamDto teamDto) throws TeamServiceException;
	
	public Team getTeamByName(String teamName) throws TeamServiceException;
	
	public List<Team> getAllTeams()  throws TeamServiceException;
	
}
