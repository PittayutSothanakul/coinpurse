package coinpurse;

public class BankNote implements Valuable {
	private double value;
	private String currency;
	private long serialNumber;
	static long nextSerialNumber = 1000000;

	public BankNote(double value) {
		this.value = value;

	}

	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	@Override
	public double getValue() {

		return this.value;
	}

	@Override
	public String getCurrency() {

		return this.currency;
	}

	public long getSerialNumber() {
		return this.serialNumber;
	}

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

	public int compareTo(BankNote other) {
		if (other == null)
			return -1;
		if (this.currency.equalsIgnoreCase(other.currency))
			return (int) Math.signum(this.value - other.value);
		return this.currency.compareToIgnoreCase(other.currency);

	}

	public String toString() {

		return String.format("%.2f %s", value, currency);
	}
}
