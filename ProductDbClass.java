package Pos;

import java.util.ArrayList;
import java.util.Collections;

public class ProductDbClass implements IDataBase{

	ArrayList<Product> pList = new ArrayList<>();
	ArrayList<Stock> sList = new ArrayList<>();
	
	// 초기 Db Class 생성
	public ProductDbClass() {
		// TODO Auto-generated constructor stub
		pList.add(new Product("신라면", "1200", "농심", "X"));
		pList.add(new Product("코카콜라", "1800", "코카콜라", "X"));
		pList.add(new Product("칠성사이다", "1600", "롯데", "X"));
		pList.add(new Product("말보로레드", "4500", "말보로", "O"));
		pList.add(new Product("참이슬", "1800", "진로", "O"));
		pList.add(new Product("처음처럼", "1800", "롯데", "O"));
		pList.add(new Product("불닭볶음면", "1500", "삼양", "X"));
		for(int i = 0; i < 5; i++) {			
			sList.add(new Stock(pList, pList.get(0).name, "2023.08.10"));
			sList.add(new Stock(pList, pList.get(1).name, "2022.12.25"));
			sList.add(new Stock(pList, pList.get(2).name, "2024.09.10"));
			sList.add(new Stock(pList, pList.get(3).name, "2023.10.30"));
			sList.add(new Stock(pList, pList.get(4).name, "2023.11.11"));
			sList.add(new Stock(pList, pList.get(5).name, "2023.07.08"));
			sList.add(new Stock(pList, pList.get(6).name, "2023.07.08"));
			for(int j = 0; j < pList.size(); j++) {
				pList.get(j).addQuantity();	
			}
		}
	}

	@Override
	public String checkInputPrice() {
		// TODO Auto-generated method stub
		boolean isChecked = false;
		String price = null;
		while(!isChecked) {
			System.out.print("가격을 입력하세요: ");
			try {
				price = sc.nextLine();
				Integer.parseInt(price);
				isChecked = true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Input error! 숫자를 입력해주세요.");
				isChecked = false;
			}	
		}
		return price;
	}

	@Override
	public String checkInputCAdult() {
		// TODO Auto-generated method stub
		boolean isChecked = false;
		String cAdult = null;
		while(!isChecked) {
			System.out.print("성인용유무(O or X)를 입력하세요: ");
			cAdult = sc.nextLine();
			if(cAdult.equals("O") || cAdult.equals("X")) {
				isChecked = true;
			} else {
				System.out.println("Input error! \"O\" or \"X\"를 입력해주세요.");
			}
		}

		return cAdult;
	}

	@Override
	public String checkInputExpriyDate() {
		// TODO Auto-generated method stub
		boolean isChecked = false;
		String expriyDate = null;
		while(!isChecked) {
			System.out.print("유통기한(ex- 20220810)을 입력하세요: ");
			try {
				expriyDate = sc.nextLine();
				Integer.parseInt(expriyDate);
				if(expriyDate.length() == 8) {
					int year = Integer.parseInt(expriyDate.substring(0, 4));
					int month = Integer.parseInt(expriyDate.substring(4, 6));
					int day = Integer.parseInt(expriyDate.substring(6, 8));
					expriyDate = expriyDate.substring(0, 4) + "." + expriyDate.substring(4, 6) + "." + expriyDate.substring(6, 8);
					if(year >= 2022 && month <= 12 && month >=1 && day <= 31 && day >= 1) {
						if(month == 2) {
							if(day <= 29) {
								isChecked = true;
								} else System.out.println("Input error! 표기형식에 맞게 입력해주세요.");
							}
						else if(month % 2 == 0) {
							if(month >= 8) {
								isChecked = true;
								}
							else {
								if(day <= 30) {
									isChecked = true;
									} else System.out.println("Input error! 표기형식에 맞게 입력해주세요.");
								}
							} 
						else {
							if(month <= 7) {
								isChecked = true;
							}
							else {
								if(day <= 30) {
									isChecked = true;
									} else System.out.println("Input error! 표기형식에 맞게 입력해주세요.");
								}
							}
						} else System.out.println("Input error! 표기형식에 맞게 입력해주세요.");
					}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Input error! 표기형식에 맞게 입력해주세요.");
				isChecked = false;
			}
		}
		return expriyDate;
	}
	
	@Override
	public int checkInputQuantity() {
		// TODO Auto-generated method stub
		boolean isChecked = false;
		int quantity = 0;
		while(!isChecked) {
			System.out.print("제품 수량을 입력하세요: ");
			try{
				quantity = sc.nextInt();
				sc.nextLine();
				isChecked = true;
			} catch (Exception e) {
				System.out.println("Input error! 숫자를 입력해주세요.");
			}
		}

		return quantity;
	}

	@Override
	public long checkInputStockId(String name) {
		// TODO Auto-generated method stub
		boolean isChecked = false;
		long stock_id = 0;
		long compare_id = 0;
		while(!isChecked) {
			System.out.print("상품번호를 선택해주세요: ");
			try{
				stock_id = sc.nextInt();
				sc.nextLine();
				for(int i = 0; i < sList.size(); i++) {
					if(sList.get(i).name.equals(name)) {
						compare_id = sList.get(i).stork_id;
						if(compare_id == stock_id) {
							isChecked = true;
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Input error! 숫자를 입력해주세요.");
			}
			if(!isChecked) {
				System.out.println("Input error! 등록된 상품번호가 아닙니다.");
			}
		}

		return stock_id;
	}

	@Override
	public void selectProduct() {
		// TODO Auto-generated method stub
		String name;
		boolean isDescribed = false;
		System.out.print("제품명을 입력하세요: ");
		name = sc.nextLine();
		for(int i = 0; i < pList.size(); i++) {
			if(pList.get(i).name.equals(name)) {
				isDescribed = true;
			}
		}
		
		if(isDescribed) {
			System.out.println("*********************************** Select List **************************************");
			System.out.println(" 제 품 번 호   제 품 명  가격    제조사  성인용유무  수량     총가격");
			for(int i = 0; i < pList.size(); i++) {
				if(pList.get(i).name.equals(name)) {
					pList.get(i).showProductInfo();	
				}
			}
			System.out.println();
			
			System.out.println(" 제 품 번 호   상 품 번 호   제 품 명  가격    제조사  성인용유무  유 통 기 한");
			for(int i = 0; i < sList.size(); i++) {
				if(sList.get(i).name.equals(name)) {
					sList.get(i).showStorkInfo();
				}
			}
			System.out.println();
		} else {
			System.out.println("등록된 제품이 아닙니다.");
			selectProduct();
		}
	}

	@Override
	public void removeProduct() {
		// TODO Auto-generated method stub
		String name;
		boolean isDescribed = false;
		boolean isHave = false;
		int quantity = 0;
		long stock_id = 0;
		int index = 0;
		int cnt = 0;
		System.out.println("*********************************** Remove Product **************************************");		
		System.out.print("제품명을 입력하세요: ");
		name = sc.nextLine();
		for(int i = 0; i < pList.size(); i++) {
			if(pList.get(i).name.equals(name)) {
				index = i;
				isDescribed = true;
			}
		}
		
		if(isDescribed) {
			System.out.println("*********************************** Select List **************************************");
			System.out.println(" 제 품 번 호   상 품 번 호   제 품 명  가격    제조사  성인용유무  유 통 기 한");
			for(int i = 0; i < sList.size(); i++) {
				if(sList.get(i).name.equals(name)) {
					sList.get(i).showStorkInfo();
					cnt++;
				}
			}
			System.out.println();
			
			boolean isCheckd = false;
			while(!isCheckd) {
				quantity = checkInputQuantity();
				if(quantity > cnt) {
					System.out.println("보유 제품보다 많습니다.");
				} else {
					isCheckd = true;
				}
			}
			
			for(int i = 0; i < quantity; i++) {
				stock_id = checkInputStockId(name);
				for(int j = 0; j < sList.size(); j++) {
					if(stock_id == sList.get(j).stork_id) {
						sList.remove(j);
						pList.get(index).reduceQuantity();
						System.out.println("*********************************** Select List **************************************");
						System.out.println(" 제 품 번 호   상 품 번 호   제 품 명  가격    제조사  성인용유무  유 통 기 한");
						for(int k = 0; k < sList.size(); k++) {
							if(sList.get(k).name.equals(name)) {
								sList.get(k).showStorkInfo();
							}
						}
					}
				}
			}
			
		} else {
			System.out.println("등록되지 않은 상품입니다.");
		}
	}

	// 입고 상품 등록
	@Override
	public void addProduct() {
		// TODO Auto-generated method stub
		String name;
		String price;
		String origin;
		String cAdult;
		String expriyDate;
		int quantity;
		int index = 0;
		boolean isDescribed = false;
		System.out.println("*********************************** Add Product **************************************");
		System.out.print("등록할 제품명을 입력하세요: ");
		name = sc.nextLine();
		
		// 기존에 등록된 제품인지 확인
		for(int i = 0; i < pList.size(); i++) {
			if(pList.get(i).name.equals(name)) {
				isDescribed = true;
			}
		}
		// 등록되지 않은 제품이면 제품리스트에 등록
		if(!isDescribed) {
			price = checkInputPrice();
			System.out.print("생산지을 입력하세요: ");
			origin= sc.nextLine();
			cAdult = checkInputCAdult();
			pList.add(new Product(name, price, origin, cAdult));
		}
		
		// 제품을 재고리스트에 등록
		expriyDate = checkInputExpriyDate();
		quantity = checkInputQuantity();
		for(int i = 0; i < pList.size(); i++) {
			if(pList.get(i).name.equals(name)) {
				index = i;
			}
		}
		for(int i = 0; i < quantity; i++) {
			sList.add(new Stock(pList, name, expriyDate));
			pList.get(index).addQuantity();
		}
		
	}

	@Override
	public void showProductList() {
		// TODO Auto-generated method stub
		Collections.sort(pList);
		System.out.println("************************* Product List ****************************");
		System.out.println(" 제 품 번 호   제 품 명  가격    제조사  성인용유무  수량     총가격");
		for(int i = 0; i < pList.size(); i++) {
			pList.get(i).showProductInfo();
		}
		System.out.println();
	}

	@Override
	public void showStockList() {
		// TODO Auto-generated method stub
		Collections.sort(sList);
		System.out.println("*********************************** Stork List **************************************");
		System.out.println(" 제 품 번 호   상 품 번 호   제 품 명  가격    제조사  성인용유무  유 통 기 한");
		for(int i = 0; i < sList.size(); i++) {
			sList.get(i).showStorkInfo();
		}
		System.out.println();
	}
	
}
