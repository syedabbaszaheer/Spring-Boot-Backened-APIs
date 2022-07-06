package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Player;

public interface PlayerService{
	Player savePlayer(Player Player);
 	List<Player> getAllPlayeres();
	Player getPlayerById(long id);
	Player updatePlayer(Player player, long id);
	void deletePlayer(long id);
	List<Player> getTeamPlayer(String teamName);
	List<String> getAllTeams();
}