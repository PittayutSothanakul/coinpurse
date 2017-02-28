package coinpurse;

import coinpurse.Coin;

/**
 * a coin with a monetary value and currency
 * 
 * @author Pittayut Sothanakul
 */
// TODO declare that Coin implements Comparable<Coin>
public class Coin extends AbstractValuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	private double newvalue;
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
		setNewvalue(value);
		return String.format("%.0f - %s coin", this.newvalue, this.currency);
	}

	/**
	 * Set the value of money if value less than 1, multiply by 100.
	 * 
	 * @param newvalue is the value that you want to change.
	 */
	public void setNewvalue(double newvalue) {
		if (this.value < 1) {
			this.newvalue = value * 100;
		} else
			this.newvalue = value;

	}


}
