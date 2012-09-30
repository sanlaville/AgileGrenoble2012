package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;

public class DecreaseSellInAndIncreaseQualityEachDay implements IBusinessRule {

	protected SellIn sellIn = null;
	protected Quality quality = null;
	
	/**
	 * Create a new instance for this business rule.
	 * 
	 * @param sellIn the sellIn to decrease. Must be not null.
	 * @param quality the quality to increase. Must be not null.
	 */
	public DecreaseSellInAndIncreaseQualityEachDay(SellIn sellIn, Quality quality) {
		this.sellIn = sellIn;
		this.quality = quality;
	}

	@Override
	public void execute() {
		sellIn.decreaseSellIn(1);
		quality.increaseQuality(1);
	}

}
