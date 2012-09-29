package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.rules.IncreaseQualityByOneWhenSellInIsGreaterThan10;
import org.junit.Test;
import org.mockito.Mockito;

public class IncreaseQualityByOneWhenSellInIsGreaterThan10Test {

	@Test
	public void execute_withSellInGreaterThan10_ShouldCallIncreaseQuality() {

		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasSellInGreaterThan10()).thenReturn(true);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByOneWhenSellInIsGreaterThan10 increaseQualityByOneWhenSellInIsGreaterThan10 = new IncreaseQualityByOneWhenSellInIsGreaterThan10(
				item,quality);

		// When
		increaseQualityByOneWhenSellInIsGreaterThan10.execute();

		// Then
		Mockito.verify(item).hasSellInGreaterThan10();
		Mockito.verify(quality).increaseQuality(1);
		Mockito.verifyNoMoreInteractions(item);
	}

	@Test
	public void execute_withSellInLowerThanOrEquals10_Should_DoNothing() {

		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasSellInGreaterThan10()).thenReturn(false);
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByOneWhenSellInIsGreaterThan10 increaseQualityByOneWhenSellInIsGreaterThan10 = new IncreaseQualityByOneWhenSellInIsGreaterThan10(
				item,quality);

		// When
		increaseQualityByOneWhenSellInIsGreaterThan10.execute();

		// Then
		Mockito.verify(item).hasSellInGreaterThan10();
		Mockito.verifyNoMoreInteractions(item);
	}

}
