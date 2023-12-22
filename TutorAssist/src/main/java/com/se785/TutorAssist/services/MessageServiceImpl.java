package com.se785.TutorAssist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se785.TutorAssist.daos.MessageRepository;
import com.se785.TutorAssist.models.Message;
import com.se785.TutorAssist.templates.AllMessagesResponse;
//Andy Wang 
@Service
public class MessageServiceImpl implements MessageService{
	
	MessageRepository mr;
	
	@Autowired
	public MessageServiceImpl(MessageRepository mr) {
		super();
		this.mr = mr;
	}

	@Override
	public Message createMessage(Message message) {
		return mr.save(message);
	}

	@Override
	public boolean updateMessage(Message message) {
		mr.save(message);
		return true;
	}

	@Override
	public boolean deleteMessage(int id) {
		Message message = mr.findByMessageId(id);
		if (message == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public Message getByMessageId(int id) {
		return mr.findByMessageId(id);
	}
	
	@Override
	public AllMessagesResponse getAllMessages(int id) {
		
		return new AllMessagesResponse(mr.findBySenderId(id),mr.findByReceiverId(id));
	}

}
