package Composite;

public class Main {
	public static void main(String[] args) {
			SanPham coffee = new SanPham("Coffee", 3.0);
	        SanPham tea = new SanPham("Tea", 2.5);
	        SanPham water = new SanPham("Water", 1.0);

	        Ban Ban1 = new Ban();
	        Ban1.addItem(coffee);
	        Ban1.addItem(tea);

	        Ban Ban2 = new Ban();
	        Ban2.addItem(water);
	        Ban2.addItem(coffee);
	        Ban2.addItem(tea);

	        Shop cafeShop = new Shop();
	        cafeShop.addTable(Ban1);
	        cafeShop.addTable(Ban2);

	        System.out.println("Tong tien: " + cafeShop.getTotalRevenue() + "$" );
	}
}
