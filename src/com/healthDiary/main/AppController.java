package com.healthDiary.main;

import com.healthDiary.common.AppService;
import com.healthDiary.exercise.service.ExerciseService;
import com.healthDiary.member.service.MemberService;
import com.healthDiary.record.RecordStart;

public class AppController {

	private AppService service;


	public void chooseSystem(int selectNumber) {
		switch (selectNumber) {
		case 1:
			service = new MemberService();
			break;
		case 2:
			service = new HealthManage();
			break;
		case 3:
			service = new RecordStart(); 
			break;
		case 4:
			System.out.println("\n\n프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("1~5의 숫자를 입력해 메뉴를 선택해주세요.");
		}
		
		service.Start();
		
	}
	
}
