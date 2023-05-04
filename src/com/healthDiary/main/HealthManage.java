package com.healthDiary.main;

import static com.healthDiary.view.AppUI.exerciseScreen;
import static com.healthDiary.view.AppUI.inputInteger;
import static com.healthDiary.view.AppUI.inputString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.healthDiary.common.AppService;
import com.healthDiary.common.DataBaseConnection;
import com.healthDiary.exercise.domain.Exercise;
import com.healthDiary.exercise.repository.ExerciseRepository;
import com.healthDiary.record.RecordRepository;
import com.healthDiary.record.RecordStart;


public class HealthManage implements AppService {

	private ExerciseRepository exerciseRepository = new ExerciseRepository();
	private DataBaseConnection	connection = DataBaseConnection.getInstance();
	private final RecordStart recordStart = new RecordStart();
	Exercise exercise = new Exercise();

	@Override
	public void Start() {
		exerciseScreen();
		int selection = inputInteger();

		switch (selection) {
		case 1:  //운동 추가
			insertExercise();
			break;
		case 2:  //운동 목록 조회
			searchExerciseData();
			break;
		case 3:  //운동 삭제
			delExercise();
			break;
		default:
			System.out.println("다시 말씀해주세요~\n");
		}
	}
	private void searchExerciseData() {
        String sql = "SELECT exe_num, exe_name FROM exercise ORDER BY exe_num";
        try (Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            int count = 0;
            System.out.println("\n\n운동 목록 보여드릴게요.");
            System.out.println();
            while (rs.next()) {
                int exeNum = rs.getInt("exe_num");
                String exeName = rs.getString("exe_name");
                System.out.println(exeNum + "번 운동: " + exeName);
                count++;
            }
            System.out.printf("★★★★★★★★ 총 %d건 ★★★★★★★★\n", count);
            System.out.println("\n\n----------PRESS ENTER KEY----------");
            inputString();
        }catch (SQLException e) {
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
			System.out.println("\n\n어떤 운동을 그만하고싶으세요?");
			System.out.println();
			while (rs.next()) {
				String exeName = rs.getString("exe_name");
				System.out.println("★ "+exeName);
				count++;
			}    
			System.out.printf("총 %d건", count);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.print("\n★ 삭제할 운동명: ");
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
			System.out.println("\n\n----------PRESS ENTER KEY----------");
            inputString();
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
				System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
				if(answer.equals("")) {
					System.out.println("아무 값이 입력되지 않았어요. 다시 입력해주세요.");
					return;
				}
				System.out.println(answer + " 이(가) 추가되었습니다.");
				System.out.println(answer + "이 시간을 재는 운동이면 'S'를, "
						+ "횟수를 재는 운동이면 'C'를 입력해주세요.");
				System.out.print(">>> ");
				String answer2 = inputString();
				if(!answer2.equals("C") || answer2.equals("S") || answer2.equals("T")) {
					System.out.println("잘못된 입력값이에요.");
					break;
				}
				exercise.setName(answer);
				exercise.setExe_measure(answer2);
				
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
				System.out.println("운동하러 가시죠!!!");
				recordStart.exeStart();
			} else if(exeRn.toUpperCase().equals("N")){
				wantToExercise = false;
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