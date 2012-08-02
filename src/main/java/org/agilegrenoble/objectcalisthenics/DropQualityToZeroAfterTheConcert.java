package org.agilegrenoble.objectcalisthenics;

public class DropQualityToZeroAfterTheConcert {

	protected Item item = null;
	
	public DropQualityToZeroAfterTheConcert(Item item) {
		this.item = item;
	}

	public void execute() {
		if (item.hasSellInLowerThanOrEqulas0())
			item.dropQualityToZero();
	}

}
