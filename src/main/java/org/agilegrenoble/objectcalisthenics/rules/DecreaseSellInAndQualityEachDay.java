package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.Quality;

public class DecreaseSellInAndQualityEachDay {

	protected Item item = null;
	protected Quality quality = null;
	
	/**
	 * Create a new instance for the given item
	 * @param item the item who should be decrease. Must be not null.
	 */
	public DecreaseSellInAndQualityEachDay(Item item, Quality quality) {
		this.item = item;
		this.quality = quality;
	}

	public void execute() {
		quality.decreaseQuality(1);
		item.decreaseSellIn(1);
	}

}
