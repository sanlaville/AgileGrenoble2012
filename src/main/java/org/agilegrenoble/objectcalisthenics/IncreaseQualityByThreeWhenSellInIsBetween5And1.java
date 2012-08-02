package org.agilegrenoble.objectcalisthenics;

public class IncreaseQualityByThreeWhenSellInIsBetween5And1 {

	protected Item item = null;
	
	public IncreaseQualityByThreeWhenSellInIsBetween5And1(Item item) {
		this.item = item;
	}

	public void execute() {
		if (item.hasSellInBetween5And1())
			item.increaseQuality(3);
	}

}
