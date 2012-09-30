package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.junit.Test;
import org.mockito.Mockito;

public class IncreaseQualityByTwoTest {

	@Test
	public void execute_ShouldOnlyCall_IncreaseQualityBy2() {

		// Given
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByTwo increaseQualityByTwo = new IncreaseQualityByTwo(quality);

		// When
		increaseQualityByTwo.execute();

		// Then
		Mockito.verify(quality).increaseQuality(2);
		Mockito.verifyNoMoreInteractions(quality);
	}
}
