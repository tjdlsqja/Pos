package Pos;

public class Pos implements PosMananger{
	
	private static final Pos pos = new Pos(); 
	ProductDbClass db;
	IMenu menu;
	
	private Pos() {
		db = new ProductDbClass();
	}
	
	public static Pos getInstance() {
		return pos;
	}

	@Override
	public void storkManage() {
		// TODO Auto-generated method stub
		boolean isBack = false;
		while(!isBack) {
			menu = new StorkManagement();
			menu.showMenu();
			menu.selectMenu();
			int num = menu.run();
			switch(num) {
			case 1:
				db.addProduct();
				db.showProductList();
				break;
			case 2:
				db.showProductList();
				break;
			case 3:
				db.showStockList();
				db.removeProduct();
				break;
			case 4:
				db.selectProduct();
				break;
			case 5:
				isBack = true;
				break;
			}	
		}
	}

	@Override
	public void payment() {
		// TODO Auto-generated method stub
		boolean isBack = false;
		while(!isBack) {
			menu = new Payment();
			menu.showMenu();
			menu.selectMenu();
			int num = menu.run();
			switch(num) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				isBack = true;
				break;
			}	
		}
		
	}
	
}
