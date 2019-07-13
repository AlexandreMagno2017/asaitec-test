package br.com.magno;

public class TupleResult {

	private Fruits fruit;
	private int units;
	private Double value;
	private Tuple tuple;

	/**
	 * @param fruit
	 * @param units
	 * @param value
	 */
	public TupleResult(Fruits fruit, int units, Double value) {
		super();
		this.fruit = fruit;
		this.units = units;
		this.value = value;
	}
	
	public TupleResult(Fruits fruit, int units, Double value, Tuple gain) {
		super();
		this.fruit = fruit;
		this.units = units;
		this.value = value;
		this.tuple = gain;
	}

	public Fruits getFruit() {
		return fruit;
	}

	public void setFruit(Fruits fruit) {
		this.fruit = fruit;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Tuple getTuple() {
		return tuple;
	}

	public void setTuple(Tuple tuple) {
		this.tuple = tuple;
	}

}
