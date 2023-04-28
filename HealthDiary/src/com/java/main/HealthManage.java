package com.java.main;

import com.java.common.AppService;

import static com.java.exercise.domain.service.ExerciseService.*;
import static com.java.exercise.repository.ExerciseRepository.*;
import static com.java.view.AppUI.exerciseManagementScreen;
import static com.java.view.AppUI.inputInteger;
import static com.java.view.AppUI.inputString;
public class HealthManage implements AppService {

	@Override
	public void start() {
		exerciseManagementScreen();
		int selection = inputInteger();

		switch (selection) {
		case 1:
			addExercise();
			break;
		case 2:
//			showAllExercise();
			break;
		case 3:
//			delExercise();
			break;
		default:
			System.out.println("다시 말씀해주세요~");
		}
	}

	private void addExercise() {
		while (true) {
			System.out.println("어떤 운동 하고싶으세요?");
			System.out.println("1. 추천해주세요!");
			System.out.println("2. 제가 하고싶은 운동은요~");
			System.out.print(">>> ");
			int selection = inputInteger();
			String answer = inputString();
			switch (selection) {
			case 1:
//				showAllExercise();
				break;

			case 2:
				System.out.println("네 무엇인가요?");
				System.out.print(">>> ");
				inputString();
				break;

			default:
				System.out.println("다시 말씀해주세요~");
			}

		}

	}




}
