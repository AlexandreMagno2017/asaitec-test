package br.com.magno;

public class Tuple<K, V> {

	private K key;
	private V value;

	public Tuple(K k, V v) {
		setKey(k);
		setValue(v);
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
