package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;
import org.junit.Test;
import org.mockito.Mockito;

public class DropQualityToZeroAfterTheConcertTest {

	@Test
	public void execute_withSellInLowerThanOrEqulas0_ShouldCall_DropQualityToZero() {

		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Mockito.when(sellIn.hasSellInLowerThanOrEquals0()).thenReturn(true);
		Quality quality = Mockito.mock(Quality.class);
		DropQualityToZeroAfterTheConcert dropQualityToZeroAfterTheConcert = new DropQualityToZeroAfterTheConcert(
				sellIn, quality);

		// When
		dropQualityToZeroAfterTheConcert.execute();

		// Then
		Mockito.verify(quality).dropQualityToZero();
		Mockito.verifyNoMoreInteractions(quality);
	}

	@Test
	public void execute_withSellInGreaterThan0_Should_DoNothing() {

		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Mockito.when(sellIn.hasSellInLowerThanOrEquals0()).thenReturn(false);
		Quality quality = Mockito.mock(Quality.class);
		DropQualityToZeroAfterTheConcert dropQualityToZeroAfterTheConcert = new DropQualityToZeroAfterTheConcert(
				sellIn,quality);

		// When
		dropQualityToZeroAfterTheConcert.execute();

		// Then
		Mockito.verifyNoMoreInteractions(quality);
	}

}
