package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.junit.Test;
import org.mockito.Mockito;

public class IncreaseQualityByOneTest {

	@Test
	public void execute_ShouldOnlyCall_IncreaseQualityBy1() {

		// Given
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByOne increaseQualityByOne = new IncreaseQualityByOne(quality);

		// When
		increaseQualityByOne.execute();

		// Then
		Mockito.verify(quality).increaseQuality(1);
		Mockito.verifyNoMoreInteractions(quality);
	}
}
