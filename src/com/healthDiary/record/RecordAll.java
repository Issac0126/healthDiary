package com.healthDiary.record;

import java.sql.Date;

public class RecordAll {

	private int recordNum; //기록 등록 번호
	private int userNum; //회원 번호
	private int exeNum; //운동 번호
	private String userName; //회원 이름
	private String exeName; //운동명	
	private String exeMeasure; //운동 횟수 구분
	private int recordScore; //기록
	private Date recordDay; //운동한 날짜
	
	public RecordAll() { }
	
	@Override
	public String toString() {
		String meas= "초";
		if(exeMeasure.equals("C")) meas="회";
		
		return " " + recordNum + "번 \t" +recordDay+ " "+exeName+" / 기록: "
				+recordScore + meas;
	}
	
	

	public int getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(int recordNum) {
		this.recordNum = recordNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getExeNum() {
		return exeNum;
	}

	public void setExeNum(int exeNum) {
		this.exeNum = exeNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getExeName() {
		return exeName;
	}

	public void setExeName(String exeName) {
		this.exeName = exeName;
	}

	public String getExeMeasure() {
		return exeMeasure;
	}

	public void setExeMeasure(String exeMeasure) {
		this.exeMeasure = exeMeasure;
	}

	public int getRecordScore() {
		return recordScore;
	}

	public void setRecordScore(int recordScore) {
		this.recordScore = recordScore;
	}


	public Date getRecordDay() {
		return recordDay;
	}

	public void setRecordDay(Date recordDay) {
		this.recordDay = recordDay;
	}

	public RecordAll(int recordNum, int userNum, int exeNum, String userName, String exeName, String exeMeasure,
			int recordScore, Date recordDay) {
		super();
		this.recordNum = recordNum;
		this.userNum = userNum;
		this.exeNum = exeNum;
		this.userName = userName;
		this.exeName = exeName;
		this.exeMeasure = exeMeasure;
		this.recordScore = recordScore;
		this.recordDay = recordDay;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
