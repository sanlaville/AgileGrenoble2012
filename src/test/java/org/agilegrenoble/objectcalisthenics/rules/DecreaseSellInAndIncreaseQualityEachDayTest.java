package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.rules.DecreaseSellInAndIncreaseQualityEachDay;
import org.junit.Test;
import org.mockito.Mockito;

public class DecreaseSellInAndIncreaseQualityEachDayTest {

	@Test
	public void execute_ShouldCall_DecreaseSellInAndIncreaseQuality() {
		
		// Given
		Item item = Mockito.mock(Item.class);
		DecreaseSellInAndIncreaseQualityEachDay decreaseSellInAndIncreaseQualityEachDay = new DecreaseSellInAndIncreaseQualityEachDay(item);
		
		// When
		decreaseSellInAndIncreaseQualityEachDay.execute();
		
		// Then
		Mockito.verify(item).decreaseSellIn(1);
		Mockito.verify(item).increaseQuality(1);
		Mockito.verifyNoMoreInteractions(item);
	}

}
