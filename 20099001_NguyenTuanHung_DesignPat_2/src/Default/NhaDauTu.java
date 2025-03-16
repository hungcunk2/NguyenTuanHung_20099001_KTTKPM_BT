package Default;

public class NhaDauTu {
	private String name;
	public NhaDauTu(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	public void update(String message) {
		System.out.println(name +" thay doi: "+ message);
	}
}
