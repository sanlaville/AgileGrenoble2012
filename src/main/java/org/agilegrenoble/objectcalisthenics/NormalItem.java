package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.rules.DecreaseSellInAndQualityEachDay;
import org.agilegrenoble.objectcalisthenics.rules.OnceTheSellByDateHasPassedQualityDegradesTwice;
import org.agilegrenoble.objectcalisthenics.rules.QualityIsNeverNegative;

public class NormalItem extends Item {

	protected DecreaseSellInAndQualityEachDay decreaseSellInAndQualityEachDay = null;
	protected OnceTheSellByDateHasPassedQualityDegradesTwice onceTheSellByDateHasPassedQualityDegradesTwice = null;
	protected QualityIsNeverNegative qualityIsNeverNegative = null;
	
	public NormalItem(String name, SellIn sellIn, Quality quality) {
		super(name, sellIn, quality);
		decreaseSellInAndQualityEachDay = new DecreaseSellInAndQualityEachDay(this.sellIn, this.quality); 
		onceTheSellByDateHasPassedQualityDegradesTwice = new OnceTheSellByDateHasPassedQualityDegradesTwice(this.sellIn, this.quality);
		qualityIsNeverNegative = new QualityIsNeverNegative(this.quality);
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
