package com.se785.TutorAssist.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se785.TutorAssist.daos.ForumRepository;
import com.se785.TutorAssist.models.Forum;

@Service
public class ForumServiceImpl implements ForumService{
	private ForumRepository fr;
	
	@Autowired
	public ForumServiceImpl(ForumRepository fr) {
		super();
		this.fr = fr;
	}

	@Override
	public Forum createForum(Forum forum) {	
		return fr.save(forum);
	}

	@Override
	public boolean updateForum(Forum forum) {
		fr.save(forum);
		return true;
	}

	@Override
	public boolean deleteForum(int id) {
		Forum forum = fr.findByForumId(id);
		
		if(forum == null) {
			return false;
		}else {
			fr.delete(forum);
			return true;
		}

	}

	@Override
	public Forum getForumById(int id) {
		return fr.findByForumId(id);
	}

	@Override
	public Set<Forum> getAllForums() {
		List<Forum> forums = fr.findAll();
		HashSet<Forum> set = new HashSet<Forum>();
		set.addAll(forums);
		return set;
	}

	@Override
	public Set<Forum> getAllForumsByUserId(int id) {
		List<Forum> forums = fr.findAllByUserId(id);
		HashSet<Forum> set = new HashSet<Forum>();
		set.addAll(forums);
		return set;
	}

}
