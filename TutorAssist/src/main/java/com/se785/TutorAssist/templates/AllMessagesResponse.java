package com.se785.TutorAssist.templates;

import java.util.List;

import com.se785.TutorAssist.models.Message;
//Egemen Durmus
public class AllMessagesResponse {
	private List<Message> sent;
	private List<Message> recieved;
	
	public AllMessagesResponse() {
		
	}
	
	public AllMessagesResponse(List<Message> list, List<Message> list2) {
		super();
		this.sent = list;
		this.recieved = list2;
	}
	
	public List<Message> getSent() {
		return sent;
	}
	public void setSent(List<Message> sent) {
		this.sent = sent;
	}
	public List<Message> getRecieved() {
		return recieved;
	}
	public void setRecieved(List<Message> recieved) {
		this.recieved = recieved;
	}
	
	
}
