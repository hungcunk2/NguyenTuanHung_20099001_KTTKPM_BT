package Composite;

public class SanPham implements ItemPrice{
	 private String name;
	 private double price;

	    public SanPham(String name, double price) {
	        this.name = name;
	        this.price = price;
	    }

	   
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}
