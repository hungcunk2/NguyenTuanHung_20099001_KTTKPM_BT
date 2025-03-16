package Observer;

public class ThanhVien implements Observer {
private String name;
	
	public ThanhVien(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	public void update(String massage) {
		// TODO Auto-generated method stub
		System.out.println(name + " updated: "+ massage);
	}
	
}
