package org.agilegrenoble.objectcalisthenics;

public class QualityIsNeverMoreThan50 {

	protected Item item = null;
	
	public QualityIsNeverMoreThan50(Item item) {
		this.item = item; 
	}

	public void execute() {
		if (item.hasQualityGreaterThan50())
			item.keepQualityTo50();
	}

}
