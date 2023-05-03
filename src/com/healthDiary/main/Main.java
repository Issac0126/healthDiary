package com.healthDiary.main;

import com.healthDiary.view.AppUI;

public class Main {

	public static void main(String[] args) {
		
		AppController controller = new AppController();
		
		while(true) {
			
			AppUI.startScreen();
			int selectNumber = AppUI.inputInteger();
			controller.chooseSystem(selectNumber);
		}

	}

}
