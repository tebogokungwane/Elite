package com.player.controller;

import java.net.URI;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.player.dto.PlayerRequest;
//import com.player.repository.FinancialStatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.player.exception.ResourceNotFoundException;
import com.player.model.Player;
import com.player.repository.PlayerRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private PlayerRepository playerRepository;


//	@Autowired
//	public PlayerController(PlayerRepository playerRepository,FinancialStatementRepository financialStatementRepository){
//		this.playerRepository = playerRepository;
//		this.financialStatementRepository = financialStatementRepository;
//	}

	@Autowired
	public PlayerController(PlayerRepository playerRepository){
		this.playerRepository = playerRepository;
	}

	@PostMapping
	public ResponseEntity<Player> creat(@RequestBody Player player) {
		LOGGER.log(Level.INFO,"--->PlayerController.createPlayer()");

		player.setStatus("Active");
		player.setRole("Player");

		player.setRequiredAmount(0);
		player.setTotalAmount(0);
		player.setPaidAmount(0);
		player.setOutstandingAmount(0);
		player.setRequiredAmount(0);

		Player savePlayer = playerRepository.save(player);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savePlayer.getId()).toUri();
		return ResponseEntity.created(location).body(savePlayer);

	}

	@GetMapping
	public List<Player> getAllPlayers(){
		LOGGER.log(Level.INFO,"---> PlayerController.getAllPlayers()");

		return playerRepository.findAll();
	}


	@GetMapping("{id}")
	public ResponseEntity<Player> getPlayerById(@PathVariable Long id){
		LOGGER.log(Level.INFO,"--->PlayerController.gePlayerById()");
		Player player = playerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Player not found with id "+ id));
		return ResponseEntity.ok(player);
	}

	@PutMapping("{id}")
	public ResponseEntity<Player> updatePlayer (@PathVariable Long id, @RequestBody Player playerUpdate){
		LOGGER.log(Level.INFO,"--->PlayerController.updatePlayer()");
		Player player = playerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Player not existing with id :"+ id));

		player.setFirstName(playerUpdate.getFirstName());
		player.setLastName(playerUpdate.getLastName());
		player.setEmailId(playerUpdate.getEmailId());
		Player updateNewPlayer = playerRepository.save(player);
		return ResponseEntity.ok(updateNewPlayer);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<Map<String, Boolean>> deletePlayer(@PathVariable Long id){
		LOGGER.log(Level.INFO,"--->PlayerController.deletePlayer()");
		Player player = playerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Player not exist with id :" + id));
		playerRepository.delete(player);
		Map<String,Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
