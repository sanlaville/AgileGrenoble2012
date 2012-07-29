package org.agilegrenoble.objectcalisthenics;

public class QualityIsNeverNegative {

	protected Item item = null;
	
	public QualityIsNeverNegative(Item item) {
		this.item = item;
	}

	public void execute() {
		if (item.hasNegativeQuality())
			item.resetQualityToZero();
	}

}
