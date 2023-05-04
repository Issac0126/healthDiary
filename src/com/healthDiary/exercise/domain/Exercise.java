package com.healthDiary.exercise.domain;

public class Exercise {
	private int exe_num;
	private String exe_name;
	private String exe_measure;
	
	public Exercise() {}
	
	public Exercise(int exe_num, String exe_name, String exe_measure) {
		super();
		this.exe_num = exe_num;
		this.exe_name = exe_name;
		this.exe_measure = exe_measure;
	}

	public int getExe_num() {
		return exe_num;
	}

	public void setExe_num(int exe_num) {
		this.exe_num = exe_num;
	}

	public String getExe_name() {
		return exe_name;
	}

	public void setExe_name(String exe_name) {
		this.exe_name = exe_name;
	}

	public String getExe_measure() {
		return exe_measure;
	}

	public void setExe_measure(String exe_measure) {
		this.exe_measure = exe_measure;
	}

	////////////////////////////////////////////////
	public void setName(String answer) {
	    this.exe_name = answer;
	}
	////////////////////////////////////////////////

	public boolean contains(String select) {
		return exe_name.equals(select);
	}
	
	@Override
	public String toString() {
		String mea = "시간"; 
		if(exe_measure.equals("C")) mea = "횟수";
		
		return " "+exe_num + "번 \t" + exe_name + " / 운동 분류: " + exe_measure;
	}
	

}
