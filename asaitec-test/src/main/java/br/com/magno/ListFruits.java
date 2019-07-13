package br.com.magno;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acarvasa
 *
 */
public class ListFruits {

	List<Tuple<Fruits, Double>> listFruits = new ArrayList<>();

	public ListFruits() {
		listFruits.add(new Tuple(Fruits.PEAR, 0.75));
		listFruits.add(new Tuple(Fruits.APPLE, 0.9));
		listFruits.add(new Tuple(Fruits.ORANGE, 1.0));
	}

	public List<Tuple<Fruits, Double>> getListFruits() {
		return listFruits;
	}

}
