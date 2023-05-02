package practice;

public class just {


public void exerciseProcess(int exe_num) {
	System.out.println("운동을 시작합니다!");
	System.out.println("시간 잴게요!");
	
	long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
    		        
	long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
	long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
	System.out.println("시간차이(m) : "+secDiffTime);


}
}