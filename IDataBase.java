package Pos;

import java.util.Scanner;

public interface IDataBase {
	
	Scanner sc = new Scanner(System.in);
	
	void selectProduct();
	String checkInputPrice();
	String checkInputCAdult();
	String checkInputExpriyDate();
	long checkInputStockId(String name);
	int checkInputQuantity();
	void addProduct();
	void removeProduct();
	void showProductList();
	void showStockList();
}
