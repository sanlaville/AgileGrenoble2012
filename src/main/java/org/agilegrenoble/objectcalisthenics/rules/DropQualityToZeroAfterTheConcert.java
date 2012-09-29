package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.Quality;

public class DropQualityToZeroAfterTheConcert {

	protected Item item = null;
	protected Quality quality = null;
	
	public DropQualityToZeroAfterTheConcert(Item item, Quality quality) {
		this.item = item;
		this.quality = quality;
	}

	public void execute() {
		if (item.hasSellInLowerThanOrEqulas0())
			quality.dropQualityToZero();
	}

}
