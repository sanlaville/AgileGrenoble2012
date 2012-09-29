package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.rules.QualityIsNeverMoreThan50;
import org.agilegrenoble.objectcalisthenics.rules.UpdateQualityDependingOnSellIn;

public class BackstageItem extends Item {

	protected UpdateQualityDependingOnSellIn updateQualityDependingOnSellIn = null;
	protected QualityIsNeverMoreThan50 qualityIsNeverMoreThan50 = null;
	
	public BackstageItem(SellIn sellIn, Quality quality) {
		super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
		
		updateQualityDependingOnSellIn = new UpdateQualityDependingOnSellIn(this.sellIn, this.quality);
		qualityIsNeverMoreThan50 = new QualityIsNeverMoreThan50(this.quality);
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void updateQuality() {
		updateQualityDependingOnSellIn.execute();
		
		sellIn.decreaseSellIn(1);
		
		qualityIsNeverMoreThan50.execute();
	}

}
