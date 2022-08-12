package Pos;

import java.util.InputMismatchException;

public class StorkManagement implements IMenu {
	
	int input = 0;
	IMenu menu;
	
	public StorkManagement() {
	}
	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("************************************ Warehousing Menu ************************************");
		System.out.println("1. 물품등록 | 2. 재고파악 | 3. 물품폐기 | 4. 물품검색 | 5. 돌아가기");
	}

	@Override
	public boolean checkInput(int inputTest) {
		// TODO Auto-generated method stub
		if (inputTest >= 1 && inputTest <= 5) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void selectMenu() {
		// TODO Auto-generated method stub
		boolean isOkay = false;
		System.out.print("선택> ");

		while (!isOkay) {
			try {
				int inputTest = sc.nextInt();
				sc.nextLine();
				input = inputTest;
				isOkay = true;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("Input error! input integer data.");
				showMenu();
			}
		}
		
		if(!checkInput(input) == true) {
			System.out.println("Input error! select to Menu's options");
			showMenu();
			selectMenu();
		}
	}
	
	@Override
	public int run() {
		// TODO Auto-generated method stub
		return input;
	}
	
	

}
