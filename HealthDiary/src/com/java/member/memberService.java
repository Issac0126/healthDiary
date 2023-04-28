package com.java.member;
import static com.java.view.AppUI.inputInteger;
import static com.java.view.AppUI.inputString;

import com.java.common.AppService;
public class memberService implements AppService {

	@Override
	public void start() {
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
