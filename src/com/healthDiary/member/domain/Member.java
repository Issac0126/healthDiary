package com.healthDiary.member.domain;

import java.util.Date;

public class Member {
    
    private int MemberNum;
    private String MemberName;
    private String phoneNum;
    private String grade;
    private Date regDate;
    private String inRoom;
    
    public Member() {}

    public Member(int memberNum, String memberName, String phoneNum, String grade, Date regDate, String inRoom) {
        super();
        MemberNum = memberNum;
        MemberName = memberName;
        this.phoneNum = phoneNum;
        this.grade = grade;
        this.regDate = regDate;
        this.inRoom = inRoom;
    }

    public int getMemberNum() {
        return MemberNum;
    }

    public void setMemberNum(int memberNum) {
        MemberNum = memberNum;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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

    public String isInRoom() {
        return inRoom;
    }

    public void setInRoom(String inRoom) {
        this.inRoom = inRoom;
    }

    
    
    // 기록 확인 중 추가.
	@Override
	public String toString() {
		String room = "입실중";
		if(this.inRoom.equals("false")) room = "퇴실";
		int lastHPIdx = phoneNum.lastIndexOf("-");
		
		return " "+MemberNum + "번 \t"+MemberName +"  "+ phoneNum.substring(lastHPIdx+1) +"     "
				+ grade +"  "+ regDate +"  "+ room;
	}

    
    
    
}
























