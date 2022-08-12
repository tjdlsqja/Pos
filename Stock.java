package Pos;

import java.util.ArrayList;

public class Stock implements Comparable<Stock>{
	long product_id;
	long stork_id;
	String name;
	String price;
	String origin;
	String cAdult;
	String expriyDate;
	
	public Stock(ArrayList<Product> pList, String name, String expriyDate) {
		for(int i = 0; i < pList.size(); i++) {
			if(pList.get(i).name.equals(name)) {
				this.name = name;
				this.price = pList.get(i).price;
				this.origin = pList.get(i).origin;
				this.cAdult = pList.get(i).cAdult;
				this.expriyDate = expriyDate;
				this.stork_id = hashCode();
				this.product_id = pList.get(i).product_id;
			}
		}
	}
	public Stock(ArrayList<Product> pList, String name, String price, String origin, String cAdult, String expriyDate) {
		this.name = name;
		this.price = price;
		this.origin = origin;
		this.cAdult = cAdult;
		this.expriyDate = expriyDate;
		this.stork_id = hashCode();
		pList.add(new Product(name, price, origin, cAdult));
		this.product_id = pList.get(pList.size()-1).product_id;
		
	}
	
	public void showStorkInfo() {
		System.out.printf("%10d %10d %5s %5s %5s %5s %14s\n", product_id, stork_id, name, price, origin, cAdult, expriyDate);
	}
	
	@Override
	public int compareTo(Stock s) {
		if(this.product_id < s.product_id) {
			return -1;
		} else if (this.product_id > s.product_id) {
			return 1;
		}
		return 0;
	}

}
