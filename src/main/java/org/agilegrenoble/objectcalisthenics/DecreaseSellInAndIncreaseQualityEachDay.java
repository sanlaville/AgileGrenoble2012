package org.agilegrenoble.objectcalisthenics;

public class DecreaseSellInAndIncreaseQualityEachDay {

	protected Item item = null;
	
	/**
	 * Create a new instance for the given item
	 * @param item the item who should be decrease. Must be not null.
	 */
	public DecreaseSellInAndIncreaseQualityEachDay(Item item) {
		this.item = item;
	}

	public void execute() {
		item.decreaseSellIn(1);
		item.increaseQuality(1);
	}

}
