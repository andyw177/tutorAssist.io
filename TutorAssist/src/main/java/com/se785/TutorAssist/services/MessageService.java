package com.se785.TutorAssist.services;

import com.se785.TutorAssist.models.Message;
import com.se785.TutorAssist.templates.AllMessagesResponse;

public interface MessageService {
	public abstract Message createMessage(Message message);
	public abstract boolean updateMessage(Message message);
	public abstract boolean deleteMessage(int id);
	public abstract Message getByMessageId(int id);
	//returns all messages associated with the id
	public abstract AllMessagesResponse getAllMessages(int id);
}
