package Observer;

public class NhaDauTu implements Observer {
	private String name;
	
	public NhaDauTu(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	@Override
	public void update(String massage) {
		// TODO Auto-generated method stub
		System.out.println(name + " updated: "+ massage);
	}
	

}
