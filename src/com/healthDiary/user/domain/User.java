package com.healthDiary.user.domain;

import java.util.Date;

public class User {
	
	private int userNumber;
	private String userName;
	private String phoneNumber;
	private String grade;
	private Date regDate;
	private boolean inRoom;
	
	public User() {}

	public User(int userNumber, String userName, String phoneNumber, String grade, Date regDate, boolean inRoom) {
		super();
		this.userNumber = userNumber;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.grade = grade;
		this.regDate = regDate;
		this.inRoom = inRoom;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public boolean isInRoom() {
		return inRoom;
	}

	public void setInRoom(boolean inRoom) {
		this.inRoom = inRoom;
	}
	
	
	
}
