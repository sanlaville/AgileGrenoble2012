package org.agilegrenoble.objectcalisthenics;

public abstract class Item {
	protected String name;
	protected int sellIn;
	protected Quality quality;

	public Item(String name, int sellIn, Quality quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality.clone();
	}

	/**
	 * Update quality for the item
	 *
	 */
	public abstract void updateQuality();

	/**
	 *
	 * @return the quality for this item
	 */
	public Quality quality() {
		return quality.clone();
	}

	/**
	 * Decrease sellIn by the given value
	 *
	 * @param value
	 *            integer by which the sellIn should be increased.
	 */
	public void decreaseSellIn(int value) {
		sellIn -= value;
	}

	/**
	 * @return true if the sell by date has passed, false otherwise.
	 **/
	public boolean hasTheSellByDatePassed() {
		return sellIn <= 0;
	}

	public boolean hasSellInGreaterThan10() {
		return sellIn > 10;
	}

	public boolean hasSellInBetween10And6() {
		return (sellIn <= 10) && (sellIn >= 6) ;
	}

	public boolean hasSellInBetween5And1() {
		return (sellIn <= 5) && (sellIn >= 1) ;
	}

	public boolean hasSellInLowerThanOrEqulas0() {
		return sellIn <= 0;
	}


}
