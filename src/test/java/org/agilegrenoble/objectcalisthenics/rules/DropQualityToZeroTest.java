package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.junit.Test;
import org.mockito.Mockito;

public class DropQualityToZeroTest {

	@Test
	public void execute_ShouldOnlyCall_DropQualityToZero() {

		// Given
		Quality quality = Mockito.mock(Quality.class);
		DropQualityToZero dropQualityToZeroAfterTheConcert = new DropQualityToZero(quality);

		// When
		dropQualityToZeroAfterTheConcert.execute();

		// Then
		Mockito.verify(quality).dropQualityToZero();
		Mockito.verifyNoMoreInteractions(quality);
	}
}
