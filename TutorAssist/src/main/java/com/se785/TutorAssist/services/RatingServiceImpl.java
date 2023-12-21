package com.se785.TutorAssist.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se785.TutorAssist.daos.RatingsRepository;
import com.se785.TutorAssist.daos.TutorRepository;
import com.se785.TutorAssist.models.Rating;
import com.se785.TutorAssist.models.Tutor;
@Service
public class RatingServiceImpl implements RatingService {
	RatingsRepository rr;
	TutorRepository tr;
	
	@Autowired
	public RatingServiceImpl(RatingsRepository rr,TutorRepository tr) {
		super();
		this.rr = rr;
		this.tr = tr;
	}

	@Override
	public Rating createRating(int tutor, int rating,int user) {
		Rating rate = new Rating();
		rate.setNumRated(rating);
		rate.setTutorId(tutor);
		rate.setUserId(user);
		rr.save(rate);
		return rate;
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
	public Set<Rating> getAllRatingsByUserId(int id) {
		Set<Rating> ratings = new HashSet<Rating>();
		ratings.addAll(rr.findRatingByUserId(id));
		return ratings;
	}

	@Override
	public Set<Rating> getAllRatingsByTutorId(int id) {
		Set<Rating> ratings = new HashSet<Rating>();
		ratings.addAll(rr.findRatingByTutorId(id));
		return ratings;
	}

	@Override
	public boolean setAverageRating(int tutorID) {
		Set<Rating> ratings = new HashSet<Rating>();
		ratings.addAll(rr.findRatingByTutorId(tutorID));
		int sum = 0,average = 0;
		for(Rating r: ratings) {
			sum += r.getNumRated();
		}
		average = sum / ratings.size();
		Tutor tutor = tr.findByTutorId(tutorID);
		if (tutor == null) {
			return false;
		}else {
			tutor.setRating(average);
			tr.save(tutor);
			return true;
		}
	}

}
