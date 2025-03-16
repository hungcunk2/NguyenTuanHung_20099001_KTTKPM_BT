package Observer;

public class main {
	public static void main(String[] args) {
		coPhieu cophieu= new coPhieu("Co Phieu FPT");
		NhaDauTu nhaDauTu1=new NhaDauTu("quan");
		NhaDauTu nhaDauTu2=new NhaDauTu("quan2");
		cophieu.attach(nhaDauTu1);
		cophieu.attach(nhaDauTu2);
		cophieu.setPrice("200000");
		NhiemVu nhiemVu= new NhiemVu("Nhiem vu 1");
		ThanhVien thanhVien1=new ThanhVien("quan");
		ThanhVien thanhVien2=new ThanhVien("A");
		nhiemVu.attach(thanhVien1);
		nhiemVu.attach(thanhVien2);
		nhiemVu.setStatus("Success");
		nhiemVu.setStatus("In Process");
	}
}
