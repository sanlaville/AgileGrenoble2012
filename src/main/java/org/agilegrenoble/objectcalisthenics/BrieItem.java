package org.agilegrenoble.objectcalisthenics;

public class BrieItem extends Item {

	protected DecreaseSellInAndIncreaseQualityEachDay decreaseSellInAndIncreaseQualityEachDay = null;
	
	public BrieItem(int sellIn, int quality) {
		super("Aged Brie", sellIn, quality);
		decreaseSellInAndIncreaseQualityEachDay = new DecreaseSellInAndIncreaseQualityEachDay(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void updateQuality() {

		decreaseSellInAndIncreaseQualityEachDay.execute();

		if (sellIn < 0) {
			if (quality < 50) {
				increaseQuality(1);
			}
		}
		
		if (quality > 50) {
			quality = 50;
		}
	}

}
