package com.healthDiary.exercise.repository;

import static com.healthDiary.view.AppUI.inputString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthDiary.common.DataBaseConnection;
import com.healthDiary.exercise.domain.Exercise;

public class ExerciseRepository {

	private DataBaseConnection	connection = DataBaseConnection.getInstance();


	public int addExercise(Exercise newExercise) {
		String sql = "INSERT INTO exercise "
				+ "(exe_num, exe_name , exe_measure) "
				+ "VALUES(exercise_seq.NEXTVAL,?,?)";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, newExercise.getExe_name());
			pstmt.setString(2, newExercise.getExe_measure());
			if(pstmt.executeUpdate() == 1) {
				System.out.printf("\n%s운동을 등록했습니다!", newExercise.getExe_name());
			} else {
				System.out.printf("\n%s운동 등록에 실패했습니다ㅠㅠ", newExercise.getExe_name());
			}
			System.out.println("\n----------PRESS ENTER KEY----------");
            inputString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}


	public void showAllExercise() {}	

	//운동 목록 조회
	public List<Exercise> searchByExercise(int exe_num, String exe_name) {
		List<Exercise> exerciseList = new ArrayList<>();
		String sql = "SELECT exe_num, exe_name FROM exercise";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, exe_num);
			pstmt.setString(2, exe_name);	
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Exercise newExercise = new Exercise(
						//////////
						rs.getInt("exe_num"),
						rs.getString("exe_name"),
						rs.getString("exe_measure")
						);

				exerciseList.add(newExercise);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exerciseList;
	}


	public Object getExercise(int exe_num) {
		return null;
	}

	private List<Exercise>exercise;
	public void deleteExercise(String select) {}

}
