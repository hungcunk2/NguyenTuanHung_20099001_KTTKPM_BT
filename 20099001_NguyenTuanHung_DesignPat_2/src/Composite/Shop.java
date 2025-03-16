package Composite;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	 private List<Ban> tables = new ArrayList<Ban>();

	    public void addTable(Ban table) {
	        tables.add(table);
	    }

	    public double getTotalRevenue() {
	        return tables.stream().mapToDouble(Ban::getPrice).sum();
	    }
}
