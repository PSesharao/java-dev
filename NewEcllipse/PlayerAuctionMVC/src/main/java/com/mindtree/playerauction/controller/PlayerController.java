package com.mindtree.playerauction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.playerauction.dto.PlayerDto;
import com.mindtree.playerauction.entity.Player;
import com.mindtree.playerauction.entity.Team;
import com.mindtree.playerauction.exception.PlayerException;
import com.mindtree.playerauction.exception.service.TeamServiceException;
import com.mindtree.playerauction.service.PlayerService;
import com.mindtree.playerauction.service.TeamService;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private TeamService teamService;
	

	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/player")
	public ModelAndView player() throws PlayerException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("player");

		List<Team> teamlist = null;
		try {
			teamlist = teamService.getAllTeams();
		} catch (TeamServiceException e) {
			throw new PlayerException(e.getLocalizedMessage());
		}
		mv.addObject("teamList", teamlist);
		return mv;

	}

	@RequestMapping("/addplayer")
	public String addplayer(PlayerDto playerDto, @RequestParam("team") String teamName) throws PlayerException {
		playerService.createPlayer(playerDto, teamName);
		return "welcome";
	}

	@RequestMapping("/show")
	public ModelAndView show() throws PlayerException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show");

		List<Team> teamlist = null;
		try {
			teamlist = teamService.getAllTeams();
		} catch (TeamServiceException e) {
			throw new PlayerException(e.getLocalizedMessage());
		}
		mv.addObject("teamList", teamlist);
		return mv;

	}

	@RequestMapping("/showplayer")
	public ModelAndView showPlayer(@RequestParam("team") String teamName) throws PlayerException {
		Team team = null;
		try {
			team = teamService.getTeamByName(teamName);
		} catch (TeamServiceException e) {

			throw new PlayerException(e.getLocalizedMessage());
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show");

		List<Team> teamlist = null;
		try {
			teamlist = teamService.getAllTeams();
		} catch (TeamServiceException e) {
			throw new PlayerException(e.getLocalizedMessage());
		}
		mv.addObject("teamList", teamlist);
		mv.addObject("playerList", playerService.sortPlayersOnPrice(team.getPlayerList()));
		return mv;

	}

	@RequestMapping("/update")
	public ModelAndView update(@RequestParam("playerId") long playerId) throws PlayerException {
		Player player = playerService.getPlayerById(playerId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateplayer");
		mv.addObject("player", player);
		return mv;
	}

	@RequestMapping("/updateplayer")
	public ModelAndView updatePlayer(@RequestParam("playerId") long playerId, PlayerDto playerDto)
			throws PlayerException {
		Player updatedplayer = playerService.updatePlayer(playerId, playerDto);
		Team team = updatedplayer.getTeam();
		team.getPlayerList().stream().forEach(player -> {
			if (player.getId() == playerId)
				player = updatedplayer;
		});

		ModelAndView mv = new ModelAndView();
		mv.setViewName("show");
		List<Team> teamlist = null;
		try {
			teamlist = teamService.getAllTeams();
		} catch (TeamServiceException e) {
			throw new PlayerException(e.getLocalizedMessage());
		}
		mv.addObject("teamList", teamlist);
		return mv;
	}

}
