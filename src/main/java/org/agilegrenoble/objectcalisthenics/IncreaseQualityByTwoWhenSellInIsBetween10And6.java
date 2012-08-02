package org.agilegrenoble.objectcalisthenics;

public class IncreaseQualityByTwoWhenSellInIsBetween10And6 {

	protected Item item = null;
	
	public IncreaseQualityByTwoWhenSellInIsBetween10And6(Item item) {
		this.item = item;
	}

	public void execute() {
		if (item.hasSellInBetween10And6())
			item.increaseQuality(2);
	}

}
