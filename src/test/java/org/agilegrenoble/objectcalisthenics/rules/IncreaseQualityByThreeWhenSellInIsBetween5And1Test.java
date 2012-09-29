package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;
import org.junit.Test;
import org.mockito.Mockito;

public class IncreaseQualityByThreeWhenSellInIsBetween5And1Test {

	@Test
	public void execute_withSellInBetween5And1_ShouldCall_IncreaseQuality() {

		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Mockito.when(sellIn.hasSellInBetween5And1()).thenReturn(true);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByThreeWhenSellInIsBetween5And1 increaseQualityByThreeWhenSellInIsBetween5And1 = new IncreaseQualityByThreeWhenSellInIsBetween5And1(
				sellIn,quality);

		// When
		increaseQualityByThreeWhenSellInIsBetween5And1.execute();

		// Then
		Mockito.verify(quality).increaseQuality(3);
		Mockito.verifyNoMoreInteractions(quality);
	}

	@Test
	public void execute_withSellInGreaterThan5_Should_DoNothingOnQuality() {

		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Mockito.when(sellIn.hasSellInBetween5And1()).thenReturn(false);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByThreeWhenSellInIsBetween5And1 increaseQualityByThreeWhenSellInIsBetween5And1 = new IncreaseQualityByThreeWhenSellInIsBetween5And1(
				sellIn, quality);

		// When
		increaseQualityByThreeWhenSellInIsBetween5And1.execute();

		// Then
		Mockito.verifyNoMoreInteractions(quality);
	}
	
	@Test
	public void execute_withSellInEquals0_Should_DoNothingOnQuality() {
		
		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Mockito.when(sellIn.hasSellInBetween5And1()).thenReturn(false);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByThreeWhenSellInIsBetween5And1 increaseQualityByThreeWhenSellInIsBetween5And1 = new IncreaseQualityByThreeWhenSellInIsBetween5And1(
				sellIn, quality);
		
		// When
		increaseQualityByThreeWhenSellInIsBetween5And1.execute();
		
		// Then
		Mockito.verifyNoMoreInteractions(quality);
	}
	
}
