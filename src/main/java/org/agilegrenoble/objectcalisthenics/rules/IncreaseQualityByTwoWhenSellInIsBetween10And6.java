package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.Quality;

public class IncreaseQualityByTwoWhenSellInIsBetween10And6 {

	protected Item item = null;
	protected Quality quality = null;
	
	public IncreaseQualityByTwoWhenSellInIsBetween10And6(Item item, Quality quality) {
		this.item = item;
		this.quality = quality;
	}

	public void execute() {
		if (item.hasSellInBetween10And6())
			quality.increaseQuality(2);
	}

}
