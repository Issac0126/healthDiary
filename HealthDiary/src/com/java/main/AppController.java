package com.java.main;

import com.java.common.AppService;
import com.java.exercise.domain.service.ExerciseService;
import com.java.member.service.MemberService;

public class AppController {

	private AppService service;
	public void chooseSystem(int selectNumber) {
		switch(selectNumber) {
		case 1:
			service = new MemberService();
			break;
		case 2:
			service = new HealthManage();
			break;
		}
		
		service.start();		
	}
		
}
