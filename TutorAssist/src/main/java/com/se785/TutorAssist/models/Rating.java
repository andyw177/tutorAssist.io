package com.se785.TutorAssist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rating {
	@Id
	int ratingId;
	int userId;
	int numRated;
	public Rating(int userId, int numRated) {
		super();
		this.userId = userId;
		this.numRated = numRated;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
}
