package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.rules.OnceTheSellByDateHasPassedQualityDegradesTwice;
import org.junit.Test;
import org.mockito.Mockito;

public class OnceTheSellByDateHasPassedQualityDegradesTwiceTest {

	@Test
	public void execute_withItemWhoTheSellByDateHasPassed_ShouldCall_DecreaseQuality() {
		
		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasTheSellByDatePassed()).thenReturn(true);
		Quality quality = Mockito.mock(Quality.class);
		OnceTheSellByDateHasPassedQualityDegradesTwice onceTheSellByDateHasPassedQualityDegradesTwice = new OnceTheSellByDateHasPassedQualityDegradesTwice(item, quality);
		
		// When
		onceTheSellByDateHasPassedQualityDegradesTwice.execute();
		
		// Then
		Mockito.verify(item).hasTheSellByDatePassed();
		Mockito.verify(quality).decreaseQuality(1);
		Mockito.verifyNoMoreInteractions(item);
	}
	
	@Test
	public void execute_withItemWhoTheSellByDateHasNotPassed_Should_DoNothing() {
		
		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasTheSellByDatePassed()).thenReturn(false);
		Quality quality = Mockito.mock(Quality.class);
		OnceTheSellByDateHasPassedQualityDegradesTwice onceTheSellByDateHasPassedQualityDegradesTwice = new OnceTheSellByDateHasPassedQualityDegradesTwice(item, quality);
		
		// When
		onceTheSellByDateHasPassedQualityDegradesTwice.execute();
		
		// Then
		Mockito.verify(item).hasTheSellByDatePassed();
		Mockito.verifyNoMoreInteractions(item);
	}

}
