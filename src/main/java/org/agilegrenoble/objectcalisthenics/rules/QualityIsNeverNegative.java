package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;

public class QualityIsNeverNegative {

	protected Item item = null;
	
	public QualityIsNeverNegative(Item item) {
		this.item = item;
	}

	public void execute() {
		if (item.hasNegativeQuality())
			item.dropQualityToZero();
	}

}
