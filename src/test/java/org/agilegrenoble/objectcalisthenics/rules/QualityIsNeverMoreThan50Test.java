package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.junit.Test;
import org.mockito.Mockito;

public class QualityIsNeverMoreThan50Test {

	@Test
	public void execute_whitQualityGreaterThan50_ShouldCall_KeepQualityTo50() {
		
		// Given
		Quality quality = Mockito.mock(Quality.class);
		Mockito.when(quality.hasQualityGreaterThan50()).thenReturn(true);
		QualityIsNeverMoreThan50 qualityIsNeverMoreThan50 = new QualityIsNeverMoreThan50(quality);
		
		// When
		qualityIsNeverMoreThan50.execute();
		
		// Then
		Mockito.verify(quality).hasQualityGreaterThan50();
		Mockito.verify(quality).keepQualityTo50();
		Mockito.verifyNoMoreInteractions(quality);
	}
	
	@Test
	public void execute_whitQualityLowerThan50_Should_DoNothing() {
		
		// Given
		Quality quality = Mockito.mock(Quality.class);
		Mockito.when(quality.hasQualityGreaterThan50()).thenReturn(false);
		QualityIsNeverMoreThan50 qualityIsNeverMoreThan50 = new QualityIsNeverMoreThan50(quality);
		
		// When
		qualityIsNeverMoreThan50.execute();
		
		// Then
		Mockito.verify(quality).hasQualityGreaterThan50();
		Mockito.verifyNoMoreInteractions(quality);
	}

}
