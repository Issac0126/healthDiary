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
		System.out.println("★★★★★★회원들 꽉JAVA PT 마포점★★★★★★");
		System.out.println("어서오세요 회원님 무슨 일로 오셨나요??");
		System.out.println("1. 회원 관리");
		System.out.println("2. 운동하러 왔죠");
		System.out.print(">>> ");
	}
	
}
