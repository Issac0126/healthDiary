package com.healthDiary.main;

import static com.healthDiary.view.AppUI.inputInteger;

import com.healthDiary.view.AppUI;

public class Main {
	public static void main(String[] args) {

		AppController controller = new AppController();
		
		while(true) {
			AppUI.startScreen();
			int selectNumber = inputInteger();
			controller.chooseSystem(selectNumber);
		}
	}
}
