package com.healthDiary.exercise.service;

import static com.healthDiary.view.AppUI.exerciseScreen;
import static com.healthDiary.view.AppUI.inputInteger;
import static com.healthDiary.view.AppUI.inputString;

import java.util.List;

import com.healthDiary.common.AppService;
import com.healthDiary.exercise.domain.Exercise;
import com.healthDiary.exercise.repository.ExerciseRepository;
import com.healthDiary.member.repository.MemberRepository;
import com.healthDiary.record.RecordStart;

public class ExerciseService implements AppService{

	private final MemberRepository memberRepository = new MemberRepository();
	private final ExerciseRepository exerciseRepository = new ExerciseRepository();

	@Override
	public void Start() {
		while (true) {
			exerciseScreen();
			int selection = inputInteger();
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★1");
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
//					exeStart(exe_num);
				} else {
					System.out.println("다시 입력해주세요.");
					return;
				}
			} else {
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}

		} else { //exerciseList.size() = 0
			System.out.println("목록이 없네요. 저희 새로운 운동을 시작해야겠어요!");
			return;
		}

	}


	//3. 운동 삭제
	public void deleteExercise() {
		System.out.println("어떤 운동을 그만하고싶으세요?");
		showAllExercise();
		System.out.print(">>> ");
		int delExe = inputInteger();
		if(exerciseList.contains(delExe)){
			System.out.println("정말 삭제할까요?(Y/N)");
			String delAnswer = inputString();
			if(delAnswer.equals("Y")) {
				exerciseList.remove(delExe);
			} else if(delAnswer.equals("N")){
				System.out.println("그럼 다시 한 번 생각해봐야겠네요.");
				return;
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
