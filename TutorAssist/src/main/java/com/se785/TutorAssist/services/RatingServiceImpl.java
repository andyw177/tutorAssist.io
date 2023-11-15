package com.se785.TutorAssist.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se785.TutorAssist.daos.RatingsRepository;
import com.se785.TutorAssist.models.Rating;
@Service
public class RatingServiceImpl implements RatingService {
	RatingsRepository rr;
	
	@Autowired
	public RatingServiceImpl(RatingsRepository rr) {
		super();
		this.rr = rr;
	}

	@Override
	public Rating createRating(Rating rating) {
		return rr.save(rating);
	}

	@Override
	public boolean updateRating(Rating rating) {
		rr.save(rating);
		return true;
	}

	@Override
	public boolean deleteRating(int id) {
		Rating rating = rr.findByRatingId(id);
		if(rating != null) {
			rr.delete(rating);
		}
		return false;
	}

	@Override
	public Rating getRatingById(int id) {
		return rr.findByRatingId(id);
	}

	@Override
	public Set<Rating> getAllRatings() {
		Set<Rating> ratings = new HashSet<Rating>();
		ratings.addAll(rr.findAll());
		return ratings;
	}

	@Override
	public Set<Rating> getRatingByUserId(int id) {
		Set<Rating> ratings = new HashSet<Rating>();
		ratings.addAll(rr.findRatingByUserId(id));
		return null;
	}

}
