
package com.healthDiary.member.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthDiary.common.DataBaseConnection;
import com.healthDiary.member.domain.Member;

public class MemberRepository {

	private DataBaseConnection connection = DataBaseConnection.getInstance();
	
	
	public void addNewMember(Member member) {
		
		System.out.print(member.getMemberName());
		String sql = "INSERT INTO member "
				+ "(member_number, member_name, phone_number) "
				+ "VALUES(member_seq.NEXTVAL,?,?)";
		
		
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getPhoneNum());
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("님이 신규 등록되었습니다");
			} else {
				System.out.println("miss you");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	public List<Member> findMemberList(String memberName) {
		
		List<Member> memberList = new ArrayList<>();
		String sql = "SELECT * FROM member WHERE member_name=?";
		
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, memberName);
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				Member member = new Member(
						
						result.getInt("member_number"),
						result.getString("member_name"),
						result.getString("phone_number"),
						result.getString("grade"),
						result.getDate("reg_date")
						);
				memberList.add(member);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberList;
		
	}
	
	
	
	
	
	public List<Member> searchMemberList() {

		List<Member> allMemberList = new ArrayList<>();
		String sql = "SELECT * FROM member";

		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet result = pstmt.executeQuery();) {

			while(result.next()) {
				Member member = new Member(
						
						result.getInt("member_number"),
						result.getString("member_name"),
						result.getString("phone_number"),
						result.getString("grade"),
						result.getDate("reg_date")
						);
				allMemberList.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return allMemberList;
	}
	
	
	
	
	public void deleteMember(int delMemberNum) {
		String sql = "DELETE FROM member WHERE member_number=?";
//		String sql2 = "SELECT member_name FROM member WHERE member_number";
//		String userName = null;
		
		
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
//			Connection conn2 = connection.getConnection();
//			PreparedStatement pstmt2 = conn.prepareStatement(sql2)
//			
//			ResultSet name = pstmt2.executeQuery();
//			
//			
//			while(name.next()) {
//				if(name.getInt("member_number") == delMemberNum) {
//					userName = name.getString("member_name");
//					System.out.println(name);
//					System.out.println(userName);
//				}
//			}
			
			pstmt.setInt(1, delMemberNum);
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("회원 정보가 정상 삭제되었습니다");
			} else {
				System.out.println("삭제하지 못하였습니다");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateMember(String grade, int memberNum) {
		
		String sql = "UPDATE member SET grade=? WHERE member_number=?";
		
		try(Connection conn = connection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			System.out.println(grade);
//			System.out.println(memberNum);
			pstmt.setString(1, grade);
			pstmt.setInt(2, memberNum);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
