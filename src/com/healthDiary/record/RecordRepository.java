package com.healthDiary.record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.healthDiary.common.DataBaseConnection;
import com.healthDiary.exercise.Exercise;

public class RecordRepository {
	
	private DataBaseConnection connection = DataBaseConnection.getInstance();
	
	

	// 가능한 운동 목록 출력 
	public List<Exercise> exeListSearch(String sql) {
		List<Exercise> exeList = new ArrayList<Exercise>();
		
		try (Connection conn = connection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			){
				while(rs.next()) {
					Exercise exe = new Exercise(
								rs.getInt("exe_num"),
								rs.getString("exe_name"),
								rs.getString("exe_measure")
					);
					exeList.add(exe);
				} //while END

		}catch (Exception e) {
			e.printStackTrace();
		} // try END 
	
		return exeList;
	}
		
	
	

	//특정 번호의 컬럼 반환하기
	public ResultSet ExeNumToName(int exeNum) {
		String sql = "SELECT * FROM exercise WHERE exe_num = '"+exeNum+"';";
		
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
					while(rs.next()) {
						if(rs.getInt("exe_num") == exeNum) {
							return rs;
						}
					}
			}catch (Exception e) {
				e.printStackTrace();
			} // try END 
		return null;

	}
	
	
	
	
	
	
	
	
	
	
	
	

}
