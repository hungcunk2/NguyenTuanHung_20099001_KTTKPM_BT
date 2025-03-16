package Composite;

import java.util.ArrayList;
import java.util.List;

public class Ban implements ItemPrice {
	
	 private List<ItemPrice> items = new ArrayList<ItemPrice>();

	    public void addItem(ItemPrice item) {
	        items.add(item);
	    }
	
	    @Override
	    public double getPrice() {
	        return items.stream().mapToDouble(ItemPrice::getPrice).sum();
	    }

}
