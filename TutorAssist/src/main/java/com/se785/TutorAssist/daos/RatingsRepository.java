package com.se785.TutorAssist.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se785.TutorAssist.models.Rating;
//Andy Wang 
@Repository
public interface RatingsRepository extends JpaRepository<Rating,Integer> {
	public abstract Rating findByRatingId(int id);
	public abstract List<Rating> findRatingByUserId(int id);
	public abstract List<Rating> findRatingByTutorId(int id);
	
}
