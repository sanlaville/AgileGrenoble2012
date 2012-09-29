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
	
	@Test
	public void hasSellInGreaterThan10_WithSellInGreaterThan10_ShouldReturn_True() {
		// Given
		int initialValue = random.nextInt(30) + 11;
		SellIn sellIn = new SellIn(initialValue);
		
		// When
		boolean actualHasSellInGreaterThan10 = sellIn.hasSellInGreaterThan10();
		
		// Then
		Assertions.assertThat(actualHasSellInGreaterThan10).isTrue();
	}
	
	@Test
	public void hasSellInGreaterThan10_WithSellInLowerThanOrEquals10_ShouldReturn_False() {
		// Given
		int initialValue = random.nextInt(11);
		SellIn sellIn = new SellIn(initialValue);
		
		// When
		boolean actualHasSellInGreaterThan10 = sellIn.hasSellInGreaterThan10();
		
		// Then
		Assertions.assertThat(actualHasSellInGreaterThan10).isFalse();
	}
	
	@Test
	public void hasSellInBetween10And6_WithSellInGreaterThan10_ShouldReturn_False() {
		// Given
		int initialValue = random.nextInt(30) + 11;
		SellIn sellIn = new SellIn(initialValue);
		
		// When
		boolean actualHasSellInGreaterThan10 = sellIn.hasSellInBetween10And6();
		
		// Then
		Assertions.assertThat(actualHasSellInGreaterThan10).isFalse();
	}
	
	@Test
	public void hasSellInBetween10And6_WithSellInBetween10And6_ShouldReturn_True() {
		// Given
		int initialValue = random.nextInt(5) + 6;
		SellIn sellIn = new SellIn(initialValue);
		
		// When
		boolean actualHasSellInGreaterThan10 = sellIn.hasSellInBetween10And6();
		
		// Then
		Assertions.assertThat(actualHasSellInGreaterThan10).isTrue();
	}
	
	@Test
	public void hasSellInBetween10And6_WithSellInLowerThanOrEquals5_ShouldReturn_False() {
		// Given
		int initialValue = random.nextInt(6);
		SellIn sellIn = new SellIn(initialValue);
		
		// When
		boolean actualHasSellInGreaterThan10 = sellIn.hasSellInBetween10And6();
		
		// Then
		Assertions.assertThat(actualHasSellInGreaterThan10).isFalse();
	}
	
	@Test
	public void hasSellInBetween5And1_WithSellInGreaterThan5_ShouldReturn_False() {
		// Given
		int initialValue = random.nextInt(30) + 6;
		SellIn sellIn = new SellIn(initialValue);
		
		// When
		boolean actualHasSellInBetween5And1 = sellIn.hasSellInBetween5And1();
		
		// Then
		Assertions.assertThat(actualHasSellInBetween5And1).isFalse();
	}
	
	@Test
	public void hasSellInBetween5And1_WithSellInBetween5And1_ShouldReturn_True() {
		// Given
		int initialValue = random.nextInt(5) + 1;
		SellIn sellIn = new SellIn(initialValue);
		
		// When
		boolean actualHasSellInBetween5And1 = sellIn.hasSellInBetween5And1();
		
		// Then
		Assertions.assertThat(actualHasSellInBetween5And1).isTrue();
	}
	
	@Test
	public void hasSellInBetween5And1_WithSellInEquals0_ShouldReturn_False() {
		// Given
		int initialValue = 0;
		SellIn sellIn = new SellIn(initialValue);
		
		// When
		boolean actualHasSellInBetween5And1 = sellIn.hasSellInBetween5And1();
		
		// Then
		Assertions.assertThat(actualHasSellInBetween5And1).isFalse();
	}
	
	@Test
	public void hasSellInLowerThanOrEqulas0_WithSellInLowerThanOrEqulas0_ShouldReturn_True() {
		// Given
		int initialValue =  0 - random.nextInt(30);
		SellIn sellIn = new SellIn(initialValue);
		
		// When
		boolean actualHasSellInLowerThanOrEqulas0 = sellIn.hasSellInLowerThanOrEquals0();
		
		// Then
		Assertions.assertThat(actualHasSellInLowerThanOrEqulas0).isTrue();
	}
	
	@Test
	public void hasSellInLowerThanOrEqulas0_WithSellInGreaterThan0_ShouldReturn_False() {
		// Given
		int initialValue = random.nextInt(30) + 1;
		SellIn sellIn = new SellIn(initialValue);
		
		// When
		boolean actualHasSellInLowerThanOrEqulas0 = sellIn.hasSellInLowerThanOrEquals0();
		
		// Then
		Assertions.assertThat(actualHasSellInLowerThanOrEqulas0).isFalse();
	}
}
