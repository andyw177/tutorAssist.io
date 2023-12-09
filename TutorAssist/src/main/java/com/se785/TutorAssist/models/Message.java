package com.se785.TutorAssist.models;

import java.lang.annotation.Retention;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Message {
	@Id
	@GeneratedValue
	int messageId;
	int senderId;
	int receiverId;
	String content;
	@CreationTimestamp
	Timestamp createDt;
	
	public Message(int messageId,int senderId, int receiverId, String content, Timestamp createDt) {
		this.messageId = messageId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.content = content;
		this.createDt = createDt;
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
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public Timestamp getCreateDt() {
		return createDt;
	}
	public void setCreateDt(Timestamp createDt) {
		this.createDt = createDt;
	}
	
	
}
