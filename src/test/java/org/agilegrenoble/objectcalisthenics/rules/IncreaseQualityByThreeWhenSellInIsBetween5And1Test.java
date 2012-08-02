package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.rules.IncreaseQualityByThreeWhenSellInIsBetween5And1;
import org.junit.Test;
import org.mockito.Mockito;

public class IncreaseQualityByThreeWhenSellInIsBetween5And1Test {

	@Test
	public void execute_withSellInBetween5And1_ShouldCall_IncreaseQuality() {

		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasSellInBetween5And1()).thenReturn(true);
		IncreaseQualityByThreeWhenSellInIsBetween5And1 increaseQualityByThreeWhenSellInIsBetween5And1 = new IncreaseQualityByThreeWhenSellInIsBetween5And1(
				item);

		// When
		increaseQualityByThreeWhenSellInIsBetween5And1.execute();

		// Then
		Mockito.verify(item).hasSellInBetween5And1();
		Mockito.verify(item).increaseQuality(3);
		Mockito.verifyNoMoreInteractions(item);
	}

	@Test
	public void execute_withSellInGreaterThan5_Should_DoNothing() {

		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasSellInBetween5And1()).thenReturn(false);
		IncreaseQualityByThreeWhenSellInIsBetween5And1 increaseQualityByThreeWhenSellInIsBetween5And1 = new IncreaseQualityByThreeWhenSellInIsBetween5And1(
				item);

		// When
		increaseQualityByThreeWhenSellInIsBetween5And1.execute();

		// Then
		Mockito.verify(item).hasSellInBetween5And1();
		Mockito.verifyNoMoreInteractions(item);
	}
	
	@Test
	public void execute_withSellInEquals0_Should_DoNothing() {
		
		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasSellInBetween5And1()).thenReturn(false);
		IncreaseQualityByThreeWhenSellInIsBetween5And1 increaseQualityByThreeWhenSellInIsBetween5And1 = new IncreaseQualityByThreeWhenSellInIsBetween5And1(
				item);
		
		// When
		increaseQualityByThreeWhenSellInIsBetween5And1.execute();
		
		// Then
		Mockito.verify(item).hasSellInBetween5And1();
		Mockito.verifyNoMoreInteractions(item);
	}
	
}
