package org.agilegrenoble.objectcalisthenics;

public class SellIn implements Cloneable {

	private int value;

	/** create a new instance of SellIn with the given initial value
	 * 
	 * @param initialValue the initial value for the new SellIn instance
	 */
	public SellIn(int initialValue) {
		this.value = initialValue;
	}
	
	/**
	 * Decrease sellIn by the given value
	 *
	 * @param value
	 *            integer by which the sellIn should be increased.
	 */
	public void decreaseSellIn(int value) {
		this.value -= value;
	}

	/**
	 * @return true if the sell by date has passed, false otherwise.
	 **/
	public boolean hasTheSellByDatePassed() {
		return value <= 0;
	}

	/**
	 * 
	 * @return true if the sellIn is greater than 10, false otherwise.
	 */
	public boolean hasSellInGreaterThan10() {
		return value > 10;
	}

	/**
	 * 
	 * @return true if the sellIn is between 6 and 10, false otherwise.
	 */
	public boolean hasSellInBetween10And6() {
		return (value <= 10) && (value >= 6) ;
	}

	/**
	 * 
	 * @return true if the sellIn is between 1 and 5, false otherwise.
	 */
	public boolean hasSellInBetween5And1() {
		return (value <= 5) && (value >= 1) ;
	}

	/**
	 * 
	 * @return true if the sellIn is lower or equals to 0, false otherwise.
	 */
	public boolean hasSellInLowerThanOrEquals0() {
		return value <= 0;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SellIn other = (SellIn) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SellIn [value=" + value + "]";
	}

	public SellIn clone() {
		SellIn clone = null;
		try {
			clone = (SellIn) super.clone();
		} catch (CloneNotSupportedException cnse) {
			// This is not possible
		}
		return clone;
	}

	/**
	 *
	 * @return the value of the sellIn
	 */
	public int value() {
		return value;
	}
}
