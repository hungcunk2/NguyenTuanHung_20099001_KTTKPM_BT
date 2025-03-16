package Default;

import java.util.ArrayList;
import java.util.List;

public class CoPhieu {
	private String coPhieu;
	private List<NhaDauTu> nhaDauTus= new ArrayList<NhaDauTu>();
	public void addNhaDautu(NhaDauTu nhaDauTu) {
		nhaDauTus.add(nhaDauTu);
	}
	public void removeNhaDautu(NhaDauTu nhaDauTu) {
		nhaDauTus.remove(nhaDauTu);
	}
	public void setGia(String price) {
		this.coPhieu= price;
		notifyInvestors();
	}
	public void notifyInvestors() {
		for (NhaDauTu nhaDauTu : nhaDauTus) {
			nhaDauTu.update("Gia thay doi la: " + coPhieu);
		}
	}
}
