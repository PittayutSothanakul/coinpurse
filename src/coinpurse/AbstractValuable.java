package coinpurse;

public class AbstractValuable implements Valuable  {

	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	protected double value;
	/** The currency, of course. */
	protected String currency;

	public AbstractValuable(double value , String currency) {
		this.value =value;
		this.currency = currency;
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
		Valuable other = (Valuable) obj;
		if (this.value == other.getValue() && this.currency == other.getCurrency())
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

	// public int compareTo(Coin other) {
	// if (other == null)
	// return -1;
	// if (this.currency.equalsIgnoreCase(other.currency))
	// return (int) Math.signum(this.value - other.value);
	// return this.currency.compareToIgnoreCase(other.currency);
	//
	// }

	public int compareTo(Valuable other) {
		if (other == null) {
			return -1;
		}
		return (int) Math.signum(this.value - other.getValue());
	}

}