package com.java.exercise.domain.service;

import static com.java.view.AppUI.*;

import java.util.List;

import com.java.common.AppService;
import com.java.exercise.domain.Exercise;
import com.java.exercise.repository.ExerciseRepository;
import com.java.member.repository.*;
import com.java.member.domain.Member;

public class ExerciseService implements AppService{

	private final MemberRepository memberRepository = new MemberRepository();
	private final ExerciseRepository exerciseRepository = new ExerciseRepository();

	@Override
	public void start() {
		while (true) {
			exerciseManagementScreen();
			int selection = inputInteger();

			switch (selection) {
			case 1:

				break;
			case 2:
//				showAllExercise();
				break;
			case 3:

				break;

			default:
				break;
			}
		}

	}

	//운동 조회
	private List<Exercise> searchExerciseData() {
		System.out.println("운동 목록 보여드릴게요.");
		return null;
		
	}
	
//	public void showAllExercise() {
//		List<Exercise> exerciseList = exerciseRepository.searchByExercise("true");
//				//searchExerciseData();
//		int count = exerciseList.size();
	
//		if(exerciseList.size() > 0) {
//			for(Exercise Exercise : exerciseList) {
//				System.out.println(Exercise);
//			}
//		System.out.printf("운동 종목 개수 %d건", count);
//	System.out.println("==================================");
//	System.out.println("이중에 하고싶은 운동 있으시면 알려주세요! 없다면 0을 입력해주세요.");
//	System.out.print(">>> ");
//	int exe_num = inputInteger();
//
//	if(exe_num != 0) {
//		exerciseProcess(exe_num);
//	}
//	중복확인 어떻게 하지...
//	return;
//		} else {
//			System.out.println("목록이 없네요. 저희 새로운 운동을 시작해야겠어요!");
//		}
//		
//	}

	//운동 수행하기
	private void exerciseProcess(int exe_num) {
		System.out.println("성함을 다시 한 번 알려주세요.");
		System.out.print(">>>");
		String name = inputString();
		
		List<Member> members = memberRepository.findByMemberName(name);
	}
	
}
