package com.mindtree.springmvcapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.springmvcapp.dto.PlayerDto;
import com.mindtree.springmvcapp.entity.Player;
import com.mindtree.springmvcapp.entity.Team;
import com.mindtree.springmvcapp.service.PlayerService;
import com.mindtree.springmvcapp.service.TeamService;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private TeamService teamService;

	@ResponseBody
	@RequestMapping(value = "addplayer/{teamName}")
	public PlayerDto addplayer(@RequestBody PlayerDto playerDto, @PathVariable("teamName") String teamName) {
		playerService.createPlayer(playerDto, teamName);
		return playerDto;
	}

	@ResponseBody
	@RequestMapping(value = "getPlayer/{playerId}")
	public Player getplayer(@PathVariable("playerId") long playerId) {
		return playerService.getPlayerById(playerId);
	}

	@ResponseBody
	@RequestMapping(value = "updateplayer/{playerId}")
	public Player updateplayer(@PathVariable("playerId") long playerId , @RequestBody PlayerDto playerDto) {
		Player updatedplayer = playerService.updatePlayer(playerId, playerDto);
		Team team = updatedplayer.getTeam();
		team.getPlayerList().stream().forEach(player -> {
			if (player.getId() == playerId)
				player = updatedplayer;
		});
		return updatedplayer;
	}

	
}
