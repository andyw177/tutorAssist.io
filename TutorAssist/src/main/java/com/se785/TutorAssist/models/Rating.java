package com.se785.TutorAssist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rating {
	@Id
	@GeneratedValue
	int ratingId;
	int userId;
	int numRated;
	int tutorId;
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(int ratingId, int userId, int numRated, int tutorId) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.numRated = numRated;
		this.tutorId = tutorId;
	}
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNumRated() {
		return numRated;
	}
	public void setNumRated(int numRated) {
		this.numRated = numRated;
	}
	public int getTutorId() {
		return tutorId;
	}
	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}
	
	
	
}
