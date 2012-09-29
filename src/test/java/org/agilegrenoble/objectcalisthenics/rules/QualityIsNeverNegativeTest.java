package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.junit.Test;
import org.mockito.Mockito;

public class QualityIsNeverNegativeTest {

	@Test
	public void execute_whitNegativeQuality_ShouldCall_ResetQualityToZero() {
		
		// Given
		Quality quality = Mockito.mock(Quality.class);
		Mockito.when(quality.hasNegativeQuality()).thenReturn(true);
		QualityIsNeverNegative qualityIsNeverNegative = new QualityIsNeverNegative(quality);
		
		// When
		qualityIsNeverNegative.execute();
		
		// Then
		Mockito.verify(quality).hasNegativeQuality();
		Mockito.verify(quality).dropQualityToZero();
		Mockito.verifyNoMoreInteractions(quality);
	}
	
	@Test
	public void execute_whitPositiveQuality_Should_DoNothing() {
		
		// Given
		Quality quality = Mockito.mock(Quality.class);
		Mockito.when(quality.hasNegativeQuality()).thenReturn(false);
		QualityIsNeverNegative qualityIsNeverNegative = new QualityIsNeverNegative(quality);
		
		// When
		qualityIsNeverNegative.execute();
		
		// Then
		Mockito.verify(quality).hasNegativeQuality();
		Mockito.verifyNoMoreInteractions(quality);
	}

}
