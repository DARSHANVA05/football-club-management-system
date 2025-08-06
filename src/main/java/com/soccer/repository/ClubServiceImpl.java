package com.soccer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.soccer.model.Club;
import com.soccer.service.ClubRepository;

@Repository
public class ClubServiceImpl implements ClubService {

	@Autowired
	private ClubRepository clubRepository;

	@Override
	public List<Club> getAllClub() {
		return clubRepository.findAll();
	}

	@Override
	public void saveClub(Club club) {
		this.clubRepository.save(club);
	}

	@Override
	public Club getClubById(long clubid) {
		Optional<Club> optional = clubRepository.findById(clubid);
		Club club = null;
		if (optional.isPresent()) {
			club = optional.get();
		} else {
			throw new RuntimeException(" Club not found for id :: " + clubid);
		}
		return club;
	}

	@Override
	public void deleteClubById(long clubid) {
		this.clubRepository.deleteById(clubid);
	}

	@Override
	public Page<Club> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.clubRepository.findAll(pageable);
	}
}


