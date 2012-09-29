package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;
import org.junit.Test;
import org.mockito.Mockito;

public class DecreaseSellInAndIncreaseQualityEachDayTest {

	@Test
	public void execute_ShouldCall_DecreaseSellInAndIncreaseQuality() {
		
		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Quality quality = Mockito.mock(Quality.class);
		DecreaseSellInAndIncreaseQualityEachDay decreaseSellInAndIncreaseQualityEachDay = new DecreaseSellInAndIncreaseQualityEachDay(sellIn, quality);
		
		// When
		decreaseSellInAndIncreaseQualityEachDay.execute();
		
		// Then
		Mockito.verify(sellIn).decreaseSellIn(1);
		Mockito.verify(quality).increaseQuality(1);
		
		Mockito.verifyNoMoreInteractions(quality);
		Mockito.verifyNoMoreInteractions(sellIn);
	}

}
