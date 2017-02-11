package coinpurse;

//TODO import ArrayList and Collections (so you can use Collections.sort())
import java.util.ArrayList;
import java.util.Collections;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Pittayt Sothanakul
 */
public class Purse {
	/** Collection of objects in the purse. */
	// TODO declare a List of Coins named "money".

	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	ArrayList<Coin> money = new ArrayList<Coin>();
	private final int capacity;
	private int balance;
	private int count;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		// TODO initialize the attributes of purse
		ArrayList<Coin> coins = new ArrayList<Coin>();
		this.capacity = capacity;

	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		// for (int i = 0; i < money.size() - 1; i++) {
		// balance += money.get(i).getValue();
		// }
		for (Coin x : money) {
			double balance = 0;
			balance += x.getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	// TODO write accessor method for capacity. Use Java naming convention.
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		// TODO complete this method
		// TODO Don't Repeat Yourself: Avoid writing duplicate code.
		if (count() >= capacity)
			return true;
		return false;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		// if the purse is already full then can't insert anything.
		// TODO complete the insert method
		if (isFull() || coin.getValue() == 0) {
			return false;
		}
		money.add(coin);
		Collections.sort(money);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Coin[] withdraw(double amount) {
		// TODO don't allow to withdraw amount < 0
		ArrayList<Coin> temptlist = new ArrayList<Coin>();

		/*
		 * See lab sheet for outline of a solution, or devise your own solution.
		 */

		if (amount < 0) {
			return null;
		}
		for (int i = money.size() - 1; i >= 0; i--) {
			if (money.get(i).getValue() <= amount) {
				temptlist.add(money.get(i));
				amount -= money.get(i).getValue();
				money.remove(i);
			}
		}
		if (amount > 0) {
			money.addAll(temptlist);
			return null;
		}

		Coin[] array = new Coin[temptlist.size()];
		temptlist.toArray(array);
		return array; 
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		// TODO complete this
		return "you forgot to write Purse.toString()";
	}

}
// TODO remove the TODO comments after you complete them.
// TODO When you are finished, there should not be any TODO. Including this one.
