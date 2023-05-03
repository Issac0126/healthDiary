package com.healthDiary.exercise.service;

import static com.healthDiary.view.AppUI.exerciseScreen;
import static com.healthDiary.view.AppUI.inputInteger;
import static com.healthDiary.view.AppUI.inputString;

import java.util.ArrayList;
import java.util.List;

import com.healthDiary.common.AppService;
import com.healthDiary.exercise.domain.Exercise;
import com.healthDiary.exercise.repository.ExerciseRepository;
import com.healthDiary.record.RecordStart;

public class ExerciseService implements AppService{

	private final RecordStart recordStart = new RecordStart();
	private final ExerciseRepository exerciseRepository = new ExerciseRepository();

	@Override
	public void Start() {
		while (true) {
			exerciseScreen();
			int selection = inputInteger();
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			switch (selection) {
			case 1:
				insertExercise();
				break;
			case 2:
				searchExerciseData();
				break;
			case 3:
				deleteExercise();
				break;
			default:
				System.out.println("다시 말씀해주세요.");
				break;
			}
			inputString();
		}

	}


	//1. 운동 추가
	private void insertExercise() {}

	//2. 운동 조회
		private List<Exercise> searchExerciseData() {
			System.out.println("운동 목록 보여드릴게요.");
			return null;
		}
	private List<Exercise> exerciseList = exerciseRepository.searchByExercise(0, "true");
	public void showAllExercise() {
//		List exeNumList = new ArrayList<>();
		
		if(exerciseList.size() > 0) {
			for(Exercise E : exerciseList) {
				System.out.println(E);
//				exeNumList.add(E.getExe_num());
			}
			System.out.printf("운동 종목 개수 %d건", exerciseList.size());
			System.out.println("==================================");
//			System.out.println("이 중에 하고 싶은 운동이 있으시면 알려주세요! 없다면 0을 입력해 주세요.");
//			System.out.print("> ");
//			int exeNum = inputInteger();
//
//			if(exeNum == 0) {
//				System.out.println("이전 메뉴로 돌아갑니다.");
//				return;
//			}
//			if(exeNumList.contains(exeNum)) {
//				recordStart.exeStart();
//			} else {
//				System.out.println("다시 입력해주세요.");
//				return;
//			}
			
		} else { //exerciseList.size() = 0
			System.out.println("목록이 없네요. 저희 새로운 운동을 시작해야겠어요!");
			System.out.println("▷ Y 입력으로 운동목록 추가하러 가기");
			System.out.print("▶ ");
			String answer = inputString().toUpperCase();
			if(answer.equals("Y")) insertExercise();
			else {
				System.out.println("추가 안하시나요? 왜죠... 아쉽습니다... \n");
				System.out.println(" --★--> Enter <--★-- ");
				inputString();
			}
			return;
		}

	}


	//3. 운동 삭제
	public void deleteExercise() {
		System.out.println("어떤 운동을 그만하고 싶으세요?");
		showAllExercise();
		System.out.print(">>> ");
		int delExe = inputInteger();
		if(exerciseList.contains(delExe)){
			System.out.println("정말 삭제할까요?(Y/N)");
			String answer = inputString().toUpperCase();
			
			if(answer.equals("Y")) {
				System.out.println("운동하러 가시죠!!!");
				recordStart.exeStart();
			} else if(answer.equals("N")) {
				System.out.println("운동 안하시나요? 아쉽습니다......");
			} else {
				System.out.println("다시 입력해주세요.");
			}

		} else {
			System.out.println("다시 입력해주세요.");
			return;
		}

	}



//	//운동 수행하기
//	public void exerciseProcess(int exe_num) {
//		System.out.println("운동을 시작합니다!");
//		System.out.println("시간 잴게요!");
//		
//		long beforeTime = System.currentTimeMillis(); //시작
//        		        
//		long afterTime = System.currentTimeMillis(); // 끝
//		long secDiffTime = (afterTime - beforeTime)/1000;
//		System.out.println("수행시간: " + secDiffTime + "초");
//
//	}


}
