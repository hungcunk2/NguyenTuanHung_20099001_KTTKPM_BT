package Default;

public class main {
	public main() {
		// TODO Auto-generated constructor stub
		CoPhieu coPhieu= new CoPhieu();
		NhaDauTu nhaDauTu1= new NhaDauTu("quan");
		NhaDauTu nhaDauTu2= new NhaDauTu("quan2");
		coPhieu.addNhaDautu(nhaDauTu1);
		coPhieu.addNhaDautu(nhaDauTu2);
		coPhieu.setGia("200");
	}
}
