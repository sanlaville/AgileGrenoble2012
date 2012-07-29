package org.agilegrenoble.objectcalisthenics;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Random;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

public abstract class ItemTest {

	protected Random random = null;

	@Before
	public void setup() {
		random = new Random();
	}

	@Test
	public void quality_is_never_negative() {
		// Given
		int quality = 0;
		Item item = buildItem(quality);

		// When
		repeatUpdateQuality(item, random.nextInt(10));

		// Then
		assertThat(item.quality).isGreaterThanOrEqualTo(0);
	}

	@Test
	public void quality_never_exceeds_50() {
		// Given
		int maxQuality = 50;
		Item item = buildItem(maxQuality);

		// When
		repeatUpdateQuality(item, random.nextInt(10));

		// Then
		assertThat(item.quality).isLessThanOrEqualTo(maxQuality);
	}

	@Test
	public void increaseQuality_ShouldIncreaseQualityByTheGivenValue() {
		// Given
		int startQuality = random.nextInt();
		int startSellIn = 0;
		Item item = buildItem(startSellIn, startQuality);

		int value = random.nextInt();

		// When
		item.increaseQuality(value);
		int actualQuality = item.quality;

		// Then
		int expectedQuality = startQuality + value;
		Assertions.assertThat(actualQuality).isEqualTo(expectedQuality);
	}

	@Test
	public void decreaseQuality_ShouldDecreaseQualityByTheGivenValue() {
		// Given
		int startQuality = random.nextInt();
		int startSellIn = 0;
		Item item = buildItem(startSellIn, startQuality);

		int value = random.nextInt();

		// When
		item.decreaseQuality(value);
		int actualQuality = item.quality;

		// Then
		int expectedQuality = startQuality - value;
		Assertions.assertThat(actualQuality).isEqualTo(expectedQuality);
	}

	@Test
	public void decreaseSellIn_ShouldDecreaseSellInByTheGivenValue() {
		// Given
		int startQuality = 0;
		int startSellIn = random.nextInt();
		Item item = buildItem(startSellIn, startQuality);

		int value = random.nextInt();

		// When
		item.decreaseSellIn(value);
		int actualSelIn = item.sellIn;

		// Then
		int expectedSellIn = startSellIn - value;
		Assertions.assertThat(actualSelIn).isEqualTo(expectedSellIn);
	}

	@Test
	public void resetQualityToZero_ShouldResetQualityToZero() {
		// Given
		int startQuality = random.nextInt();
		int startSellIn = 0;
		Item item = buildItem(startSellIn, startQuality);

		// When
		item.resetQualityToZero();
		int actualQuality = item.quality;

		// Then
		Assertions.assertThat(actualQuality).isEqualTo(0);
	}

	@Test
	public void hasTheSellByDatePassed_WithSellInLowerThanOrEquals0_ShouldReturn_True() {
		// Given
		int startQuality = random.nextInt();
		int startSellIn = random.nextInt(5)-4;
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasTehSellByDatePassed = item.hasTheSellByDatePassed();

		// Then
		Assertions.assertThat(actualHasTehSellByDatePassed).isTrue();
	}
	
	@Test
	public void hasTheSellByDatePassed_WithSellInGreaterThan0_ShouldReturn_False() {
		// Given
		int startQuality = random.nextInt();
		int startSellIn = random.nextInt(5)+1;
		Item item = buildItem(startSellIn, startQuality);
		
		// When
		boolean actualHasTehSellByDatePassed = item.hasTheSellByDatePassed();
		
		// Then
		Assertions.assertThat(actualHasTehSellByDatePassed).isFalse();
	}
	
	@Test
	public void hasNegativeQuality_WithNegativeQuality_ShouldReturn_True() {
		// Given
		int startQuality = random.nextInt(5) - 5;
		Item item = buildItem(startQuality);
		
		// When
		boolean actualHasNegativeQuality = item.hasNegativeQuality();
		
		// Then
		Assertions.assertThat(actualHasNegativeQuality).isTrue();
	}
	
	@Test
	public void hasNegativeQuality_WithPositiveQuality_ShouldReturn_False() {
		// Given
		int startQuality = random.nextInt(50);
		Item item = buildItem(startQuality);
		
		// When
		boolean actualHasNegativeQuality = item.hasNegativeQuality();
		
		// Then
		Assertions.assertThat(actualHasNegativeQuality).isFalse();
	}

	protected abstract Item buildItem(int quality);

	protected abstract Item buildItem(int sellIn, int quality);

	protected void repeatUpdateQuality(Item item, int times) {
		for (int i = 0; i < times; i++) {
			item.updateQuality();
		}
	}
}
