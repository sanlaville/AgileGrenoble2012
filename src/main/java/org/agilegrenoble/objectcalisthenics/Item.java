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
		if (!name.equals("Aged Brie")
				&& !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			if (quality > 0) {
				if (!name.equals("Sulfuras, Hand of Ragnaros")) {
					decreaseQuality(1);
				}
			}
		} else {
			if (quality < 50) {
				increaseQuality(1);

				if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (sellIn < 11) {
						if (quality < 50) {
							increaseQuality(1);
						}
					}

					if (sellIn < 6) {
						if (quality < 50) {
							increaseQuality(1);
						}
					}
				}
			}
		}

		if (!name.equals("Sulfuras, Hand of Ragnaros")) {
			decreaseSellIn(1);
		}

		if (sellIn < 0) {
			if (!name.equals("Aged Brie")) {
				if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (quality > 0) {
						if (!name.equals("Sulfuras, Hand of Ragnaros")) {
							decreaseQuality(1);
						}
					}
				} else {
					resetQualityToZero();
				}
			} else {
				if (quality < 50) {
					increaseQuality(1);
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
