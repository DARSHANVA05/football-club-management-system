package com.soccer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.soccer.model.Coach;
import com.soccer.service.CoachRepository;

@Repository
public class CoachServiceImpl implements CoachService {

	@Autowired
	private CoachRepository coachRepository;

	@Override
	public List<Coach> getAllCoach() {
		return coachRepository.findAll();
	}

	@Override
	public void saveCoach(Coach coach) {
		this.coachRepository.save(coach);
	}

	@Override
	public Coach getCoachById(long coachid) {
		Optional<Coach> optional = coachRepository.findById(coachid);
		Coach coach = null;
		if (optional.isPresent()) {
			coach = optional.get();
		} else {
			throw new RuntimeException(" Coach not found for id :: " + coachid);
		}
		return coach;
	}
	@Override
	public List<Coach> getCoachByClubId(String clubid) {
		List<Coach> coaches = coachRepository.getCoachByClubId(clubid);
		return coaches;
	}

	@Override
	public void deleteCoachById(long coachid) {
		this.coachRepository.deleteById(coachid);
	}

	@Override
	public Page<Coach> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.coachRepository.findAll(pageable);
	}
}
