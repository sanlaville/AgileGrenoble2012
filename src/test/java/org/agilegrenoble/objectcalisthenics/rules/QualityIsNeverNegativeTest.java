package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.rules.QualityIsNeverNegative;
import org.junit.Test;
import org.mockito.Mockito;

public class QualityIsNeverNegativeTest {

	@Test
	public void execute_whitNegativeQuality_ShouldCall_ResetQualityToZero() {
		
		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasNegativeQuality()).thenReturn(true);
		QualityIsNeverNegative qualityIsNeverNegative = new QualityIsNeverNegative(item);
		
		// When
		qualityIsNeverNegative.execute();
		
		// Then
		Mockito.verify(item).hasNegativeQuality();
		Mockito.verify(item).dropQualityToZero();
		Mockito.verifyNoMoreInteractions(item);
	}
	
	@Test
	public void execute_whitPositiveQuality_Should_DoNothing() {
		
		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasNegativeQuality()).thenReturn(false);
		QualityIsNeverNegative qualityIsNeverNegative = new QualityIsNeverNegative(item);
		
		// When
		qualityIsNeverNegative.execute();
		
		// Then
		Mockito.verify(item).hasNegativeQuality();
		Mockito.verifyNoMoreInteractions(item);
	}

}
