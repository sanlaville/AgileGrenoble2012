package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.rules.DecreaseSellInAndQualityEachDay;
import org.junit.Test;
import org.mockito.Mockito;

public class DecreaseSellInAndQualityEachDayTest {

	@Test
	public void executeShouldCallDecreaseQualityAndDecreaseSellIn() {
		
		// Given
		Item item = Mockito.mock(Item.class);
		Quality quality = Mockito.mock(Quality.class);
		DecreaseSellInAndQualityEachDay decreaseSellInAndQualityEachDay = new DecreaseSellInAndQualityEachDay(item, quality);
		
		// When
		decreaseSellInAndQualityEachDay.execute();
		
		// Then
		Mockito.verify(quality).decreaseQuality(1);
		Mockito.verify(item).decreaseSellIn(1);
		Mockito.verifyNoMoreInteractions(item);
	}

}
