package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;

public class IncreaseQualityByThreeWhenSellInIsBetween5And1 {

	protected SellIn sellIn = null;
	protected Quality quality = null;
	
	/**
	 * Create a new instance for this business rule.
	 * 
	 * @param sellIn the sellIn used by this rule. Must be not null.
	 * @param quality the quality to increase. Must be not null.
	 */
	public IncreaseQualityByThreeWhenSellInIsBetween5And1(SellIn sellIn, Quality quality) {
		this.sellIn = sellIn;
		this.quality = quality;
	}

	public void execute() {
		if (sellIn.hasSellInBetween5And1())
			quality.increaseQuality(3);
	}

}
