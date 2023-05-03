package com.healthDiary.member.service;
import static com.healthDiary.view.AppUI.inputInteger;
import static com.healthDiary.view.AppUI.inputString;

import com.healthDiary.common.AppService;
public class MemberService implements AppService {

	@Override
	public void Start() {
		while (true) {
			userManagementScreen();
			int selection = inputInteger();
		}

	}
	
	//1. 신규 등록
	private void userManagementScreen() {
		System.out.println("\n신규 등록");
		
		
	}

}
