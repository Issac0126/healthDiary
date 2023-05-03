package com.healthDiary.record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.healthDiary.common.DataBaseConnection;
import com.healthDiary.exercise.domain.Exercise;
import com.healthDiary.member.domain.Member;

public class RecordRepository {
	
	private DataBaseConnection connection = DataBaseConnection.getInstance();
	
	

	// 가능한 운동 목록 반환
	public List<Exercise> exeListSearch(String sql) {
		List<Exercise> exeList = new ArrayList<Exercise>();
		
		try (Connection conn = connection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()
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
	
	
	// 회원 목록 반환
		public List<Member> memListSearch(String sql) {
			List<Member> memList = new ArrayList<Member>();
			
			try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()
				){
				
					while(rs.next()) {
						Member mem = new Member(
									rs.getInt("member_number"),
									rs.getString("member_name"),
									rs.getString("phone_number"),
									rs.getString("grade"),
									rs.getDate("reg_date"),
									rs.getString("in_room")
						);
						memList.add(mem);
					} //while END

			}catch (Exception e) {
				e.printStackTrace();
			} // try END 
		
			return memList;
		}
		
	
	

	//운동: 특정 번호의 컬럼 반환하기
	public List<String> ExeNumToName(int exeNum) {
		String sql = "SELECT * FROM exercise WHERE exe_num = '"+exeNum+"'";
		List<String> selExeTwo = new ArrayList<String>();
		
		try (Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()
				){
					while(rs.next()) {
						if(rs.getInt("exe_num") == exeNum) {
							selExeTwo.add(rs.getString("exe_name"));
							selExeTwo.add(rs.getString("exe_measure"));
							return selExeTwo;
						}
					}
			}catch (Exception e) {
				e.printStackTrace();
			} // try END 
		return null;

	}
	
	
	//기록: 특정 번호의 컬럼 반환하기
		public List<Record> Rec(int memNum) {
			String sql = "SELECT * FROM record WHERE member_number = '"+memNum+"'";
			List<Record> selRec = new ArrayList<Record>();
			
			try (Connection conn = connection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery()
					){
						
				
//						while(rs.next()) {
//							Record rec = new Record(
//										rs.getInt("record_num"),
//										rs.getInt("member_number"),
//										rs.getInt("exe_num"),
//										rs.getInt("record_score"),
//										rs.getInt("exe_level"),
//										rs.getDate("record_day")
//								);
//								selRec.add(rec);
//							}
			}catch (Exception e) {
				e.printStackTrace();
			} // try END 
			return null;
			

		}

	
//		public Record(int recordNum, int userNumber, int exeNum, int recordScore, int exeLevel,
//				LocalDateTime recordDay)
	
	
	
	
	
	

}
