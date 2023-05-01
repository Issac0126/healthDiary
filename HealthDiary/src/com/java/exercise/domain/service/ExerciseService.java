package com.java.exercise.domain.service;

import static com.java.view.AppUI.exerciseManagementScreen;
import static com.java.view.AppUI.inputInteger;
import static com.java.view.AppUI.inputString;

import java.util.List;

import com.java.common.AppService;
import com.java.exercise.domain.Exercise;
import com.java.exercise.repository.ExerciseRepository;
import com.java.member.repository.MemberRepository;

public class ExerciseService implements AppService{

	private final MemberRepository memberRepository = new MemberRepository();
	private final ExerciseRepository exerciseRepository = new ExerciseRepository();

	@Override
	public void start() {
		while (true) {
			exerciseManagementScreen();
			int selection = inputInteger();
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★1");
			switch (selection) {
			case 1:
				insertExercise();
				break;
			case 2:
//				showAllExercise();
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
	private List<Exercise> exerciseList = exerciseRepository.searchByExercise("true");
	public void showAllExercise() {
		//				searchExerciseData();

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
					exerciseProcess(exe_num);
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


	//3. 운동 삭제
	public void deleteExercise() {
		System.out.println("어떤 운동을 그만하고싶으세요?");
		showAllExercise();
		System.out.print(">>> ");
		int delExe = inputInteger();
		//int String 중에 어떤걸로 받을까 int가 낫겠지
		if(exerciseList.contains(delExe)){
			System.out.println("정말 삭제할까요?(Y/N)");
			String delAnswer = inputString();
			if(delAnswer.equals('Y')) {
				exerciseList.remove(delExe);
			} else if(delAnswer.equals('N')){
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



	//운동 수행하기
	private void exerciseProcess(int exe_num) {
		System.out.println("여기까진 왔다!");
		
//		System.out.println("성함을 알려주세요.");
//		System.out.print(">>>");
//		String name = inputString();

//		List<Member> members = memberRepository.findByMemberName(name);
	}


}


/*
 * 신경쓸것들 목록
 * return하면 제대로 돌아가는지
 * 운동 수행하기에서 이름 입력해서 넣는거 맞는건지
 * sql 반영시켜서 변수명 바꾸기
 * 멘트 수정할게 있으면 좀 바꾸기
 * 다른 멤버들꺼 pull해서 합쳐보기
 * 종목 조회를 이름 입력받기보다 종목 개수가 얼마 되지 않으니 전체 조회로 하는게 어떤지 제안하기
 */