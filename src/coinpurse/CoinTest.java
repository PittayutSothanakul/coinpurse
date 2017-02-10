package coinpurse;

/**
 * Main to test a Coin method to the console.
 * 
 * @author Pittayut Sothanakul
 *
 */
public class CoinTest {
	/**
	 * Crete method main to run a Coin method.
	 * @param args
	 */
	public static void main(String[] args) {
		Coin one = new Coin(1);
		Coin five = new Coin(5);
		Coin malay = new Coin(0.5, "Ringgit");
		System.out.println(one.toString());
		System.out.println(one.compareTo(five));
		System.out.println(five.compareTo(one));
		System.out.println(one.equals(five));
	}
}