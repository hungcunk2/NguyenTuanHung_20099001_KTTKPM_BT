package Observer;

import java.util.ArrayList;
import java.util.List;

public class NhiemVu implements Subject {

private List<Observer> observers=new ArrayList<Observer>();
	
	private String trangThai;
	
	private String name;
	
	public NhiemVu(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	public void setStatus(String trangThai) {
		this.trangThai= trangThai;
		notifyChange(name+" status " + trangThai);
	}
	
	@Override
	public void attach(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	@Override
	public void notifyChange(String message) {
		// TODO Auto-generated method stub
		for (Observer observer : observers) {
			observer.update(message);
		}
	}


}
