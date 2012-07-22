package org.agilegrenoble.objectcalisthenics;

public class BrieItem extends Item {

	
	public BrieItem(int sellIn, int quality) {
		super("Aged Brie", sellIn, quality);
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void updateQuality() {

		decreaseSellIn(1);
		
		if (quality < 50) {
			increaseQuality(1);
		}

		if (sellIn < 0) {
			if (quality < 50) {
				increaseQuality(1);
			}
		}
	}

}
