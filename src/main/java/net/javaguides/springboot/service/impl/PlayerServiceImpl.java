package net.javaguides.springboot.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Player;
import net.javaguides.springboot.repository.PlayerRepository;
import net.javaguides.springboot.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	private PlayerRepository playerRepository;

	public PlayerServiceImpl(PlayerRepository playerRepository) {
		super();
		this.playerRepository = playerRepository;
	}
	
	@Override
	public Player savePlayer(Player Player) {
		return playerRepository.save(Player);
	}
	
	@Override
	public List<Player> getAllPlayeres() {
		return playerRepository.findAll();
	}
	
	@Override
	public Player getPlayerById(long id) {
		return playerRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Player", "Id", id));	
	}
	
	@Override
	public Player updatePlayer(Player player, long id) {
		
		// we need to check whether Player with given id is exist in DB or not
		Player existingPlayer = playerRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Player", "Id", id)); 
		existingPlayer.setFirstName(player.getFirstName());
		existingPlayer.setLastName(player.getLastName());
		existingPlayer.setRole(player.getRole());
		existingPlayer.setTeam(player.getTeam());
		
		// save existing Player to DB
		playerRepository.save(existingPlayer);
		return existingPlayer;
	}

	@Override
	public void deletePlayer(long id) {
		
		// check whether a Player exist in a DB or not
		playerRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Player", "Id", id));
		playerRepository.deleteById(id);
	}
	
	@Override
	public List<Player> getTeamPlayer(String teamName){
		List<Player> players=playerRepository.findByTeam(teamName);
		return players ;
	}
	
	@Override
	public List<String> getAllTeams(){
		List<String> teams=playerRepository.getAllTeams();
		return teams ;
	}
}
