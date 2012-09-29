package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;

public class DropQualityToZeroAfterTheConcert {

	protected SellIn sellIn = null;
	protected Quality quality = null;
	
	/**
	 * Create a new instance for this business rule.
	 * 
	 * @param sellIn the sellIn defining the date of the concert. Must be not null.
	 * @param quality the quality to drop to zero. Must be not null.
	 */
	public DropQualityToZeroAfterTheConcert(SellIn sellIn, Quality quality) {
		this.sellIn = sellIn;
		this.quality = quality;
	}

	public void execute() {
		if (sellIn.hasSellInLowerThanOrEquals0())
			quality.dropQualityToZero();
	}

}
