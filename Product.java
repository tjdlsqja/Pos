package Pos;

public class Product implements Comparable<Product>{
	long product_id; // 바코드
	String name; // 제품명
	String price; // 가격
	String origin; // 생산지
	String cAdult; // 성인용 유무
	int quantity; // 수량
	int sumPrice; // 총 가격
	
	
	public Product(String name, String price, String origin, String cAdult) {
		this.name = name;
		this.price = price;
		this.origin = origin;
		this.cAdult = cAdult;
		this.quantity = 0;
		this.product_id = hashCode();
	}
	
	public void addQuantity() {
		this.quantity ++;
		this.sumPrice = quantity * Integer.parseInt(price);
	}
	
	public void reduceQuantity() {
		this.quantity --;
		this.sumPrice = quantity * Integer.parseInt(price);
	}
	
	
	
	public void showProductInfo() {
		System.out.printf("%10d %5s %5s %5s %5s %5d %10d\n", product_id, name, price, origin, cAdult, quantity, sumPrice);
	}

	@Override
	public int compareTo(Product p) {
		if(this.product_id < p.product_id) {
			return -1;
		} else if (this.product_id > p.product_id) {
			return 1;
		}
		return 0;
	}
}
