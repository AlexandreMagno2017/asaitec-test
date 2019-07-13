package br.com.magno;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.magno.Offer.TYPE;

public class MagnoTest {

	public static void main(String args[]) {

		Buy buy = new Buy();
		ListFruits listFruits = new ListFruits();

		Offer offer = new Offer(TYPE.GET_FOR_FREE, 1, new Tuple(Fruits.APPLE, 3));
		Offer offer2 = new Offer(TYPE.GAIN_FRUIT, new Tuple(Fruits.ORANGE, 1), new Tuple(Fruits.PEAR, 2));
		Offer offer3 = new Offer(TYPE.DISCOUNT_BILL, 1, new Tuple(Fruits.PEAR, 4.0));

		applyOffers(buy, listFruits, offer, offer2, offer3);

	}

	public static void applyOffers(Buy buy, ListFruits listFruits, Offer... offers) {

		final Map<Object, Tuple> collectBuy = buy.listBuy.stream().collect(Collectors.toMap(Tuple::getKey, x -> x));
		// System.out.println(collect);
		final List<Fruits> collect2 = collectBuy.keySet().stream().map(mapper -> {
			return (Fruits) mapper;
		}).collect(Collectors.toList());

		System.out.println(collect2);

		for (Object fruits : collectBuy.keySet()) {
			System.out.println(collectBuy.get(fruits).getKey() + " , value =  " + collectBuy.get(fruits).getValue());
		}

		final Map<Fruits, Tuple<Fruits, Double>> collectProducts = listFruits.listFruits.stream()
				.collect(Collectors.toMap(Tuple::getKey, x -> x));
		System.out.println("Values " + collectProducts);

		for (Fruits fruits : collectProducts.keySet()) {
			System.out.println(
					collectProducts.get(fruits).getKey() + " , value =  " + collectProducts.get(fruits).getValue());
		}

		System.out.println("\n\n\n\n");

		List<TupleResult> list = new ArrayList<>();
		for (Offer offer : offers) {
			if ((Fruits) offer.getTuple().getKey() == Fruits.APPLE) {
				final TupleResult result = applyAppleOffer(offer, collectBuy.get(offer.getTuple().getKey()),
						collectProducts.get(offer.getTuple().getKey()));
				if (result != null)
					list.add(result);

			} else if ((Fruits) offer.getTuple().getKey() == Fruits.ORANGE) {
				final TupleResult result = applyOrangeOffer(offer, collectBuy, collectProducts);
				if (result != null)
					list.add(result);

			} else if ((Fruits) offer.getTuple().getKey() == Fruits.PEAR) {
				final TupleResult result = applyPearOffer(offer, collectBuy, collectProducts);
				if (result != null)
					list.add(result);

			}
		}
	}

	/*
	 * Offer offer = new Offer(TYPE.GET_FOR_FREE, 1, new Tuple(Fruits.APPLE,
	 * 3));
	 */
	private static TupleResult applyAppleOffer(Offer offer, Tuple buy, Tuple<Fruits, Double> product) {

		if (offer.getType() == TYPE.GET_FOR_FREE) {
			System.out.println(offer.getTuple().getKey() + ", -- ");
			System.out.println("COMPRA -> " + buy.getKey() + ", TOTAL ITENS " + buy.getValue());
			System.out.println("PRODUTO -> " + product.getKey() + ", VALOR ITEM " + product.getValue());
			Integer val = (Integer) buy.getValue() / (Integer) offer.getTuple().getValue();
			int d = (Integer) buy.getValue();
			Double f = (Double) product.getValue();
			final int i = d - val;
			System.out.println("VALOR DIVISAO  " + val + ", valorPaid = " + (i * f));
			final TupleResult tupleResult = new TupleResult((Fruits) offer.getTuple().getKey(),
					(Integer) buy.getValue(), (i * f));
			System.out.println("tupleResult   " + tupleResult.getFruit().name() + ", " + tupleResult.getUnits() + ", "
					+ tupleResult.getValue());
			return tupleResult;
		}
		return null;
	}

	/*
	 * Offer offer2 = new Offer(TYPE.GAIN_FRUIT, new Tuple(Fruits.ORANGE, 1),
	 * new Tuple(Fruits.PEAR, 2));
	 */
	private static TupleResult applyOrangeOffer(Offer offer, Map<Object, Tuple> buy,
			Map<Fruits, Tuple<Fruits, Double>> collectProducts) {

		if (offer.getType() == TYPE.GAIN_FRUIT) {
			System.out.println("Gain " + offer.getTuple().getValue() + " of " + offer.getTuple().getKey() + ", -- ");
			System.out.println(
					"COMPRA -> " + buy.get(Fruits.PEAR).getKey() + ", TOTAL ITENS " + buy.get(Fruits.PEAR).getValue());

			System.out.println("FROM " + offer.getTuple2().getValue() + " of " + offer.getTuple2().getKey() + ", -- ");

			Integer val = (Integer) buy.get(Fruits.PEAR).getValue() / (Integer) offer.getTuple2().getValue();

			Double valuePaid = (Integer) buy.get(Fruits.PEAR).getValue() * collectProducts.get(Fruits.PEAR).getValue();

			System.out.println(" valorPaid = " + valuePaid);
			final TupleResult tupleResult = new TupleResult(Fruits.PEAR, (Integer) buy.get(Fruits.PEAR).getValue(),
					valuePaid);
			tupleResult.setTuple(new Tuple(Fruits.ORANGE, 1));

			System.out.println("tupleResult   " + tupleResult.getFruit().name() + ", " + tupleResult.getUnits() + ", "
					+ tupleResult.getValue() + ", " + tupleResult.getTuple().getKey() + ", "
					+ tupleResult.getTuple().getValue());

			return tupleResult;
		}
		return null;
	}

	/*
	 * Offer offer3 = new Offer(TYPE.DISCOUNT_BILL, 1, new Tuple(Fruits.PEAR,
	 * 4));
	 */
	private static TupleResult applyPearOffer(Offer offer, Map<Object, Tuple> buy,
			Map<Fruits, Tuple<Fruits, Double>> collectProducts) {

		if (offer.getType() == TYPE.DISCOUNT_BILL) {
			System.out.println("Total of " + offer.getTuple().getKey() + " --> " + buy.get(Fruits.PEAR).getValue());
			System.out.println(
					"COMPRA -> " + buy.get(Fruits.PEAR).getKey() + ", TOTAL ITENS " + buy.get(Fruits.PEAR).getValue());

			Integer totalPears = (Integer) buy.get(Fruits.PEAR).getValue();
			Double valuePear = collectProducts.get(Fruits.PEAR).getValue();

			final Double buyValue = totalPears * valuePear;

			final Object value = offer.getTuple().getValue();

			Double discountValue = buyValue / (Double) value;

			if (discountValue > 0) {

			}

			return new TupleResult(Fruits.PEAR, totalPears, buyValue);
		}
		return null;
	}
}
