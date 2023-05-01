package com.healthDiary.record;

import static com.healthDiary.view.AppUI.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.healthDiary.common.AppService;
import com.healthDiary.common.DataBaseConnection;
import com.healthDiary.exercise.Exercise;
import com.healthDiary.view.AppUI;

public class RecordStart implements AppService {


	private static DataBaseConnection connection
	= DataBaseConnection.getInstance();
	private final RecordRepository recordRepository = new RecordRepository();
	
	
	@Override
	public void Start() {
		recordScreen();
		int answerNum = AppUI.inputInteger(); 
		
		switch (answerNum) {
		case 1:
			exeStart();
			break;
		case 2:
			
			break;
		default:
			System.out.println("유효한 번호를 입력해주세요. (1~2)");
			break;
		}
	}
	
	
	private void exeStart() { //무슨 운동을 할지 검색
		System.out.println("\n\n오늘은 어떤 운동을 하실 건가요?");
		System.out.println("(목록을 보려면 '목록 보기'를 입력해주세요. \n > ");
		String answer = inputString().trim();
		String sql = null;
		
		if(answer.equals("목록") || answer.equals("목록 보기") || answer.equals("목록보기")) {
			sql = "SELECT * FROM exercise;";
		} else {
			System.out.println("\n'"+answer+"'이 포함된 운동을 검색합니다.");
			sql = "SELECT * FROM exercise WHERE exe_name LIKE '%"+answer+"%';";
		}
		
		List<Exercise> exeList= recordRepository.exeListSearch(sql);			
		
		
		//운동 목록 출력
		if(exeList.size() >= 1) { 
			System.out.println("─────────── 운동 목록 ───────────");
			for(Exercise e : exeList) {
				System.out.println(e + "\n");
			}
			System.out.println("──────────────────────────────");
		} else {
			System.out.println("! 운동 목록에 등록된 운동이 없습니다."
					+ " \n메인 메뉴에서 새 운동 목록을 추가해 주세요.");
			return;
		}
		
		
		// 시작 운동 번호 고르기
		System.out.print("\n시작할 운동 번호를 골라주세요. \n >");
		int startExeNum = inputInteger();
		
		boolean flag = false;
		for(Exercise e  : exeList) {
			if(e.getExe_num() == startExeNum) {
				flag= true;  break;
			}
		} 
		if(!flag) {
			System.out.println("목록에 포함된 번호만 골라주세요.");
			return;
		}
		
		
		ResultSet selExe = recordRepository.ExeNumToName(startExeNum);
		String selExeName = null;
		String CST = null;
		String selExeMeasure = null;
		
		
		try {
			selExeName = selExe.getString("exe_name");
			CST = selExe.getString("exe_measure");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(CST.equals("C")) selExeMeasure = "횟수";
		else if(CST.equals("S")) selExeMeasure = "시간";
		else selExeMeasure = "타이머";
		
		System.out.println(selExeName+" 운동을 시작합니다.");
		System.out.println("타이머를 시작하려면 'Enter'를 눌러주세요!");
		inputString();
		
		//숙제 : 타이머 만들기
		
		System.out.println("타이머가 시작되었습니다.");
		System.out.println("'끝'이라고 입력하면 타이머가 종료됩니다.");
		


		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
