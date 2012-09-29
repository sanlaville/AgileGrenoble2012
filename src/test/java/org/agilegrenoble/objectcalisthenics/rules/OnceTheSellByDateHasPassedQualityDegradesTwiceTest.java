package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;
import org.junit.Test;
import org.mockito.Mockito;

public class OnceTheSellByDateHasPassedQualityDegradesTwiceTest {

	@Test
	public void execute_withItemWhoTheSellByDateHasPassed_ShouldCall_DecreaseQuality() {
		
		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Mockito.when(sellIn.hasTheSellByDatePassed()).thenReturn(true);
		Quality quality = Mockito.mock(Quality.class);
		OnceTheSellByDateHasPassedQualityDegradesTwice onceTheSellByDateHasPassedQualityDegradesTwice = new OnceTheSellByDateHasPassedQualityDegradesTwice(sellIn, quality);
		
		// When
		onceTheSellByDateHasPassedQualityDegradesTwice.execute();
		
		// Then
		Mockito.verify(quality).decreaseQuality(1);
		Mockito.verifyNoMoreInteractions(quality);
	}
	
	@Test
	public void execute_withItemWhoTheSellByDateHasNotPassed_Should_DoNothingOnQuality() {
		
		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Mockito.when(sellIn.hasTheSellByDatePassed()).thenReturn(false);
		Quality quality = Mockito.mock(Quality.class);
		OnceTheSellByDateHasPassedQualityDegradesTwice onceTheSellByDateHasPassedQualityDegradesTwice = new OnceTheSellByDateHasPassedQualityDegradesTwice(sellIn, quality);
		
		// When
		onceTheSellByDateHasPassedQualityDegradesTwice.execute();
		
		// Then
		Mockito.verifyNoMoreInteractions(quality);
	}

}
