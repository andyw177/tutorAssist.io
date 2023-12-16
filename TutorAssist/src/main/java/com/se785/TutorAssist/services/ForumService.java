package com.se785.TutorAssist.services;

import java.util.Set;

import com.se785.TutorAssist.models.Forum;

public interface ForumService {
	public abstract Forum createForum(Forum forum);
	public abstract boolean updateForum(Forum forum);
	public abstract boolean deleteForum(int id);
	public abstract Forum getForumById(int id);
	public abstract Set<Forum> getAllForums();
	public abstract Set<Forum> getAllForumsByUserId(int id);
}
