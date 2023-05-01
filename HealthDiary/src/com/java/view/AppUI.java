package com.java.view;

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
		System.out.println("\n\n★★★★★★회원들 꽉JAVA PT 마포점★★★★★★");
		System.out.println("어서오세요 회원님 무슨 일로 오셨나요??");
		System.out.println("1. 신규 등록하려구요");
		System.out.println("2. 운동하러 왔죠");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.print(">>> ");
	}

	//운동	2.
	public static void exerciseManagementScreen() {
		System.out.println("\n 어떻게 운동하실래요?");
		System.out.println("1. 오늘은 새로운 운동 하려구요.");
		System.out.println("2. 어떤 운동 하는게 좋을까요?");
		System.out.println("3. 그 운동은 이제 안할래요.");
		System.out.print(">>> ");
	}






}
