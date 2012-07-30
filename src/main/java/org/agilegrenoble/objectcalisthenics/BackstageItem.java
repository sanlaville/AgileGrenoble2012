package org.agilegrenoble.objectcalisthenics;

public class BackstageItem extends Item {

	protected QualityIsNeverMoreThan50 qualityIsNeverMoreThan50 = null;

	public BackstageItem(int sellIn, int quality) {
		super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
		qualityIsNeverMoreThan50 = new QualityIsNeverMoreThan50(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void updateQuality() {
		increaseQuality(1);

		if (sellIn < 11) {
			increaseQuality(1);
		}

		if (sellIn < 6) {
			increaseQuality(1);
		}

		qualityIsNeverMoreThan50.execute();

		decreaseSellIn(1);

		if (sellIn < 0) {
			resetQualityToZero();
		}
	}

}
