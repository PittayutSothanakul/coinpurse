package coinpurse;

import java.awt.RenderingHints.Key;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 *
 * @author Pittayut Sothanakul
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns only the coins
	 * that have a currency that matches the parameter value.
	 * 
	 * @param coinlist
	 *            is a List of Coin objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> coinlist, String currency) {

		List<Valuable> list = new ArrayList<>();
		for (Valuable valuable : coinlist) {
			if (valuable.getCurrency().equals(currency)) {
				list.add(valuable);
			}
		}
		return list;
	}

	/**
	 * Method to sort a list of coins by currency. On return, the list (coins)
	 * will be ordered by currency.
	 * 
	 * @param coins
	 *            is a List of Coin objects we want to sort.
	 *
	 * 
	 */
	public static void sortByCurrency(List<Valuable> valuables) {
		Collections.sort(valuables, new ValuableComparator());
	}

	/**
	 * Sum coins by currency and print the sum for each currency. Print one line
	 * for the sum of each currency. For example: coins = { Coin(1,"Baht"),
	 * Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") } then
	 * sumByCurrency(coins) would print:
	 * 
	 * 11.00 Baht 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the coins by currency first. :-)
	 */
	public static void sumByCurrency(List<Valuable> valuables) {
		// sortByCurrency(valuables);
		// String currency = valuables.get(0).getCurrency();
		// double sum = 0.0;
		// for (Valuable cur : valuables) {
		// if (cur.getCurrency().equals(currency)) {
		// sum += cur.getValue();
		// } else {
		// System.out.printf("%.2f %s\n", sum, currency);
		// sum = 0;
		// sum += cur.getValue();
		// currency = cur.getCurrency();
		// }
		// }

		// Map<String, Double> map = new HashMap<>();
		// for (Valuable c : valuables) {
		// map.put(c.getCurrency(), map.getOrDefault(c.getCurrency(), 0.0) +
		// c.getValue());
		// }
		// for (String currency : map.keySet()) {
		// System.out.println(map.get(currency) + " " + currency);
		// }

		Map<String, Double> map = new HashMap<>();
		for (Valuable c : valuables) {
			if (map.containsKey(c.getCurrency())) {
				map.put(c.getCurrency(), map.get(c.getCurrency()) + c.getValue());

			} else {
				map.put(c.getCurrency(), c.getValue());
			}
		}

		for (String cu : map.keySet()) {
			System.out.println(cu + " " + map.get(cu));
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of " + currency);
		List<Valuable> valuables = makeInternationalValuables();
		int size = valuables.size();
		System.out.print(" INPUT: ");
		printList(valuables, " ");
		List<Valuable> rupees = filterByCurrency(valuables, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (valuables.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		valuables = makeInternationalValuables();
		System.out.print(" INPUT: ");
		printList(valuables, " ");
		sortByCurrency(valuables);
		System.out.print("RESULT: ");
		printList(valuables, " ");

		System.out.println("\nSum coins by currency");
		valuables = makeInternationalValuables();
		System.out.print("coins= ");
		printList(valuables, " ");
		sumByCurrency(valuables);

	}

	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalValuables() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values. */
	public static List<Valuable> makeCoins(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values)
			list.add(new Coin(value, currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}
}
