package coinpurse;

/**
 * Banknote represents coinage (money) with a fixed value and currency.
 * 
 * @author Pittayut Sothanakul
 *
 */
public class BankNote implements Valuable {
	private double value;
	private String currency;
	private long serialNumber;
	static long nextSerialNumber = 1000000;

	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value
	 *            is the value of banknote.
	 */
	public BankNote(double value) {
		this.value = value;

	}

	/**
	 * A banknote with given value and currency.
	 * 
	 * @param value
	 *            is the value of banknote.
	 * @param currency
	 *            is the currency of banknote.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = BankNote.nextSerialNumber;
		BankNote.nextSerialNumber++;
	}

	/**
	 * Return the value of the banknote.
	 * 
	 * @return the value.
	 */
	@Override
	public double getValue() {

		return this.value;
	}

	/**
	 * Return the currency of the banknote.
	 * 
	 * @return the currency.
	 */
	@Override
	public String getCurrency() {

		return this.currency;
	}

	/**
	 * Return the serialnumber of the banknote.
	 * 
	 * @return the serialnumber.
	 */
	public long getSerialNumber() {
		return this.serialNumber;
	}

	/**
	 * set the number of serialnumber
	 * 
	 * @param hint
	 *            is the text that you want to change
	 */
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;

	}

	/**
	 * Compare two coins by value and currency. They are equal if the value and
	 * currency matches.
	 * 
	 * @param arg
	 *            is another Object to compare to this one.
	 * @return true if the value is same and the currency is same, false
	 *         otherwise.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) obj;
		if (this.value == other.value && this.currency == other.currency)
			return true;
		return false;
	}

	/**
	 * Return a string representation of this BankNote
	 * 
	 * @return string that describes the banknote
	 * 
	 */
	public String toString() {

		return String.format("%.2f %s", value, currency);
	}
}
