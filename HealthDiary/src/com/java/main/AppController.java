package com.java.main;

import com.java.common.AppService;
import com.java.member.memberService;

public class AppController {

	private AppService service;
	public void chooseSystem(int selectNumber) {
		switch(selectNumber) {
		case 1:
			service = new memberService();
			break;
		case 2:
			service = new HealthManage();
			break;
		}
		
	}

//		private AppService service;
		
		
}
