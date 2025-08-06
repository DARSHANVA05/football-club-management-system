package com.soccer.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import com.soccer.model.Player;

public interface PlayerService {
	List<Player> getAllPlayer();
	void savePlayer(Player player);
	Player getPlayerById(long playerid);
	void deletePlayerById(long playerid);
	Page<Player> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
	
