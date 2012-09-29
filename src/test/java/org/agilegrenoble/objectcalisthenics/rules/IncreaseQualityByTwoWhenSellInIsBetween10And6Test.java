package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;
import org.junit.Test;
import org.mockito.Mockito;

public class IncreaseQualityByTwoWhenSellInIsBetween10And6Test {

	@Test
	public void execute_withSellInBetween10And6_ShouldCall_IncreaseQuality() {

		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Mockito.when(sellIn.hasSellInBetween10And6()).thenReturn(true);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByTwoWhenSellInIsBetween10And6 increaseQualityByTwoWhenSellInIsBetween10And6 = new IncreaseQualityByTwoWhenSellInIsBetween10And6(
				sellIn, quality);

		// When
		increaseQualityByTwoWhenSellInIsBetween10And6.execute();

		// Then
		Mockito.verify(quality).increaseQuality(2);
		Mockito.verifyNoMoreInteractions(quality);
	}

	@Test
	public void execute_withSellInGreaterThan10_Should_DoNothingOnQuality() {

		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Mockito.when(sellIn.hasSellInBetween10And6()).thenReturn(false);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByTwoWhenSellInIsBetween10And6 increaseQualityByTwoWhenSellInIsBetween10And6 = new IncreaseQualityByTwoWhenSellInIsBetween10And6(
				sellIn, quality);

		// When
		increaseQualityByTwoWhenSellInIsBetween10And6.execute();

		// Then
		Mockito.verifyNoMoreInteractions(quality);
	}
	
	@Test
	public void execute_withSellInLowerThanOrEquals5_Should_DoNothing() {
		
		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Mockito.when(sellIn.hasSellInBetween10And6()).thenReturn(false);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByTwoWhenSellInIsBetween10And6 increaseQualityByTwoWhenSellInIsBetween10And6 = new IncreaseQualityByTwoWhenSellInIsBetween10And6(
				sellIn, quality);
		
		// When
		increaseQualityByTwoWhenSellInIsBetween10And6.execute();
		
		// Then
		Mockito.verifyNoMoreInteractions(quality);
	}
	
}
