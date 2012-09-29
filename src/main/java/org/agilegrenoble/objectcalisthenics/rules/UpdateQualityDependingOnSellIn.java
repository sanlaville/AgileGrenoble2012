package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;

public class UpdateQualityDependingOnSellIn {
	
	protected IncreaseQualityByOneWhenSellInIsGreaterThan10 increaseQualityByOneWhenSellInIsGreaterThan10 = null;
	protected IncreaseQualityByTwoWhenSellInIsBetween10And6 increaseQualityByTwoWhenSellInIsBetween10And6 = null;
	protected IncreaseQualityByThreeWhenSellInIsBetween5And1 increaseQualityByThreeWhenSellInIsBetween5And1 = null;
	protected DropQualityToZeroAfterTheConcert dropQualityToZeroAfterTheConcert = null;

	public UpdateQualityDependingOnSellIn(SellIn sellIn, Quality quality) {
		increaseQualityByOneWhenSellInIsGreaterThan10 = new IncreaseQualityByOneWhenSellInIsGreaterThan10(
				sellIn, quality);
		increaseQualityByTwoWhenSellInIsBetween10And6 = new IncreaseQualityByTwoWhenSellInIsBetween10And6(
				sellIn, quality);
		increaseQualityByThreeWhenSellInIsBetween5And1 = new IncreaseQualityByThreeWhenSellInIsBetween5And1(
				sellIn, quality);
		dropQualityToZeroAfterTheConcert = new DropQualityToZeroAfterTheConcert(
				sellIn, quality);
	}

	public void execute() {
		increaseQualityByOneWhenSellInIsGreaterThan10.execute();
		increaseQualityByTwoWhenSellInIsBetween10And6.execute();
		increaseQualityByThreeWhenSellInIsBetween5And1.execute();
		dropQualityToZeroAfterTheConcert.execute();
	}

}
