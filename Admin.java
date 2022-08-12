package Pos;

import java.util.Scanner;

public interface Admin {
	
	Scanner sc = new Scanner(System.in);
	
	String SSID = "asd"; // 설정된 ID
	String USERNAME = "서인범"; // 유저 이름
	int WAGE = 9800; 
	
	void changePassword();
	void login();
	void logout();
	void setStartTime(long sTime);
	void setEndTime(long eTime);
	double getStartTime();
	double getEndTime();
	void calculatePay();
	double getPay();
}
