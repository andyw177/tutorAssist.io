package com.se785.TutorAssist.services;

import java.util.Set;

import com.se785.TutorAssist.models.Rating;

public interface RatingService {
	public abstract Rating createRating(Rating rating);
	public abstract boolean updateRating(Rating rating);
	public abstract boolean deleteRating(int id);
	public abstract Rating getRatingById(int id);
	public abstract Set<Rating> getAllRatings();
	public abstract Set<Rating> getRatingByUserId(int id);
}
