package com.se785.TutorAssist.daos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se785.TutorAssist.models.Message;
//Andy Wang 
@Repository
public interface MessageRepository extends JpaRepository<Message,Integer>{
	public abstract Message findByMessageId(int id);
	public abstract List<Message> findByReceiverId(int id);
	public abstract List<Message> findBySenderId(int id);
	
}
