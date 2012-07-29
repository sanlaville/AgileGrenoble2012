package org.agilegrenoble.objectcalisthenics;

public class NormalItem extends Item {

	protected DecreaseSellInAndQualityEachDay decreaseSellInAndQualityEachDay = null;
	
	public NormalItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		decreaseSellInAndQualityEachDay = new DecreaseSellInAndQualityEachDay(this); 
	}

	/**
	 * Update quality for the item
	 * 
	 */
	public void updateQuality() {
		decreaseSellInAndQualityEachDay.execute();

		if (sellIn < 0) {
			if (quality > 0) {
				decreaseQuality(1);
			}
		}
		
		if (quality < 0) {
			quality = 0;
		}
	}
}
