package Pos;

import java.util.Scanner;

public class PosRunnable {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean isOff = false; // 프로그램 종료 flag 변수
		boolean isLogin = false; // 로그인 flag 변수
		Pos pos = Pos.getInstance();

		while(!isOff) {
			// 로그인
			Admin admin = Login.getInstance();
			admin.login();
			admin.setStartTime(System.currentTimeMillis());
			isLogin = true;
			
			System.out.println("***********************************************************************************");
			System.out.println("                                   24시간 편의점 POS                                  ");
			System.out.println("***********************************************************************************");
			
			while(isLogin) {
				System.out.println();
				System.out.println("------------------------------------ MAIN Menu ------------------------------------");
				System.out.println("1. 재고관리 | 2. 결제하기 | 3. 암호변경 | 4. 예상 급여 | 5. 로그아웃 | 6. 프로그램 종료");
				System.out.print("선택 > ");
				String option = sc.nextLine();
				switch(option) {
				case "1":
					pos.storkManage();
					break;
				case "2":
					pos.payment();
					break;
				case "3":
					admin.changePassword(); // PW 변경
					break;
				case "4":
					admin.setEndTime(System.currentTimeMillis());
					admin.calculatePay();
					System.out.printf("예상 급여: %.2f원\n" ,admin.getPay());
					break;
				case "5":
					// 로그아웃
					isLogin = false;
					admin.setEndTime(System.currentTimeMillis());
					admin.logout();
					break;
				case "6":
					// 로그아웃
					isLogin = false;
					admin.setEndTime(System.currentTimeMillis());
					admin.logout();
					isOff = true;
					break;
					default: System.out.println("Input error! 선택 옵션 사항을 입력해주세요.");
				}
			}
			
		}
		System.out.println("***********************************************************************************");
		System.out.println("                             24시간 편의점 POS 프로그램 종료                              ");
		System.out.println("***********************************************************************************");
		
	}
}

//ProductDbClass pos = new ProductDbClass();
//pos.addProduct();
//for(int i = 0; i < pos.pList.size(); i++) {
//	System.out.printf("%5s %5s %5s %5s \n", pos.pList.get(i).name, pos.pList.get(i).price, pos.pList.get(i).origin, pos.pList.get(i).cAdult);
//}
//for(int i = 0; i < pos.sList.size(); i++) {
//	System.out.printf("%5s %5s %5s %5s %5s \n", pos.sList.get(i).name, pos.sList.get(i).price, pos.sList.get(i).origin, pos.sList.get(i).cAdult, pos.sList.get(i).expriyDate);
//}
