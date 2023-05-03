
package com.healthDiary.member.service;

import static com.healthDiary.view.AppUI.inputInteger;
import static com.healthDiary.view.AppUI.inputString;
import static com.healthDiary.view.AppUI.memberScreen;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import com.healthDiary.common.AppService;
import com.healthDiary.member.domain.Member;
import com.healthDiary.member.repository.MemberRepository;

public class MemberService implements AppService {

	private final MemberRepository memberRepository = new MemberRepository();

	@Override
	public void Start() {
		while(true) {
			memberScreen();
			upgradeMember();
			int selection = inputInteger();
			
			switch (selection) {
			case 1:
				join();
				break;
			case 2:
				showMemberList();
				break;
			case 3:
				deleteMember();
				break;
			case 4:
				allList();
				break;
			case 5:
				return;


			default:
				System.out.println("메뉴를 다시 입력해주세요");
			}
		}
		
	}
	
	
	private void join() {
		
		while(true) {
			System.out.print("이름: ");
			String memberName = inputString();
			
			System.out.print("전화번호: ");
			String phoneNum = inputString();
			
			if(memberName.length() > 5 || memberName.length() < 2) {
				System.out.println("주민등록상의 이름을 입력해주세요");
				break;
			} else if(phoneNum.length() != 13) {
				System.out.println("'-'을 포함해 전화번호를 입력해주세요");
				break;
			} else {
				System.out.println("새로운 회원 정보가 정상 등록되었습니다");
				Member member = new Member();
				member.setMemberName(memberName);
				member.setPhoneNum(phoneNum);
				memberRepository.addNewMember(member);
				break;
			}			
		}
	}
	
	
	
	private List<Member> searchMember() {
		System.out.print("조회할 회원의 이름: ");
		String name = inputString();
		
		return memberRepository.findMemberList(name);
		
	}
	
	
	private int showMemberList() {
		List<Member> members = searchMember();
		
		if(members.isEmpty()) {
			System.out.println("등록된 회원이 없습니다");
		} else {
			System.out.println("조회된 회원 결과: " + members.size() + "명");
			for(int i=0; i<members.size(); i++) {
				System.out.println("회원번호:" + members.get(i).getMemberNum() + " 이름:" +
						members.get(i).getMemberName() + " 전화번호:" +
						members.get(i).getPhoneNum() + " 가입일:" +
						members.get(i).getRegDate() + " 등급:" +
						members.get(i).getGrade()
				);
			}			
		}
		return members.size();
		
	}
	
	
	private void allList() {
		List<Member> allMember = memberRepository.searchMemberList();
		
		System.out.println("조회된 회원 결과: " + allMember.size() + "명");
		
		for(int i=0; i<allMember.size(); i++) {
			System.out.println("회원번호:" + allMember.get(i).getMemberNum() + 
					" 이름:" + allMember.get(i).getMemberName() + 
					" 전화번호:" + allMember.get(i).getPhoneNum() + 
					" 가입일:" + allMember.get(i).getRegDate() +
					" 등급:" + allMember.get(i).getGrade());
		}

	}
	
	
	private void deleteMember() {
		
		if(showMemberList() > 0) {
			System.out.print("탈퇴할 회원의 번호: ");
			int delMemberNum = inputInteger();
			memberRepository.deleteMember(delMemberNum);
		}
		
	}
	
	
	private void upgradeMember() {
		List<Member> upMember = memberRepository.searchMemberList();
//		List<Member> update = memberRepository.updateMember(null, null);

		
		Date memberRegDate;
		LocalDateTime memberDateTime;
		long between;

		for(int i=0; i<upMember.size(); i++) {
			memberRegDate = upMember.get(i).getRegDate();
	        memberDateTime = Instant.ofEpochMilli(memberRegDate.getTime())
	                .atZone(ZoneId.systemDefault())
	                .toLocalDateTime();
	        
	        between = ChronoUnit.YEARS.between(memberDateTime.now() , LocalDateTime.now());
//			System.out.println("비트윈"+between);
//			System.out.println("멤버데이트타임"+memberDateTime);
//	        memberDateTime = LocalDateTime.now();
//	        Date date = Date.from(memberDateTime.atZone(ZoneId.systemDefault()).toInstant());
	        
	        if(between > 1) {
	        	String silver =  "SILVER";
	    		memberRepository.updateMember(silver, upMember.get(i).getMemberNum());
	    		
//	    		System.out.println("if 들어옴"+upMember.get(i).getMemberNum());
//	        	upMember.get(i).setGrade("silver");
//	    		upMember.get(i).getMemberNum();
	        }
	        
	        if(between > 2) {
	        	String gold = "GOLD";
	        	memberRepository.updateMember(gold, upMember.get(i).getMemberNum());
	        }
	        
	        if(between > 3) {
	        	String platinum = "PLATINUM";
	        	memberRepository.updateMember(platinum, upMember.get(i).getMemberNum());
	        }
	        
	        if(between > 4) {
	        	String diamond = "DIAMOND";
	        	memberRepository.updateMember(diamond, upMember.get(i).getMemberNum());
	        }
	        
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}


















