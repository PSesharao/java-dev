package com.mindtree.springmvcapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mindtree.springmvcapp.converter.TeamConverter;
import com.mindtree.springmvcapp.dto.PlayerDto;
import com.mindtree.springmvcapp.dto.TeamDto;
import com.mindtree.springmvcapp.entity.Player;
import com.mindtree.springmvcapp.entity.Team;
import com.mindtree.springmvcapp.exception.TeamException;
import com.mindtree.springmvcapp.service.TeamService;

@Controller
public class TeamController {
	
	@Autowired
	private TeamConverter teamConverter;
	
	@Autowired
	private TeamService teamService;

	@ResponseBody
	@RequestMapping(value = "/addteam")
	public TeamDto addteam(@RequestBody TeamDto teamDto)  throws TeamException {
		//System.out.println(teamDto);
		teamService.createTeam(teamDto);
		// ModelAndView mv = new ModelAndView("index");
		// return mv;
		return teamDto;
	}

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "getTeams")
	public List<Team> getTeams() {

		List<Team> teamList = teamService.getAllTeams();
		List<TeamDto> teamDtoList = new ArrayList<>();
		List<String> teamNames = new ArrayList<>();
		for (Team team : teamList) {
			teamDtoList.add(teamConverter.entityToDto(team));
			teamNames.add(team.getName());
		}
		//Gson gson = new Gson();
		//return gson.toJson(teamDtoList);
		return teamList;
	}
	
	@ResponseBody
	@RequestMapping(value = "getplayers/{teamName}")
	public List<Player> addplayer(@PathVariable("teamName") String teamName)  {
		return teamService.getTeamByName(teamName).getPlayerList();
	}
	
	

}
