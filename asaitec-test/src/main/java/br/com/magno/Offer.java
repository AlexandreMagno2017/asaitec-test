package br.com.magno;

import br.com.magno.Offer.TYPE;

public class Offer {

	public enum TYPE {
		DISCOUNT_BILL, GAIN_FRUIT, GET_FOR_FREE
	};

	public Fruits originFruit;
	public TYPE type;
	public Tuple tuple;
	public Tuple tuple2;
	public int unit1;
	public int unit2;
	public int value;
	public int discount;
	public Fruits destinyFruit;

	
	public Offer(TYPE gainFruit, int i, Tuple tuple) {
		this.type = gainFruit;
		this.tuple = tuple;
	}

	public Offer(TYPE gainFruit, Tuple tuple, Tuple tuple2) {
		this.type = gainFruit;
		this.tuple = tuple;
		this.tuple2 = tuple2;
	}

	
	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public Tuple getTuple() {
		return tuple;
	}

	public void setTuple(Tuple tuple) {
		this.tuple = tuple;
	}

	public Tuple getTuple2() {
		return tuple2;
	}

	public void setTuple2(Tuple tuple2) {
		this.tuple2 = tuple2;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
