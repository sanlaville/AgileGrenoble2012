package org.agilegrenoble.objectcalisthenics.rules;

import java.util.Random;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.agilegrenoble.objectcalisthenics.SellIn;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UpdateQualityDependingOnSellInTest {

	protected Random random = null;

	@Before
	public void setup() {
		random = new Random();
	}
	
	@Test
	public void execute_ShouldCall_() throws Exception {
		// Given
		IBusinessRule expectedBusinessRule = Mockito.mock(IBusinessRule.class);
		
		SellIn sellIn = Mockito.mock(SellIn.class);
		Quality quality = Mockito.mock(Quality.class);
		UpdateQualityDependingOnSellIn updateQualityDependingOnSellIn = Mockito.spy(new UpdateQualityDependingOnSellIn(sellIn, quality));
		Mockito.doReturn(expectedBusinessRule).when(updateQualityDependingOnSellIn).findBusinessRuleDependingOnSellIn();
		
		
		// When
		updateQualityDependingOnSellIn.execute();
		
		// Then
		Mockito.verify(expectedBusinessRule).execute();
		Mockito.verifyNoMoreInteractions(expectedBusinessRule);
	}
	
	@Test
	public void findBusinessRuleDependingOnSellIn_WhenSellInIsAfterTheConcert_ShouldReturn_DropQualityToZeroAfterTheConcert()
	{
		// Given
		SellIn expectedSellIn = Mockito.mock(SellIn.class);
		Mockito.when(expectedSellIn.value()).thenReturn(0);		
		Quality quality = Mockito.mock(Quality.class);
		UpdateQualityDependingOnSellIn updateQualityDependingOnSellIn = new UpdateQualityDependingOnSellIn(expectedSellIn, quality);
		
		// When
		IBusinessRule actualBusinessRule = updateQualityDependingOnSellIn.findBusinessRuleDependingOnSellIn();
		
		// Then
		Assertions.assertThat(actualBusinessRule).isInstanceOf(DropQualityToZero.class);
	}
	
	@Test
	public void findBusinessRuleDependingOnSellIn_WhenSellInIsBetween5and1_ShouldReturn_DropQualityToZeroAfterTheConcert()
	{
		// Given
		SellIn expectedSellIn = Mockito.mock(SellIn.class);
		int sellInValue = random.nextInt(5) + 1;
		Mockito.when(expectedSellIn.value()).thenReturn(sellInValue);		
		Quality quality = Mockito.mock(Quality.class);
		UpdateQualityDependingOnSellIn updateQualityDependingOnSellIn = new UpdateQualityDependingOnSellIn(expectedSellIn, quality);
		
		// When
		IBusinessRule actualBusinessRule = updateQualityDependingOnSellIn.findBusinessRuleDependingOnSellIn();
		
		// Then
		Assertions.assertThat(actualBusinessRule).isInstanceOf(IncreaseQualityByThree.class);
	}
	
	@Test
	public void findBusinessRuleDependingOnSellIn_WhenSellInIsBetween10and6_ShouldReturn_DropQualityToZeroAfterTheConcert()
	{
		// Given
		SellIn expectedSellIn = Mockito.mock(SellIn.class);
		int sellInValue = random.nextInt(5) + 6;
		Mockito.when(expectedSellIn.value()).thenReturn(sellInValue);		
		Quality quality = Mockito.mock(Quality.class);
		UpdateQualityDependingOnSellIn updateQualityDependingOnSellIn = new UpdateQualityDependingOnSellIn(expectedSellIn, quality);
		
		// When
		IBusinessRule actualBusinessRule = updateQualityDependingOnSellIn.findBusinessRuleDependingOnSellIn();
		
		// Then
		Assertions.assertThat(actualBusinessRule).isInstanceOf(IncreaseQualityByTwo.class);
	}
	
	@Test
	public void findBusinessRuleDependingOnSellIn_WhenSellInIsGreaterThan10_ShouldReturn_DropQualityToZeroAfterTheConcert()
	{
		// Given
		SellIn expectedSellIn = Mockito.mock(SellIn.class);
		int sellInValue = random.nextInt(30) + 11;
		Mockito.when(expectedSellIn.value()).thenReturn(sellInValue);		
		Quality quality = Mockito.mock(Quality.class);
		UpdateQualityDependingOnSellIn updateQualityDependingOnSellIn = new UpdateQualityDependingOnSellIn(expectedSellIn, quality);
		
		// When
		IBusinessRule actualBusinessRule = updateQualityDependingOnSellIn.findBusinessRuleDependingOnSellIn();
		
		// Then
		Assertions.assertThat(actualBusinessRule).isInstanceOf(IncreaseQualityByOne.class);
	}

}
