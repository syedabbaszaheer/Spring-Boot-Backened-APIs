package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springboot.model.Player;
import net.javaguides.springboot.service.PlayerService;

@RestController
@RequestMapping("/api/v1/")
public class PlayerController {

	private PlayerService playerService;

	public PlayerController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}
	
	// build create player REST API
	//http://localhost:8080/api/v1/player
	@PostMapping("player")
	public ResponseEntity<Player> savePlayer(@RequestBody Player player){
		return new ResponseEntity<Player>(playerService.savePlayer(player), HttpStatus.CREATED);
	}
	
	// build get all player REST API
	//http://localhost:8080/api/v1/getAllPlayers
	@GetMapping("getAllPlayers")
	public List<Player> getAllPlayer(){
		List<Player> list=playerService.getAllPlayeres();
		return list;
	}
	
	// build get player by id REST API
	// http://localhost:8080/api/v1/getPlayer/1
	@GetMapping("getPlayer/{id}")
	public ResponseEntity<Player> getPlayerById(@PathVariable("id") long playerId){
		Player player=playerService.getPlayerById(playerId);
		return new ResponseEntity<Player>(player, HttpStatus.OK);
	}
	
	// build update Player REST API
	// http://localhost:8080/api/v1/updatePlayer/1
	@PutMapping("updatePlayer/{id}")
	public ResponseEntity<Player> updatePlayer(@PathVariable("id") long id
												  ,@RequestBody Player player){
		return new ResponseEntity<Player>(playerService.updatePlayer(player, id), HttpStatus.OK);
	}
	
	// build delete Player REST API
	// http://localhost:8080/api/v1/deletePlayer/1
	@DeleteMapping("deletePlayer/{id}")
	public ResponseEntity<String> deletePlayer(@PathVariable("id") long id){
		
		// delete Player from DB
		playerService.deletePlayer(id);
		
		return new ResponseEntity<String>("Player deleted successfully!.", HttpStatus.OK);
	}
	
	// build get all player REST API
	//http://localhost:8080/api/v1/getTeamPlayer/Chennai
	@GetMapping("getTeamPlayer/{team}")
	public List<Player> getAllPlayer(@PathVariable("team") String team){
		List<Player> list=playerService.getTeamPlayer(team);
		return list;
	}
	
	//http://localhost:8080/api/v1/getAllTeams
	@GetMapping("getAllTeams")
	public List<String> getAllTeams(){
		List<String> list=playerService.getAllTeams();
		return list;
	}
	
}
