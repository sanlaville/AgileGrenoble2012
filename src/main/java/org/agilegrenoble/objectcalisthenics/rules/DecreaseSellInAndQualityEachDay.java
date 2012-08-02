package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;

public class DecreaseSellInAndQualityEachDay {

	protected Item item = null;
	
	/**
	 * Create a new instance for the given item
	 * @param item the item who should be decrease. Must be not null.
	 */
	public DecreaseSellInAndQualityEachDay(Item item) {
		this.item = item;
	}

	public void execute() {
		item.decreaseQuality(1);
		item.decreaseSellIn(1);
	}

}
