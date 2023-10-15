package com.se785.TutorAssist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {
	@Id
	@GeneratedValue
	int messageId;
	int senderId;
	int receiverId;
	String content;
	public Message(int senderId, int receiverId, String content) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.content = content;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
