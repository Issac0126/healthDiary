package com.healthDiary.record;

import static com.healthDiary.view.AppUI.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.healthDiary.common.AppService;
import com.healthDiary.common.DataBaseConnection;
import com.healthDiary.exercise.Exercise;
import com.healthDiary.member.domain.Member;
import com.healthDiary.view.AppUI;

public class RecordStart implements AppService {


	private static DataBaseConnection connection
	= DataBaseConnection.getInstance();
	private final RecordRepository recordRepository = new RecordRepository();
	
	
	@Override
	public void Start() {
		recordScreen();
		int answerNum = AppUI.inputInteger(); 
		
		switch (answerNum) {
		case 1:
			exeStart();
			break;
		case 2:
			exeRecord();
			break;
		default:
			System.out.println("1~2 중 유효한 번호를 입력해주세요.");
			break;
		}
	}
	
	
	
	//1. 운동 시작하기
	private void exeStart() { 
		System.out.println("\n\n★ 오늘은 어떤 운동을 하실 건가요?");
		System.out.print("(목록을 보려면 '목록 보기'를 입력해주세요.) \n > ");
		String answer = inputString().trim();
		String sql = null;
		
		if(answer.equals("목록") || answer.equals("목록 보기") || answer.equals("목록보기")) {
			sql = "SELECT * FROM exercise";
		} else {
			System.out.println("\n🔍'"+answer+"'이(가) 포함된 운동을 검색합니다.");
			sql = "SELECT * FROM exercise WHERE exe_name LIKE '%"+answer+"%'";
		}
		
		List<Exercise> exeList= recordRepository.exeListSearch(sql);			
		
		
		if(exeList.size() >= 1) {  //운동 목록 출력
			System.out.println("\n\n─────────── 운동 목록 ───────────");
			System.out.println("운동번호 \t운동 ");
			for(Exercise e : exeList) {
				System.out.println(e);
			}
			System.out.println("──────────────────────────────");
		} else {
			System.out.println("\n! "+answer+"의 검색 결과가 없습니다."
					+ " \n메인 메뉴에서 새 운동 목록을 추가해 주세요.\n\n\n");
			return;
		}
		
		
		// 시작 운동 번호 고르기
		System.out.print("★★★ 시작할 운동 번호를 골라주세요. ★★★ \n > ");
		int startExeNum = inputInteger();
		boolean flag = false;
		
		for(Exercise e  : exeList) {
			if(e.getExe_num() == startExeNum) {
				flag= true;  break;
			}
		} 
		if(!flag) {
			System.out.println("\n\n목록에 포함된 번호만 골라주세요.");
			return;
		}
		
		
		List<String> selExe = recordRepository.ExeNumToName(startExeNum);
		
		String selExeName = selExe.get(0);
		String CST = selExe.get(1);

		System.out.println("\n★"+startExeNum+"번 "+selExeName+" 운동을 시작합니다."); //운동 시작
		System.out.println("스톱워치를 시작하려면 'Enter'를 눌러주세요!"); //타이머 시작
		inputString();
		long start = System.currentTimeMillis();
		long end = 0;
		
		System.out.println("\n┌───────────────────────────────┐");
		System.out.println("│           ★★★           \t│");
		System.out.println("│  스톱워치가 시작되었습니다.      \t│");   
		System.out.println("│ '끝'을 입력하면 스톱워치가 종료됩니다.\t│");
		System.out.println("└───────────────────────────────┘\n");
		
		while(true) {
			System.out.print("★입력란: ");
			String timerEnd = inputString();
			if(timerEnd.equals("끝") || timerEnd.toUpperCase().equals("RMX")) {
				end = System.currentTimeMillis();
				break;
			}						
		} //운동 끝!
		int sec = (int)((end-start)*0.001);
		int exeCount = 0;
		
//		String selExeMeasure = null;
		if(CST.equals("C")) {
//			selExeMeasure = "횟수";
			System.out.print("\n★"+selExeName+" 운동을 몇 회 하셨나요? \n> ");
			exeCount = inputInteger();
		} else if(CST.equals("S")) {
//			selExeMeasure = "시간";
		} else {
//			selExeMeasure = "타이머";
		}
		
		System.out.println("\n─────── ★★ 오늘의 운동 ★★ ───────\n");
		System.out.println("종목: "+selExeName);
		if(CST.equals("C"))System.out.println("운동 횟수: "+exeCount+"회");
		System.out.printf("총 운동시간: %d초\n", sec);
		System.out.println("       ★★ 수고하셨습니다! ★★    ");
		System.out.println("\n──────────────────────────────\n\n");

	}
	
	
	//2. 운동 기록 조회하기
	private void exeRecord() {
		Member selMem = memSearch();
		if(selMem==null) return;
		
		System.out.println(selMem.getMemberName()+"님의 운동 기록을 조회합니다.");
		
		
		
		
	} 
	
	//회원 정보 확인하기 리턴: Member
	private Member memSearch() {
		System.out.println("\n★ 회원 정보를 확인합니다.");
		System.out.print("이름: ");
		String anName = inputString();
		
		String sql = "SELECT * FROM member WHERE member_name = '"+anName+"'";
		List<Member> memList= recordRepository.memListSearch(sql);
		
		if(memList.size()!=0) {
			System.out.println("\n─────────────── 검색 목록 ───────────────");
			System.out.println(" 번호 \t이름  번호 뒷자리  등급    가입일      재실여부");
			for(Member m : memList) {
				if(m.getMemberName().equals(anName)) {
					System.out.println(m);
				}
			}
			System.out.println("──────────────────────────────────────");			
		} else {
			System.out.println("검색 기록이 없습니다. 검색어를 다시 한 번 확인해주세요.");
			return null;
		}
		System.out.print("★★★ 본인의 회원 번호를 골라주세요. ★★★ \n > ");
		int selMyNum = inputInteger();
		boolean flag = false;
		
		for(Member e : memList) {
			if(e.getMemberNum() == selMyNum) {
				flag= true;
				return e;
			}
		} 
		System.out.println("\n\n목록에 포함된 번호만 골라주세요.");
		return null;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	//특정 회원의 기록 출력하기
	
	
	
	
	
	
	
	
	
	
	
	
	
}
