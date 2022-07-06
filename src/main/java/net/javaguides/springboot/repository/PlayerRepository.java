package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{
	

	List<Player> findByTeam(String teamName);

	@Query("SELECT DISTINCT p.team FROM Player p")
	List<String> getAllTeams();
	
}