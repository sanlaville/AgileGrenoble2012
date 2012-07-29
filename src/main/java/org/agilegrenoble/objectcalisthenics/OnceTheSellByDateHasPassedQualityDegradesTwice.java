package org.agilegrenoble.objectcalisthenics;

public class OnceTheSellByDateHasPassedQualityDegradesTwice {

	protected Item item = null;
	
	public OnceTheSellByDateHasPassedQualityDegradesTwice(Item item) {
		this.item = item;
	}

	public void execute() {
		if (item.hasTheSellByDatePassed())
			item.decreaseQuality(1);
	}

}
