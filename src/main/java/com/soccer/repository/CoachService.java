package com.soccer.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import com.soccer.model.Coach;

public interface CoachService {
	List<Coach> getAllCoach();
	void saveCoach(Coach coach);
	Coach getCoachById(long coachid);
	List<Coach> getCoachByClubId(String clubid);
	void deleteCoachById(long coachid);
	Page<Coach> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
