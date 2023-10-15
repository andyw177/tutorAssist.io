package com.se785.TutorAssist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class File {
	@Id
	@GeneratedValue
	int fileId;
	int userId;
	String fileType;
	String filename;
	public File() {
		super();
		// TODO Auto-generated constructor stub
	}
	public File(int userId, String fileType, String filename) {
		super();
		this.userId = userId;
		this.fileType = fileType;
		this.filename = filename;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
