package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.Quality;

public class UpdateQualityDependingOnSellIn {
	
	protected IncreaseQualityByOneWhenSellInIsGreaterThan10 increaseQualityByOneWhenSellInIsGreaterThan10 = null;
	protected IncreaseQualityByTwoWhenSellInIsBetween10And6 increaseQualityByTwoWhenSellInIsBetween10And6 = null;
	protected IncreaseQualityByThreeWhenSellInIsBetween5And1 increaseQualityByThreeWhenSellInIsBetween5And1 = null;
	protected DropQualityToZeroAfterTheConcert dropQualityToZeroAfterTheConcert = null;

	public UpdateQualityDependingOnSellIn(Item item, Quality quality) {
		increaseQualityByOneWhenSellInIsGreaterThan10 = new IncreaseQualityByOneWhenSellInIsGreaterThan10(
				item, quality);
		increaseQualityByTwoWhenSellInIsBetween10And6 = new IncreaseQualityByTwoWhenSellInIsBetween10And6(
				item, quality);
		increaseQualityByThreeWhenSellInIsBetween5And1 = new IncreaseQualityByThreeWhenSellInIsBetween5And1(
				item, quality);
		dropQualityToZeroAfterTheConcert = new DropQualityToZeroAfterTheConcert(
				item, quality);
	}

	public void execute() {
		increaseQualityByOneWhenSellInIsGreaterThan10.execute();
		increaseQualityByTwoWhenSellInIsBetween10And6.execute();
		increaseQualityByThreeWhenSellInIsBetween5And1.execute();
		dropQualityToZeroAfterTheConcert.execute();
	}

}
