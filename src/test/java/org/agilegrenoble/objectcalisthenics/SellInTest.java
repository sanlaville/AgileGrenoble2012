package org.agilegrenoble.objectcalisthenics;

import java.util.Random;

import org.agilegrenoble.objectcalisthenics.assertions.SellInAssert;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;


public class SellInTest {

	protected Random random = null;

	@Before
	public void setup() {
		random = new Random();
	}
	
	@Test
	public void decreaseSellIn_ShouldDecreaseSellInByTheGivenValue() {
		// Given
		int initialValue = random.nextInt();
		SellIn sellIn = new SellIn(initialValue);

		int value = random.nextInt();

		// When
		sellIn.decreaseSellIn(value);

		// Then
		int expectedValue = initialValue - value;
		SellInAssert.assertThat(sellIn).is(expectedValue);
	}

	@Test
	public void hasTheSellByDatePassed_WithSellInLowerThanOrEquals0_ShouldReturn_True() {
		// Given
		int initialValue = random.nextInt(5) - 4;
		SellIn sellIn = new SellIn(initialValue);

		// When
		boolean actualHasTehSellByDatePassed = sellIn.hasTheSellByDatePassed();

		// Then
		Assertions.assertThat(actualHasTehSellByDatePassed).isTrue();
	}
	
	@Test
	public void hasTheSellByDatePassed_WithSellInGreaterThan0_ShouldReturn_False() {
		// Given
		int initialValue = random.nextInt(5) + 1;
		SellIn sellIn = new SellIn(initialValue);
		
		// When
		boolean actualHasTheSellByDatePassed = sellIn.hasTheSellByDatePassed();
		
		// Then
		Assertions.assertThat(actualHasTheSellByDatePassed).isFalse();
	}
}
