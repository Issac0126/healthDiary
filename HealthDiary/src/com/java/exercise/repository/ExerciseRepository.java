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

	public void addExercise(Exercise newExercise) {
		String sql = "INSERT INTO exercise "
				+ "(exe_num, exe_name) "
				//, exe_measure
				+ "VALUES(exercise_seq.NEXTVAL,?)";
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			//			pstmt.setInt(1, newExercise.getExe_num());
			pstmt.setString(1, newExercise.getExe_name());
//			pstmt.setString(2, newExercise.getExe_measure());
			if(pstmt.executeUpdate() == 1) {
				System.out.printf("\n%s 운동을 등록했습니다!", newExercise.getExe_name());
			} else {
				System.out.println("\n%s 운동 등록에 실패했습니다ㅠㅠ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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
	//	private DataBaseConnection connection = DataBaseConnection.getInstance();
	//		이건 sql 데이터 연결시키고 해야지

	//		String sql = "INSERT INTO newExercise "
	//				+ "(exe_name) VALUES(exercise_seq.NEXTVAL,?)";


 	//CREATE SEQUENCE exercise_seq
	public List<Exercise> searchByExercise(String exercise) {
		List<Exercise> exerciseList = new ArrayList<>();
		String sql = "";
		if(exercise.equals("true")) {
			sql = "SELECT * FROM exercise WHERE exercise = 'true'";
		}
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Exercise exercise1 = new Exercise(
						//////////
						rs.getInt("exe_num"),
						rs.getString("exe_name"),
						rs.getString("exe_measure")
						);
				//					int exerciseNum = rs.getInt("exe_num");
				//					String exerciseName = rs.getString("exe_name");
				//					String exerciseMeasure = rs.getString("exe_measure");
				//					exerciseList.add(new Exercise(exerciseNum, exerciseName, exerciseMeasure));
				exerciseList.add(exercise1);
				///////////
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exerciseList;
	}




}
