package com.java.main;

import static com.java.view.AppUI.exerciseManagementScreen;
import static com.java.view.AppUI.inputInteger;
import static com.java.view.AppUI.inputString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.java.common.AppService;
import com.java.common.DataBaseConnection;
import com.java.exercise.domain.Exercise;
import com.java.exercise.repository.ExerciseRepository;


public class HealthManage implements AppService {

	private ExerciseRepository exerciseRepository = new ExerciseRepository();
	private DataBaseConnection	connection = DataBaseConnection.getInstance();
	Exercise exercise = new Exercise();

	@Override
	public void start() {
		exerciseManagementScreen();
		int selection = inputInteger();

		switch (selection) {
		case 1:  //운동 추가
			insertExercise();
			break;
		case 2:  //운동 목록 조회
			searchExerciseData();
			//			ExerciseRepository.showAllExercise();
			break;
		case 3:  //운동 삭제
			delExercise();
			break;
		default:
			System.out.println("다시 말씀해주세요~");
		}
	}
	private void searchExerciseData() {
		String sql = "SELECT exe_name FROM exercise";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			int count = 0;
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("\n운동 목록 보여드릴게요");
			System.out.println();
			while (rs.next()) {
				String exeName = rs.getString("exe_name");
				System.out.println(exeName);
				count++;
			}    
			System.out.printf("===========총 %d건===========\n", count);
		}catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("이중에 하고싶은 운동 있으시면 알려주세요! 없다면 0을 입력해주세요.");
		System.out.print(">>> ");
		String workOut = inputString();

		if(workOut.equals("0")) {
			System.out.println("----------------PRESS ENTER KEY----------------");
			return;
		}

		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"SELECT * FROM exercise WHERE exe_name = ?")) {
			pstmt.setString(1, workOut);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("운동 시작!");
				/////운동 수행 메서드////

			} else {
				System.out.println("존재하지 않는 운동이에요.");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	
	private List<Exercise> showAllExercise() {
		return Collections.emptyList();
	}

	
	
	private void delExercise() {
		String sql = "SELECT exe_name FROM exercise";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			int count = 0;
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("\n어떤 운동을 그만하고싶으세요?");
			System.out.println();
			while (rs.next()) {
				String exeName = rs.getString("exe_name");
				System.out.println(exeName);
				count++;
			}    
			System.out.printf("총 %d건", count);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.print(">>> ");
		String select = inputString();

		sql = "DELETE FROM exercise WHERE exe_name = ?";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, select);
			int a = pstmt.executeUpdate();
			if(a > 0) {
				System.out.println("그래요. 이 운동은 다음부터 하지 말아요.");
			} else {
				System.out.println("그런 운동은 없어요 회원님!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void insertExercise() {
		while (true) {
			System.out.println("\n어떤 운동 하고싶으세요?");
			System.out.println("1. 추천해주세요!");
			System.out.println("2. 제가 하고싶은 운동은요~");
			System.out.print(">>> ");
			int selection = inputInteger();
			switch (selection) {		
			case 1:
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
				exercise.setName(answer);
				exerciseRepository.addExercise(exercise);
				break;

			default:
				System.out.println("다시 말씀해주세요~");
				break;
			}
			break;
		}

		String newExe = inputString();
		exercise.setExe_name(newExe);
		ExerciseRepository repository = new ExerciseRepository();


		boolean wantToExercise = true;
		
		
		while(wantToExercise) {
			System.out.println("운동 지금 하실래요?(Y/N)");
			System.out.print(">>> ");
			String exeRn = inputString();
			if(exeRn.toUpperCase().equals("Y")) {
				//								exerciseProcess(0);
				///운동 시작 메서드////
			} else if(exeRn.toUpperCase().equals("N")){

				//				repository.addExercise(exercise);   //추가
				wantToExercise = false;
				//				return;
			} else {
				System.out.println("다시 입력해주세요.");

			}	
		}

		if(exercise.getExe_name() != null && !exercise.getExe_name().isEmpty()) {
			repository.addExercise(exercise);
			System.out.println("알겠습니다. 목록에만 추가하도록 하겠습니다!");
		}
	}


	public void exerciseProcess(int exe_num) {
		System.out.println(exerciseRepository.getExercise(exe_num));
	}


}