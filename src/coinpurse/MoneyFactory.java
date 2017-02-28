package coinpurse;

import org.junit.experimental.theories.Theories;

/**
 * MoneyFactory is a abstract class for creating Valuable items.
 * 
 * @author Pittayut Sothanakul
 *
 */
public abstract class MoneyFactory {

	private static MoneyFactory FACTORY;
	protected long nextSerialNumber = 1000000;

	protected MoneyFactory() {
	}

	public static MoneyFactory getInstance() {
		if (FACTORY == null)
			FACTORY = new ThaiMoneyFactory();
		return FACTORY;
	}

	protected abstract Valuable createMoney(double value) throws IllegalArgumentException;

	protected Valuable createMoney(String value) {
		try {
			double doubleValue = Double.parseDouble(value);
			return this.createMoney(doubleValue);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	public static void setMoneyFactory(MoneyFactory factory) {
		FACTORY = factory;

	}

}
