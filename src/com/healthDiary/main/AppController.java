package com.healthDiary.main;

import com.healthDiary.common.AppService;
import com.healthDiary.record.recordStart;

public class AppController {

	private AppService service;
	
	public void chooseSystem(int selectNumber) {
		switch (selectNumber) {
		case 1:
//			service = new ???();
			break;
		case 2:
//			service = new ???();
			break;
		case 3:
//			service = new recordStart();
			break;
		case 4:
//			service = new ???();
			break;
		default:
			System.out.println("1~5의 숫자를 입력해 메뉴를 선택해주세요.");
		}
		
		service.Start();
		
	}
	
}
