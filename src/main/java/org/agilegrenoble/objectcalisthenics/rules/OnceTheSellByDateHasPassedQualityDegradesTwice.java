package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.Quality;

public class OnceTheSellByDateHasPassedQualityDegradesTwice {

	protected Item item = null;
	protected Quality quality = null;
	
	public OnceTheSellByDateHasPassedQualityDegradesTwice(Item item, Quality quality) {
		this.item = item;
		this.quality = quality;
	}

	public void execute() {
		if (item.hasTheSellByDatePassed())
			quality.decreaseQuality(1);
	}

}
