package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.rules.DropQualityToZeroAfterTheConcert;
import org.junit.Test;
import org.mockito.Mockito;

public class DropQualityToZeroAfterTheConcertTest {

	@Test
	public void execute_withSellInLowerThanOrEqulas0_ShouldCall_DropQualityToZero() {

		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasSellInLowerThanOrEqulas0()).thenReturn(true);
		DropQualityToZeroAfterTheConcert dropQualityToZeroAfterTheConcert = new DropQualityToZeroAfterTheConcert(
				item);

		// When
		dropQualityToZeroAfterTheConcert.execute();

		// Then
		Mockito.verify(item).hasSellInLowerThanOrEqulas0();
		Mockito.verify(item).dropQualityToZero();
		Mockito.verifyNoMoreInteractions(item);
	}

	@Test
	public void execute_withSellInGreaterThan0_Should_DoNothing() {

		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasSellInLowerThanOrEqulas0()).thenReturn(false);
		DropQualityToZeroAfterTheConcert dropQualityToZeroAfterTheConcert = new DropQualityToZeroAfterTheConcert(
				item);

		// When
		dropQualityToZeroAfterTheConcert.execute();

		// Then
		Mockito.verify(item).hasSellInLowerThanOrEqulas0();
		Mockito.verifyNoMoreInteractions(item);
	}

}
