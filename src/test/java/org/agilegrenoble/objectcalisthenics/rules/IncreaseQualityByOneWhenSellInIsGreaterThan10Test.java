package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;
import org.junit.Test;
import org.mockito.Mockito;

public class IncreaseQualityByOneWhenSellInIsGreaterThan10Test {

	@Test
	public void execute_withSellInGreaterThan10_ShouldCallIncreaseQuality() {

		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Mockito.when(sellIn.hasSellInGreaterThan10()).thenReturn(true);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByOneWhenSellInIsGreaterThan10 increaseQualityByOneWhenSellInIsGreaterThan10 = new IncreaseQualityByOneWhenSellInIsGreaterThan10(
				sellIn,quality);

		// When
		increaseQualityByOneWhenSellInIsGreaterThan10.execute();

		// Then
		Mockito.verify(quality).increaseQuality(1);
		Mockito.verifyNoMoreInteractions(quality);
	}

	@Test
	public void execute_withSellInLowerThanOrEquals10_Should_DoNothing() {

		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Mockito.when(sellIn.hasSellInGreaterThan10()).thenReturn(false);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByOneWhenSellInIsGreaterThan10 increaseQualityByOneWhenSellInIsGreaterThan10 = new IncreaseQualityByOneWhenSellInIsGreaterThan10(
				sellIn,quality);

		// When
		increaseQualityByOneWhenSellInIsGreaterThan10.execute();

		// Then
		Mockito.verifyNoMoreInteractions(quality);
	}

}
