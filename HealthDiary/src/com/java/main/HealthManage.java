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
				//				showAllExercise();
				searchExerciseData();
				break;

			case 2:
				System.out.println("네 무엇인가요?");
				System.out.print(">>> ");
				String answer = inputString();
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★3");
				if(answer.equals("")) {
					System.out.println("아무 값이 입력되지 않았어요. 다시 입력해주세요.");
					return;
				}
				System.out.println(answer + " 이(가) 추가되었습니다.");
				break;

			default:
				System.out.println("다시 말씀해주세요~");
				break;
			}
			break;
		}

		String newExe = inputString();
		Exercise newExercise = new Exercise();
		newExercise.setExe_name(newExe);
		ExerciseRepository repository = new ExerciseRepository();

		boolean wantToExercise = true;
		while(wantToExercise) {

			System.out.println(newExercise.getExe_name() + " 운동 지금 하실래요?(Y/N)");
			System.out.print(">>> ");
			String exeRn = inputString();
			if(exeRn.toUpperCase().equals("Y")) {
				//				exerciseProcess(0);
			} else if(exeRn.toUpperCase().equals("N")){
				System.out.println("알겠습니다. 목록에만 추가하도록 하겠습니다.aaaaaaaaa");
				repository.addExercise(newExercise);   //추가
				wantToExercise = false;
			} else {
				System.out.println("다시 입력해주세요.");

			}	
		}
	}


	private void searchExerciseData() {
		//				searchExerciseData();
		final List<Exercise> exerciseList = exerciseRepository.searchByExercise("true");
		if(exerciseList.size() > 0) {
			for(Exercise E : exerciseList) {
				System.out.println(E);
			}
			System.out.printf("운동 종목 개수 %d건", exerciseList.size());
			System.out.println("==================================");
			System.out.println("이중에 하고싶은 운동 있으시면 알려주세요! 없다면 0을 입력해주세요.");
			System.out.print(">>> ");
			int exe_num = inputInteger();

			if(exe_num != 0) {
				if(exerciseList.contains(exe_num)) {
//					exerciseProcess(exe_num);
				} else {
					System.out.println("다시 입력해주세요.");
					return;
				}
			} else {
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
				//				return exerciseManagementScreen();
			}

		} else { //exerciseList.size() = 0
			System.out.println("목록이 없네요. 저희 새로운 운동을 시작해야겠어요!");
			return;
		}

	}


}


