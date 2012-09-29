package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.Quality;

public class IncreaseQualityByOneWhenSellInIsGreaterThan10 {

	protected Item item = null;
	protected Quality quality = null;
	
	public IncreaseQualityByOneWhenSellInIsGreaterThan10(Item item, Quality quality) {
		this.item = item;
		this.quality = quality;
	}

	public void execute() {
		if (item.hasSellInGreaterThan10())
			quality.increaseQuality(1);
	}

}
