package com.java.main;

import static com.java.view.AppUI.exerciseManagementScreen;
import static com.java.view.AppUI.inputInteger;
import static com.java.view.AppUI.inputString;

import java.util.List;

import com.java.common.AppService;
import com.java.exercise.domain.Exercise;
import com.java.exercise.repository.ExerciseRepository;
public class HealthManage implements AppService {

	private ExerciseRepository exerciseRepository = new ExerciseRepository();
//	private Exercise exercise;
//	public HealthManage(String name) {
//		exercise = new Exercise(name);
//	}
	
	Exercise exercise = new Exercise();
//	HealthManage healthManage = new HealthManage();
//	healthManage.showAllExercise();
	
	@Override
	public void start() {
		exerciseManagementScreen();
		int selection = inputInteger();

		switch (selection) {
		case 1:  //운동 추가
			insertExercise();
			break;
		case 2:  //운동 목록 조회
			showSearchResult();
//			ExerciseRepository.showAllExercise();
			break;
		case 3:  //운동 삭제
//			deleteExercise();
			break;
		default:
			System.out.println("다시 말씀해주세요~");
		}
	}

	private int showSearchResult() {
		List<Exercise> exercises = showAllExercise();
		
		if(exercises.size() > 0) {
			System.out.println("\n운동 목록 조회 결과");
			for(Exercise exercise: exercises) {
				System.out.println(exercise);
			}
		} else {
			System.out.println("\n조회된 운동이 없습니다.");
		}
		return exercises.size();
	}
	

	private List<Exercise> showAllExercise() {
		// TODO Auto-generated method stub
		return null;
	}

//	private void delExercise() {
//		if() {
//			System.out.println("\n어떤 운동을 그만하고싶으세요?");
//			System.out.print(">>> ");
//			String selection = inputString();
//			System.out.println("★★★★★★★★ press Enter ★★★★★★★★4");
//			
//		}
//	}

	private void insertExercise() {
		while (true) {
			System.out.println("\n어떤 운동 하고싶으세요?");
			System.out.println("1. 추천해주세요!");
			System.out.println("2. 제가 하고싶은 운동은요~");
			System.out.print(">>> ");
			int selection = inputInteger();
			System.out.println("★★★★★★★★ press Enter ★★★★★★★★2");
			switch (selection) {
			case 1:
				showAllExercise();
				break;

			case 2:
				System.out.println("네 무엇인가요?");
				System.out.print(">>> ");
				String answer = inputString();
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★3");
				System.out.println(answer + " 이(가) 추가되었습니다.");
				break;

			default:
				System.out.println("다시 말씀해주세요~");
				break;
			}
			break;
		}

		
	}



}
