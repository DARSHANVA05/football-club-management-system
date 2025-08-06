package com.soccer.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import com.soccer.model.Club;


public interface ClubService {
		
	List<Club> getAllClub();
	void saveClub(Club club);
	Club getClubById(long clubid);
	void deleteClubById(long clubid);
	Page<Club> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
}
