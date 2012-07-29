package org.agilegrenoble.objectcalisthenics;

public class NormalItem extends Item {

	protected DecreaseSellInAndQualityEachDay decreaseSellInAndQualityEachDay = null;
	protected OnceTheSellByDateHasPassedQualityDegradesTwice onceTheSellByDateHasPassedQualityDegradesTwice = null;
	
	public NormalItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		decreaseSellInAndQualityEachDay = new DecreaseSellInAndQualityEachDay(this); 
		onceTheSellByDateHasPassedQualityDegradesTwice = new OnceTheSellByDateHasPassedQualityDegradesTwice(this);
	}

	/**
	 * Update quality for the item
	 * 
	 */
	public void updateQuality() {
		decreaseSellInAndQualityEachDay.execute();
		onceTheSellByDateHasPassedQualityDegradesTwice.execute();
		
		if (quality < 0) {
			quality = 0;
		}
	}
}
