package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.rules.DecreaseSellInAndQualityEachDay;
import org.agilegrenoble.objectcalisthenics.rules.OnceTheSellByDateHasPassedQualityDegradesTwice;
import org.agilegrenoble.objectcalisthenics.rules.QualityIsNeverNegative;

public class NormalItem extends Item {

	protected DecreaseSellInAndQualityEachDay decreaseSellInAndQualityEachDay = null;
	protected OnceTheSellByDateHasPassedQualityDegradesTwice onceTheSellByDateHasPassedQualityDegradesTwice = null;
	protected QualityIsNeverNegative qualityIsNeverNegative = null;
	
	public NormalItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		decreaseSellInAndQualityEachDay = new DecreaseSellInAndQualityEachDay(this); 
		onceTheSellByDateHasPassedQualityDegradesTwice = new OnceTheSellByDateHasPassedQualityDegradesTwice(this);
		qualityIsNeverNegative = new QualityIsNeverNegative(this);
	}

	/**
	 * Update quality for the item
	 * 
	 */
	public void updateQuality() {
		decreaseSellInAndQualityEachDay.execute();
		onceTheSellByDateHasPassedQualityDegradesTwice.execute();
		qualityIsNeverNegative.execute();
	}
}
