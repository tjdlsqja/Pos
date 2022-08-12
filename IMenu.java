package Pos;

import java.util.Scanner;


public interface IMenu {
	Scanner sc = new Scanner(System.in);
	
	// 메뉴옵션 출력 메소드
	void showMenu();
	// 메뉴옵션 선택 메소드
	void selectMenu();
	// 입력값 검사 메소드 (옵션 사항에 있으면 true 없으면 false return)
	boolean checkInput(int inputTest);
	
	// 이동할 객체 return 메소드
	int run();
	
}
