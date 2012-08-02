package org.agilegrenoble.objectcalisthenics;

import org.junit.Test;
import org.mockito.Mockito;

public class IncreaseQualityByOneWhenSellInIsGreaterThan10Test {

	@Test
	public void execute_withSellInGreaterThan10_ShouldCallIncreaseQuality() {

		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasSellInGreaterThan10()).thenReturn(true);
		IncreaseQualityByOneWhenSellInIsGreaterThan10 increaseQualityByOneWhenSellInIsGreaterThan10 = new IncreaseQualityByOneWhenSellInIsGreaterThan10(
				item);

		// When
		increaseQualityByOneWhenSellInIsGreaterThan10.execute();

		// Then
		Mockito.verify(item).hasSellInGreaterThan10();
		Mockito.verify(item).increaseQuality(1);
		Mockito.verifyNoMoreInteractions(item);
	}

	@Test
	public void execute_withSellInLowerThanOrEquals10_Should_DoNothing() {

		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasSellInGreaterThan10()).thenReturn(false);
		IncreaseQualityByOneWhenSellInIsGreaterThan10 increaseQualityByOneWhenSellInIsGreaterThan10 = new IncreaseQualityByOneWhenSellInIsGreaterThan10(
				item);

		// When
		increaseQualityByOneWhenSellInIsGreaterThan10.execute();

		// Then
		Mockito.verify(item).hasSellInGreaterThan10();
		Mockito.verifyNoMoreInteractions(item);
	}

}
