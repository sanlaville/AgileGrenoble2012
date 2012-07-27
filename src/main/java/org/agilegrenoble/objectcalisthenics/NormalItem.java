package org.agilegrenoble.objectcalisthenics;

public class NormalItem extends Item {

	public NormalItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	/**
	 * Update quality for the item
	 * 
	 */
	public void updateQuality() {
		if (quality > 0) {
			decreaseQuality(1);
		}

		decreaseSellIn(1);

		if (sellIn < 0) {
			if (quality > 0) {
				decreaseQuality(1);
			}
		}
	}
}
