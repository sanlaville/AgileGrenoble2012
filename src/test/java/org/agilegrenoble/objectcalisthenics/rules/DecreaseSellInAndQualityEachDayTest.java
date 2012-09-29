package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;
import org.junit.Test;
import org.mockito.Mockito;

public class DecreaseSellInAndQualityEachDayTest {

	@Test
	public void executeShouldCallDecreaseQualityAndDecreaseSellIn() {
		
		// Given
		SellIn sellIn = Mockito.mock(SellIn.class);
		Quality quality = Mockito.mock(Quality.class);
		DecreaseSellInAndQualityEachDay decreaseSellInAndQualityEachDay = new DecreaseSellInAndQualityEachDay(sellIn, quality);
		
		// When
		decreaseSellInAndQualityEachDay.execute();
		
		// Then
		Mockito.verify(quality).decreaseQuality(1);
		Mockito.verify(sellIn).decreaseSellIn(1);
		Mockito.verifyNoMoreInteractions(quality);
		Mockito.verifyNoMoreInteractions(sellIn);
	}

}
