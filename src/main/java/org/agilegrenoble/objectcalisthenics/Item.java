package org.agilegrenoble.objectcalisthenics;

public abstract class Item {
	protected String name;
	protected SellIn sellIn;
	protected Quality quality;

	public Item(String name, SellIn sellIn, Quality quality) {
		this.name = name;
		this.sellIn = sellIn.clone();
		this.quality = quality.clone();
	}

	/**
	 * Update quality for the item
	 *
	 */
	public abstract void updateQuality();

	/**
	 *
	 * @return a clone of the quality for this item
	 */
	public Quality quality() {
		return quality.clone();
	}
	
	/**
	 *
	 * @return a clone of the sellIn for this item
	 */
	public SellIn sellIn() {
		return sellIn.clone();
	}
}
