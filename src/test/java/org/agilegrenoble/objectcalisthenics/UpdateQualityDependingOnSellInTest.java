package org.agilegrenoble.objectcalisthenics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class UpdateQualityDependingOnSellInTest {

	@Test
	@PrepareForTest( UpdateQualityDependingOnSellIn.class )
	public void execute_ShouldCall_() throws Exception {
		// Given
		Item expectedItem = Mockito.mock(Item.class);
		IncreaseQualityByOneWhenSellInIsGreaterThan10 increaseQualityByOneWhenSellInIsGreaterThan10 = Mockito.mock(IncreaseQualityByOneWhenSellInIsGreaterThan10.class);
		IncreaseQualityByTwoWhenSellInIsBetween10And6 increaseQualityByTwoWhenSellInIsBetween10And6 = Mockito.mock(IncreaseQualityByTwoWhenSellInIsBetween10And6.class);
		IncreaseQualityByThreeWhenSellInIsBetween5And1 increaseQualityByThreeWhenSellInIsBetween5And1 = Mockito.mock(IncreaseQualityByThreeWhenSellInIsBetween5And1.class);
		DropQualityToZeroAfterTheConcert dropQualityToZeroAfterTheConcert = Mockito.mock(DropQualityToZeroAfterTheConcert.class);
		
		PowerMockito.whenNew(IncreaseQualityByOneWhenSellInIsGreaterThan10.class).withArguments(expectedItem).thenReturn(increaseQualityByOneWhenSellInIsGreaterThan10);
		PowerMockito.whenNew(IncreaseQualityByTwoWhenSellInIsBetween10And6.class).withArguments(expectedItem).thenReturn(increaseQualityByTwoWhenSellInIsBetween10And6);
		PowerMockito.whenNew(IncreaseQualityByThreeWhenSellInIsBetween5And1.class).withArguments(expectedItem).thenReturn(increaseQualityByThreeWhenSellInIsBetween5And1);
		PowerMockito.whenNew(DropQualityToZeroAfterTheConcert.class).withArguments(expectedItem).thenReturn(dropQualityToZeroAfterTheConcert);

		UpdateQualityDependingOnSellIn updateQualityDependingOnSellIn = new UpdateQualityDependingOnSellIn(expectedItem);
		
		// When
		updateQualityDependingOnSellIn.execute();
		
		// Then
		PowerMockito.verifyNew(IncreaseQualityByOneWhenSellInIsGreaterThan10.class).withArguments(expectedItem);
		PowerMockito.verifyNew(IncreaseQualityByTwoWhenSellInIsBetween10And6.class).withArguments(expectedItem);
		PowerMockito.verifyNew(IncreaseQualityByThreeWhenSellInIsBetween5And1.class).withArguments(expectedItem);
		PowerMockito.verifyNew(DropQualityToZeroAfterTheConcert.class).withArguments(expectedItem);
		
		Mockito.verify(increaseQualityByOneWhenSellInIsGreaterThan10).execute();
		Mockito.verify(increaseQualityByTwoWhenSellInIsBetween10And6).execute();
		Mockito.verify(increaseQualityByThreeWhenSellInIsBetween5And1).execute();
		Mockito.verify(dropQualityToZeroAfterTheConcert).execute();
		
		Mockito.verifyNoMoreInteractions(increaseQualityByOneWhenSellInIsGreaterThan10);
		Mockito.verifyNoMoreInteractions(increaseQualityByTwoWhenSellInIsBetween10And6);
		Mockito.verifyNoMoreInteractions(increaseQualityByThreeWhenSellInIsBetween5And1);
		Mockito.verifyNoMoreInteractions(dropQualityToZeroAfterTheConcert);

		
	}

}
