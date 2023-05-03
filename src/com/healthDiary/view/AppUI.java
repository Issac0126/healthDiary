package com.healthDiary.view;

import java.util.Scanner;

public class AppUI {

	
	private static Scanner sc = new Scanner(System.in);
	
	public static String inputString() {
		return sc.nextLine();
	}
	
	public static int inputInteger() {
		int num = 0;
		try {
			num = sc.nextInt();
		} catch (Exception e) {
			System.out.println("다시 말씀해주세요 회원님~");			
		}finally {
			sc.nextLine();
		}
		return num;
	}
	
	//첫 화면
	public static void startScreen() {
		System.out.println("\n★★★★★★회원들 꽉JAVA PT 마포점★★★★★★");
		System.out.println("\n🙍‍♂️‍: 회원님 무슨 일로 오셨나요?? ");
		System.out.println("\n1. 회원 관리");
		System.out.println("2. 운동하러 왔죠");
		System.out.println("3. 기록 확인하러 왔습니다");
		System.out.println("4. 프로그램 종료합니다");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.print(">>> ");
	}
	
	
	//1. 회원 관리 화면
    public static void memberScreen() {
        System.out.println("\n\n★★★★★★ 회원 관리 시스템 ★★★★★★");
        System.out.println("1. 신규 회원 추가");
        System.out.println("2. 회원 검색");
        System.out.println("3. 회원 탈퇴");
        System.out.println("4. 전체 회원 보기");
        System.out.println("5. 첫 화면으로");
        System.out.println("-----------------------------");
        System.out.print(">>> ");
    }
	
	//2. 운동종목 관리 시스템
		public static void exerciseScreen() {
			System.out.println("\n\n★★★★★★ 운동 종목 관리 시스템 ★★★★★★");
			System.out.println("운동종목을 관리합니다");
			System.out.println("1. 새로운 운동종목을 추가합니다");
			System.out.println("2. 운동 종목의 목록을 조회합니다");
			System.out.println("3. 등록된 운동종목을 삭제합니다");
			System.out.println("-----------------------------");
			System.out.print(">>> ");
		}	
		
	//3. 기록 관리 시스템
		public static void recordScreen() {
			System.out.println("\n\n★★★★★★ 기록 관리 시스템 ★★★★★★");
			System.out.println("1. 운동을 시작합니다.");
			System.out.println("2. 운동한 기록을 조회합니다.");
			System.out.println("-----------------------------");
			System.out.print(">>> ");
		}					
		
} //END MAIN


























