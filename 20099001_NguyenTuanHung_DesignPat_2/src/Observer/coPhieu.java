package Observer;

import java.util.ArrayList;
import java.util.List;

public class coPhieu implements Subject{
	private List<Observer> observers=new ArrayList<Observer>();
	
	private String stockPrice;
	
	private String name;
	
	public coPhieu(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	public void setPrice(String price) {
		this.stockPrice= price;
		notifyChange(name+" thay doi gia:" + price);
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
