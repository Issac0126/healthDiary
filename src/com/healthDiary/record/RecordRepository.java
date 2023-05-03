package com.healthDiary.record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
									rs.getDate("reg_date")
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
		public List<RecordAll> RecNumToDate(int memNum) {
			String sql = "SELECT * FROM record r"
					+ " LEFT JOIN exercise e ON r.exe_num = e.exe_num"
					+ " LEFT JOIN member m ON r.member_number = m.member_number"
					+ " WHERE r.member_number = '"+memNum+"' ORDER BY r.record_day ASC";
			List<RecordAll> selRec = new ArrayList<RecordAll>();
			
			try (Connection conn = connection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery()
					){
						
						while(rs.next()) {
							RecordAll rec = new RecordAll(
										rs.getInt("record_num"),
										rs.getInt("member_number"),
										rs.getInt("exe_num"),										
										rs.getString("member_name"),
										rs.getString("exe_name"),
										rs.getString("exe_measure"),
										rs.getInt("record_score"),
										rs.getDate("record_day")
								);
								selRec.add(rec);
							}
						return selRec;
			}catch (Exception e) {
				e.printStackTrace();
			} // try END 
			return null;

		}


	//기록: 기록 추가하기
		public void RecAdd(RecordAll recAll) {	
			String sql = "INSERT INTO record VALUES (record_seq.NEXTVAL, "
					+recAll.getUserNum()+", "+recAll.getExeNum()+", "+recAll.getRecordScore()+", sysdate)";
			
			try(Connection conn = connection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
				
				pstmt.executeUpdate();	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
	
	
	
	
	

}
