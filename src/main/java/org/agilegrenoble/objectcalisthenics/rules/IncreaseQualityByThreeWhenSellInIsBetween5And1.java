package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.Quality;

public class IncreaseQualityByThreeWhenSellInIsBetween5And1 {

	protected Item item = null;
	protected Quality quality = null;
	
	public IncreaseQualityByThreeWhenSellInIsBetween5And1(Item item, Quality quality) {
		this.item = item;
		this.quality = quality;
	}

	public void execute() {
		if (item.hasSellInBetween5And1())
			quality.increaseQuality(3);
	}

}
