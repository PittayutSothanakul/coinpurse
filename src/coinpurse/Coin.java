package coinpurse;

import coinpurse.Coin;

/**
 * a coin with a monetary value and currency
 * 
 * @author Pittayut Sothanakul
 */
// TODO declare that Coin implements Comparable<Coin>
public class Coin extends AbstractValuable {
	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value) {
		super(value, DEFAULT_CURRENCY);

	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		super(value, currency);

	}

	/**
	 * Return a string representation of this Coin
	 * 
	 * @return string that describes the coin
	 * 
	 */
	public String toString() {

		return String.format("%.2f %s", value, currency);
	}

}
