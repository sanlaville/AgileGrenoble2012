package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.rules.IncreaseQualityByTwoWhenSellInIsBetween10And6;
import org.junit.Test;
import org.mockito.Mockito;

public class IncreaseQualityByTwoWhenSellInIsBetween10And6Test {

	@Test
	public void execute_withSellInBetween10And6_ShouldCall_IncreaseQuality() {

		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasSellInBetween10And6()).thenReturn(true);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByTwoWhenSellInIsBetween10And6 increaseQualityByTwoWhenSellInIsBetween10And6 = new IncreaseQualityByTwoWhenSellInIsBetween10And6(
				item, quality);

		// When
		increaseQualityByTwoWhenSellInIsBetween10And6.execute();

		// Then
		Mockito.verify(item).hasSellInBetween10And6();
		Mockito.verify(quality).increaseQuality(2);
		Mockito.verifyNoMoreInteractions(item);
	}

	@Test
	public void execute_withSellInGreaterThan10_Should_DoNothing() {

		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasSellInBetween10And6()).thenReturn(false);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByTwoWhenSellInIsBetween10And6 increaseQualityByTwoWhenSellInIsBetween10And6 = new IncreaseQualityByTwoWhenSellInIsBetween10And6(
				item, quality);

		// When
		increaseQualityByTwoWhenSellInIsBetween10And6.execute();

		// Then
		Mockito.verify(item).hasSellInBetween10And6();
		Mockito.verifyNoMoreInteractions(item);
	}
	
	@Test
	public void execute_withSellInLowerThanOrEquals5_Should_DoNothing() {
		
		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasSellInBetween10And6()).thenReturn(false);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByTwoWhenSellInIsBetween10And6 increaseQualityByTwoWhenSellInIsBetween10And6 = new IncreaseQualityByTwoWhenSellInIsBetween10And6(
				item, quality);
		
		// When
		increaseQualityByTwoWhenSellInIsBetween10And6.execute();
		
		// Then
		Mockito.verify(item).hasSellInBetween10And6();
		Mockito.verifyNoMoreInteractions(item);
	}
	
}
