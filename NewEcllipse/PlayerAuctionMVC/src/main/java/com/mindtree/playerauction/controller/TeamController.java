package com.mindtree.playerauction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.playerauction.dto.TeamDto;
import com.mindtree.playerauction.exception.TeamException;
import com.mindtree.playerauction.service.TeamService;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;


	//@ResponseBody
	@PostMapping(value = "/addteam")
	public String addteam(@RequestBody TeamDto teamDto) throws TeamException {
		System.out.println(teamDto);
		teamService.createTeam(teamDto);
		//ModelAndView mv = new ModelAndView("index");
		//return mv;
		return "welcome";
	}

}
