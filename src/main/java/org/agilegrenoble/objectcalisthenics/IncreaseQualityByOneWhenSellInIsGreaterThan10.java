package org.agilegrenoble.objectcalisthenics;

public class IncreaseQualityByOneWhenSellInIsGreaterThan10 {

	protected Item item = null;
	
	public IncreaseQualityByOneWhenSellInIsGreaterThan10(Item item) {
		this.item = item;
	}

	public void execute() {
		if (item.hasSellInGreaterThan10())
			item.increaseQuality(1);
	}

}
