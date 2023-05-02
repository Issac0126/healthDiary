package com.java.exercise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.common.DataBaseConnection;
import com.java.exercise.domain.Exercise;
//import com.java.exercise.repository.*;
//import com.java.main.HealthManage;
//import com.java.exercise.domain.service.ExerciseService;
//import java.util.ArrayList;
//import java.util.List;
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

INSERT INTO exercise
VALUES (exercise_seq.NEXTVAL, '스쿼트', 'C');
INSERT INTO exercise
VALUES (exercise_seq.NEXTVAL, '러닝머신', 'S');

DELETE FROM exercise
WHERE exe_num = 1;*/

	public int addExercise(Exercise newExercise) {
		//void??
		String sql = "INSERT INTO exercise "
				+ "(exe_num, exe_name , exe_measure) "
				+ "VALUES(exercise_seq.NEXTVAL,?,?)";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, newExercise.getExe_name());
			pstmt.setString(2, newExercise.getExe_measure());
			if(pstmt.executeUpdate() == 1) {
				System.out.printf("\n%s운동을 등록했습니다!", newExercise.getExe_name());
				//여기까진 성공!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			} else {
				System.out.printf("\n%s운동 등록에 실패했습니다ㅠㅠ", newExercise.getExe_name());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}


	public void showAllExercise() {

		//		try (Connection conn = connection.getConnection();
		//				PreparedStatement pstmt = conn.prepareStatement(
		//						"INSERT INTO newExercise (exe_name) VALUES(?)")){
		//			pstmt.setString(1, exercise.getExe_name());
		//			pstmt.executeUpdate();
		//		} catch (SQLException e) {
		//			e.printStackTrace();
		//		}
		//		
	}	

	//운동 목록 조회
	public List<Exercise> searchByExercise(String exe_name) {
		List<Exercise> exerciseList = new ArrayList<>();
		String sql = "SELECT exe_name FROM exercise";
//		if(exe_name.equals("true")) {
//			sql = "SELECT * FROM exercise WHERE exercise = 'true'";
//		}
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, exe_name);	
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Exercise newExercise = new Exercise(
						//////////
						rs.getInt("exe_num"),
						rs.getString("exe_name"),
						rs.getString("exe_measure")
						);

				exerciseList.add(newExercise);
				///////////
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exerciseList;
	}


	public Object getExercise(int exe_num) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Exercise>exercise;
	
	public void deleteExercise(String select) {}



}
