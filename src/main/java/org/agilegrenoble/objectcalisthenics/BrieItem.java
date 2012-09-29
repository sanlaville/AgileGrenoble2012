package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.rules.DecreaseSellInAndIncreaseQualityEachDay;
import org.agilegrenoble.objectcalisthenics.rules.QualityIsNeverMoreThan50;

public class BrieItem extends Item {

	protected DecreaseSellInAndIncreaseQualityEachDay decreaseSellInAndIncreaseQualityEachDay = null;
	protected QualityIsNeverMoreThan50 qualityIsNeverMoreThan50 = null;

	public BrieItem(int sellIn, Quality quality) {
		super("Aged Brie", sellIn, quality);
		decreaseSellInAndIncreaseQualityEachDay = new DecreaseSellInAndIncreaseQualityEachDay(
				this, this.quality);
		qualityIsNeverMoreThan50 = new QualityIsNeverMoreThan50(this.quality);
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void updateQuality() {
		decreaseSellInAndIncreaseQualityEachDay.execute();
		qualityIsNeverMoreThan50.execute();
	}

}
