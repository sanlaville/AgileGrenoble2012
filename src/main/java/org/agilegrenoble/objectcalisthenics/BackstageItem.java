package org.agilegrenoble.objectcalisthenics;

public class BackstageItem extends Item {

	protected UpdateQualityDependingOnSellIn updateQualityDependingOnSellIn = null;
	protected QualityIsNeverMoreThan50 qualityIsNeverMoreThan50 = null;
	
	public BackstageItem(int sellIn, int quality) {
		super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
		
		updateQualityDependingOnSellIn = new UpdateQualityDependingOnSellIn(this);
		qualityIsNeverMoreThan50 = new QualityIsNeverMoreThan50(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void updateQuality() {
		updateQualityDependingOnSellIn.execute();
		
		decreaseSellIn(1);
		
		qualityIsNeverMoreThan50.execute();
	}

}
