package com.mindtree.springmvcapp.service;

import java.util.List;

import com.mindtree.springmvcapp.dto.TeamDto;
import com.mindtree.springmvcapp.entity.Team;
import com.mindtree.springmvcapp.exception.service.TeamServiceException;


public interface TeamService {
	public Team createTeam(TeamDto teamDto) throws TeamServiceException;
	
	public Team getTeamByName(String teamName) ;
	
	public List<Team> getAllTeams();
	
}
