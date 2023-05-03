package com.healthDiary.record;

import java.sql.Date;
import java.time.LocalDateTime;

import com.healthDiary.common.AppService;

public class Record implements AppService {

	private int recordNum; //기록 등록 번호
	private int userNumber; //회원 번호
	private int exeNum; //운동 종목 번호
	private int recordScore; //기록
	private Date recordDay;
	
	public Record() {
	}

	public Record(int recordNum, int userNumber, int exeNum, int recordScore,
			Date recordDay) {
		super();
		this.recordNum = recordNum;
		this.userNumber = userNumber;
		this.exeNum = exeNum;
		this.recordScore = recordScore;
		this.recordDay = recordDay;
	}
	
	@Override
	public void Start() {	
	}
	
	@Override //불렀을 경우 출력
	public String toString() {
		return " "+recordNum+"번 \t" + userNumber + ", exeNum=" + exeNum
				+ ", recordScore=" + recordScore + ", recordDay=" + recordDay + "]";
	}

	public int getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(int recordNum) {
		this.recordNum = recordNum;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public int getExeNum() {
		return exeNum;
	}

	public void setExeNum(int exeNum) {
		this.exeNum = exeNum;
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
