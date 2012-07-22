package org.agilegrenoble.objectcalisthenics;

public class BackstageItem extends Item {

	public BackstageItem(int sellIn, int quality) {
		super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void updateQuality() {
		if (quality < 50) {
			increaseQuality(1);

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

		decreaseSellIn(1);

		if (sellIn < 0) {
			resetQualityToZero();
		}
	}

}
