package com.soccer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

import com.soccer.model.Player;
import com.soccer.service.PlayerRepository;

@Repository
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public List<Player> getAllPlayer() {
		return playerRepository.findAll();
	}

	@Override
	public void savePlayer(Player player) {
		this.playerRepository.save(player);
	}

	@Override
	public Player getPlayerById(long playerid) {
		Optional<Player> optional = playerRepository.findById(playerid);
		Player player = null;
		if (optional.isPresent()) {
			player = optional.get();
		} else {
			throw new RuntimeException(" Player not found for id :: " + playerid);
		}
		return player;
	}

	@Override
	public void deletePlayerById(long playerid) {
		this.playerRepository.deleteById(playerid);
	}

	@Override
	public Page<Player> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.playerRepository.findAll(pageable);
	}
	
}
