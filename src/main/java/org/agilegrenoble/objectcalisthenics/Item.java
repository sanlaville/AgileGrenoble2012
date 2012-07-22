package org.agilegrenoble.objectcalisthenics;

public class Item {
	protected String name;
	protected int sellIn;
	protected int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.quality = quality;
		this.sellIn = sellIn;
	}

	/**
	 * Update quality for the item
	 * 
	 */
	public void updateQuality() {
		if (quality > 0) {
			if (!name.equals("Sulfuras, Hand of Ragnaros")) {
				decreaseQuality(1);
			}
		}

		if (!name.equals("Sulfuras, Hand of Ragnaros")) {
			decreaseSellIn(1);
		}

		if (sellIn < 0) {
			if (quality > 0) {
				if (!name.equals("Sulfuras, Hand of Ragnaros")) {
					decreaseQuality(1);
				}
			}
		}
	}

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
}
