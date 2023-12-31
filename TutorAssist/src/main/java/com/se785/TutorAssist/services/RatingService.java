package com.se785.TutorAssist.services;

import java.util.Set;

import com.se785.TutorAssist.models.Rating;

public interface RatingService {
	public abstract boolean updateRating(Rating rating);
	public abstract boolean deleteRating(int id);
	public abstract Rating getRatingById(int id);
	public abstract Set<Rating> getAllRatings();
	public abstract Set<Rating> getAllRatingsByUserId(int id);
	public abstract Set<Rating> getAllRatingsByTutorId(int id);
	public abstract boolean setAverageRating(int tutorID);
	public abstract Rating createRating(int tutor, int rating, int user);



}
