package br.com.magno;

import java.util.ArrayList;
import java.util.List;

public class Buy {
	
	List<Tuple> listBuy = new ArrayList<>();

	public Buy() {
		listBuy.add(new Tuple(Fruits.PEAR,3));
		listBuy.add(new Tuple(Fruits.ORANGE, 25));
		listBuy.add(new Tuple(Fruits.APPLE, 12));
	}

	public List<Tuple> getListBuy() {
		return listBuy;
	}

}
