package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.rules.DecreaseSellInAndQualityEachDay;
import org.junit.Test;
import org.mockito.Mockito;

public class DecreaseSellInAndQualityEachDayTest {

	@Test
	public void executeShouldCallDecreaseQualityAndDecreaseSellIn() {
		
		// Given
		Item item = Mockito.mock(Item.class);
		DecreaseSellInAndQualityEachDay decreaseSellInAndQualityEachDay = new DecreaseSellInAndQualityEachDay(item);
		
		// When
		decreaseSellInAndQualityEachDay.execute();
		
		// Then
		Mockito.verify(item).decreaseQuality(1);
		Mockito.verify(item).decreaseSellIn(1);
		Mockito.verifyNoMoreInteractions(item);
	}

}
