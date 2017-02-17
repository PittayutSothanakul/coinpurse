package coinpurse;

import coinpurse.Coin;

/**
 * a coin with a monetary value and currency
 * 
 * @author Pittayut Sothanakul
 */
// TODO declare that Coin implements Comparable<Coin>
public class Coin implements Comparable<Coin> , Valuable{
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * Return the value of the coin.
	 * 
	 * @return the value.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Return the currency of the coin.
	 * 
	 * @return the currency.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Compare two coins by value and currency
	 * 
	 * @param arg
	 *            is another Object to compare to this one.
	 * @return true if the value and currncy is same , false if not same
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin other = (Coin) obj;
		if (this.value == other.value && this.currency == other.currency)
			return true;
		return false;
	}

	/**
	 * Order Coins by value so that the smaller value comes first
	 * 
	 * @param other
	 *            is object of Coin that you want to compare with
	 * @return 1 if this coin has greater value 0 if both have same value -1 if
	 *         this coin has lesser value
	 */
	public int compareTo(Coin other) {
		if (other == null)
			return -1;
		if (this.currency.equalsIgnoreCase(other.currency))
			return (int) Math.signum(this.value - other.value);
		return this.currency.compareToIgnoreCase(other.currency);

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
