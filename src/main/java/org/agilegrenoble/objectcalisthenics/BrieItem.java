package org.agilegrenoble.objectcalisthenics;

public class BrieItem extends Item {

	protected DecreaseSellInAndIncreaseQualityEachDay decreaseSellInAndIncreaseQualityEachDay = null;
	protected QualityIsNeverMoreThan50 qualityIsNeverMoreThan50 = null;

	public BrieItem(int sellIn, int quality) {
		super("Aged Brie", sellIn, quality);
		decreaseSellInAndIncreaseQualityEachDay = new DecreaseSellInAndIncreaseQualityEachDay(
				this);
		qualityIsNeverMoreThan50 = new QualityIsNeverMoreThan50(this);
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
