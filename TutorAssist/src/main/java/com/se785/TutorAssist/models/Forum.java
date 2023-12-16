package com.se785.TutorAssist.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Forum {
	@Id
	@GeneratedValue
	int forumId;
	int userId;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date date;
	String title;
	String body;
	int upCount;
	public Forum(int userId, Date date, String title, String body) {
		super();
		this.userId = userId;
		this.date = date;
		this.title = title;
		this.body = body;
	}
	public Forum() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public int getUpCount() {
		return upCount;
	}
	public void setUpCount(int upCount) {
		this.upCount = upCount;
	}
	
	
	
}
