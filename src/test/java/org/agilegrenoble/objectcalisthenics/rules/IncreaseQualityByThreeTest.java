package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.junit.Test;
import org.mockito.Mockito;

public class IncreaseQualityByThreeTest {

	@Test
	public void execute_ShouldOnlyCall_IncreaseQualityBy3() {

		// Given
		Quality quality = Mockito.mock(Quality.class);
		IncreaseQualityByThree increaseQualityByThree = new IncreaseQualityByThree(quality);

		// When
		increaseQualityByThree.execute();

		// Then
		Mockito.verify(quality).increaseQuality(3);
		Mockito.verifyNoMoreInteractions(quality);
	}
}
