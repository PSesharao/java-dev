package com.mindtree.playerauction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.playerauction.dto.TeamDto;
import com.mindtree.playerauction.exception.TeamException;
import com.mindtree.playerauction.service.TeamService;


@Controller
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping("/home") 
	public String home() throws TeamException
	{
		return "frame";
	}
	
	@RequestMapping("/welcome") 
	public String welcome() throws TeamException
	{
		return "welcome";
	}
	
	@RequestMapping("/navtabs1") 
	public String navtabs() throws TeamException
	{
		return "navtabs1";
	}
	
	@RequestMapping("/bottom") 
	public String bottom() throws TeamException
	{
		return "bottom";
	}
	
	@RequestMapping("/team") 
	public String team() throws TeamException
	{
		return "team";
	}
	
	@RequestMapping("/addteam") 
	public String addteam(TeamDto teamDto) throws TeamException
	{
		teamService.createTeam(teamDto);
		return "welcome";
	}
	
}
