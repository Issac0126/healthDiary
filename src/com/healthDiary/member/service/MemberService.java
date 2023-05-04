
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
	
	
	//1. 신규 회원 추가
	private void join() {
		
		while(true) {
			System.out.print("\n이름: ");
			String memberName = inputString();
			
			System.out.print("전화번호: ");
			String phoneNum = inputString();
			
			try {
				
				if(memberName.length() > 5 || memberName.length() < 2) {
					System.out.println("주민등록상의 이름을 입력해주세요");
					break;
				} else if(phoneNum.length() != 13) {
					System.out.println("'-'을 포함해 전화번호를 입력해주세요");
					break;
				} else {
					System.out.println("\n새로운 회원 정보가 정상 등록되었습니다");
					Member member = new Member();
					member.setMemberName(memberName);
					member.setPhoneNum(phoneNum);
					memberRepository.addNewMember(member);
					break;
				}			
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다!");
			}
		}
		
		
	}
	
	
	
	private List<Member> searchMember() {
		System.out.print("★ 조회할 회원의 이름: ");
		String name = inputString();
		
		return memberRepository.findMemberList(name);
		
	}
	
	// 2. 회원 검색
	private int showMemberList() {
		List<Member> members = searchMember();
		
		if(members.isEmpty()) {
			System.out.println("\n★ !! 등록된 회원이 없습니다");
		} else {
			System.out.println("\n★ 조회된 회원 결과: " + members.size() + "명");
			System.out.println(" 회원번호\t이름 \t전화번호   \t가입일    \t등급" );
			System.out.println("─────────────────────────────────────────────────────────");
			for(int i=0; i<members.size(); i++) {
				System.out.printf("☆ %d번 %s \t%s \t%s \t%s\n"
						, members.get(i).getMemberNum(), members.get(i).getMemberName()
						, members.get(i).getPhoneNum(), members.get(i).getRegDate()
						, members.get(i).getGrade());
			}
			System.out.println("─────────────────────────────────────────────────────────");
		}
		return members.size();
		
	}
	
	//3. 회원 탈퇴
	private void deleteMember() {
		if(showMemberList() > 0) {
			System.out.print("\n★ 탈퇴할 회원의 번호: ");
			int delMemberNum = inputInteger();
			memberRepository.deleteMember(delMemberNum);
		}
		System.out.println("\n----------PRESS ENTER KEY----------");
        inputString();
		
	}
	
	
	//4. 전체 회원 보기
	private void allList() {
		List<Member> allMember = memberRepository.searchMemberList();
		
		System.out.println("\n★ 조회된 회원 결과: " + allMember.size() + "명");
		
		System.out.println("─────────────────────────────────────────────────────────");
		System.out.println(" 회원번호\t이름 \t전화번호   \t가입일    \t등급\n" );
		for(int i=0; i<allMember.size(); i++) {
			System.out.printf("☆ %d번 \t%s \t%s \t%s \t%s\n"
					, allMember.get(i).getMemberNum(), allMember.get(i).getMemberName()
					, allMember.get(i).getPhoneNum(), allMember.get(i).getRegDate()
					, allMember.get(i).getGrade());
		}
		System.out.println("─────────────────────────────────────────────────────────\n");
		System.out.println("----------PRESS ENTER KEY----------");
        inputString();
	}
	
	
	
	
	//업그레이드
	private void upgradeMember() {
		List<Member> upMember = memberRepository.searchMemberList();

		Date memberRegDate;
		LocalDateTime memberDateTime;
		long between;

		for(int i=0; i<upMember.size(); i++) {
			memberRegDate = upMember.get(i).getRegDate();
	        memberDateTime = Instant.ofEpochMilli(memberRegDate.getTime())
	                .atZone(ZoneId.systemDefault())
	                .toLocalDateTime();
	        
	        between = ChronoUnit.YEARS.between(memberDateTime , LocalDateTime.now());
	        

            if(between > 4) {
                String diamond = "DIAMOND";
                memberRepository.updateMember(diamond, upMember.get(i).getMemberNum());
            } else if(between > 3) {
                String platinum = "PLATINUM";
                memberRepository.updateMember(platinum, upMember.get(i).getMemberNum());
            } else if(between > 2) {
                String gold = "GOLD";
                memberRepository.updateMember(gold, upMember.get(i).getMemberNum());
            } else if(between > 1) {
                String silver =  "SILVER";
                memberRepository.updateMember(silver, upMember.get(i).getMemberNum());
	        
		}
		
	}
	
	
	
	
	}
}


















