package com.healthDiary.main;

import com.healthDiary.common.AppService;

public class AppController {

	private AppService service;
	
	public void chooseSystem(int selectNumber) {
		switch (selectNumber) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;

		default:
			System.out.println("메뉴를 다시 입력하세요");
		}
		
		service.Start();
		
	}
	
}
