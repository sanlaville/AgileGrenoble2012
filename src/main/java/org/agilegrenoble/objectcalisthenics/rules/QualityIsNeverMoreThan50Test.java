package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Item;
import org.agilegrenoble.objectcalisthenics.rules.QualityIsNeverMoreThan50;
import org.junit.Test;
import org.mockito.Mockito;

public class QualityIsNeverMoreThan50Test {

	@Test
	public void execute_whitQualityGreaterThan50_ShouldCall_KeepQualityTo50() {
		
		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasQualityGreaterThan50()).thenReturn(true);
		QualityIsNeverMoreThan50 qualityIsNeverMoreThan50 = new QualityIsNeverMoreThan50(item);
		
		// When
		qualityIsNeverMoreThan50.execute();
		
		// Then
		Mockito.verify(item).hasQualityGreaterThan50();
		Mockito.verify(item).keepQualityTo50();
		Mockito.verifyNoMoreInteractions(item);
	}
	
	@Test
	public void execute_whitQualityLowerThan50_Should_DoNothing() {
		
		// Given
		Item item = Mockito.mock(Item.class);
		Mockito.when(item.hasQualityGreaterThan50()).thenReturn(false);
		QualityIsNeverMoreThan50 qualityIsNeverMoreThan50 = new QualityIsNeverMoreThan50(item);
		
		// When
		qualityIsNeverMoreThan50.execute();
		
		// Then
		Mockito.verify(item).hasQualityGreaterThan50();
		Mockito.verifyNoMoreInteractions(item);
	}

}
