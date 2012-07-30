package org.agilegrenoble.objectcalisthenics;

public abstract class Item {
	protected String name;
	protected int sellIn;
	protected int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	/**
	 * Update quality for the item
	 * 
	 */
	public abstract void updateQuality();

	/**
	 * Reset quality to zero
	 */
	protected void resetQualityToZero() {
		quality = 0;
	}

	/**
	 * Decrease sellIn by the given value
	 * 
	 * @param value
	 *            integer by which the sellIn should be increased.
	 */
	protected void decreaseSellIn(int value) {
		sellIn -= value;
	}

	/**
	 * Increase quality by the given value
	 * 
	 * @param value
	 *            integer by which the quality should be increased.
	 */
	protected void increaseQuality(int value) {
		quality += value;

	}

	/**
	 * Decrease quality by the given value
	 * 
	 * @param value
	 *            integer by which the quality should be increased.
	 */
	protected void decreaseQuality(int value) {
		quality -= value;
	}

	/**
	 * @return true if the sell by date has passed, false otherwise.
	 **/
	public boolean hasTheSellByDatePassed() {
		if (sellIn > 0)
			return false;
		return true;
	}

	public boolean hasNegativeQuality() {
		if (quality < 0)
			return true;

		return false;
	}

	public boolean hasQualityGreaterThan50() {
		if (quality > 50)
			return true;

		return false;
	}

	public void keepQualityTo50() {
		quality = 50;
	}
}
