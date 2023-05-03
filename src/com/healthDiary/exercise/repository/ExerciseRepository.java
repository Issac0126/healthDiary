package com.healthDiary.exercise.repository;

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
	/*
 	CREATE TABLE member (
    member_number	NUMBER(10) PRIMARY KEY NOT NULL,
    member_name VARCHAR2(20) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    grade VARCHAR2(10) DEFAULT 'BRONZE' NOT NULL,
    reg_date DATE DEFAULT sysdate NOT NULL,
    in_room	VARCHAR2(5)	DEFAULT 'false' NOT NULL
	);

	DROP TABLE member;

	CREATE TABLE exercise (
		exe_num	NUMBER(10)		NOT NULL,
		exe_name	VARCHAR2(30)		NOT NULL,
		exe_measure	VARCHAR2(20)		NULL
	);
	
	CREATE TABLE record (
		record_num	NUMBER(10)	NOT NULL PRIMARY KEY,
		user_number	NUMBER(10)	NOT NULL,
		exe_num	NUMBER(10)	NOT NULL,
		record_score NUMBER(10)	NOT NULL,
		exe_level	NUMBER(10)	NOT NULL,
		record_day DATE DEFAULT sysdate	NULL
	);
	
	
	SELECT * FROM member;
	SELECT * FROM exercise;
	SELECT * FROM record;
	DROP TABLE exercise;
	
	CREATE SEQUENCE member_seq
	    START WITH 1
	    MAXVALUE 10000;
	
	CREATE SEQUENCE exercise_seq
	    START WITH 1
	    MAXVALUE 10000;
	
	CREATE SEQUENCE record_seq
	    START WITH 1
	    MAXVALUE 10000;
	
	DROP SEQUENCE exercise_seq;

	DELETE FROM exercise
	WHERE exe_num = 1;*/

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
