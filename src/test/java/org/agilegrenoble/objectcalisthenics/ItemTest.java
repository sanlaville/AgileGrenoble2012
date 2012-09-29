package org.agilegrenoble.objectcalisthenics;


import java.util.Random;

import org.agilegrenoble.objectcalisthenics.assertions.QualityAssert;
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
	public void quality_cannot_be_modify() {
		// Given
		int expectedQualityValue = 0;
		Quality quality = new Quality(expectedQualityValue);
		Item item = buildItem(quality);

		// When
		Quality actualQuality = item.quality();
		actualQuality.increaseQuality(5);

		// Then
		QualityAssert.assertThat(item.quality()).is(expectedQualityValue);
	}

	@Test
	public void quality_is_never_negative() {
		// Given
		Quality quality = new Quality(0);
		Item item = buildItem(quality);

		// When
		repeatUpdateQuality(item, random.nextInt(10));

		// Then
		QualityAssert.assertThat(item.quality()).isGreaterThanOrEqualTo(0);
	}



	@Test
	public void quality_never_exceeds_50() {
		// Given
		Quality maxQuality = new Quality(50);
		Item item = buildItem(maxQuality);

		// When
		repeatUpdateQuality(item, random.nextInt(10));

		// Then
		QualityAssert.assertThat(item.quality()).isLessThanOrEqualTo(maxQuality.value());
	}

	@Test
	public void decreaseSellIn_ShouldDecreaseSellInByTheGivenValue() {
		// Given
		Quality startQuality = new Quality(0);
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
	public void hasTheSellByDatePassed_WithSellInLowerThanOrEquals0_ShouldReturn_True() {
		// Given
		Quality startQuality = new Quality(random.nextInt());
		int startSellIn = random.nextInt(5) - 4;
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasTehSellByDatePassed = item.hasTheSellByDatePassed();

		// Then
		Assertions.assertThat(actualHasTehSellByDatePassed).isTrue();
	}

	@Test
	public void hasTheSellByDatePassed_WithSellInGreaterThan0_ShouldReturn_False() {
		// Given
		Quality startQuality = new Quality(random.nextInt());
		int startSellIn = random.nextInt(5) + 1;
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasTehSellByDatePassed = item.hasTheSellByDatePassed();

		// Then
		Assertions.assertThat(actualHasTehSellByDatePassed).isFalse();
	}

	@Test
	public void hasSellInGreaterThan10_WithSellInGreaterThan10_ShouldReturn_True() {
		// Given
		Quality startQuality = new Quality(random.nextInt());
		int startSellIn = random.nextInt(30) + 11;
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasSellInGreaterThan10 = item.hasSellInGreaterThan10();

		// Then
		Assertions.assertThat(actualHasSellInGreaterThan10).isTrue();
	}

	@Test
	public void hasSellInGreaterThan10_WithSellInLowerThanOrEquals10_ShouldReturn_False() {
		// Given
		Quality startQuality = new Quality(random.nextInt());
		int startSellIn = random.nextInt(11);
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasSellInGreaterThan10 = item.hasSellInGreaterThan10();

		// Then
		Assertions.assertThat(actualHasSellInGreaterThan10).isFalse();
	}

	@Test
	public void hasSellInBetween10And6_WithSellInGreaterThan10_ShouldReturn_False() {
		// Given
		Quality startQuality = new Quality(random.nextInt());
		int startSellIn = random.nextInt(30) + 11;
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasSellInGreaterThan10 = item.hasSellInBetween10And6();

		// Then
		Assertions.assertThat(actualHasSellInGreaterThan10).isFalse();
	}

	@Test
	public void hasSellInBetween10And6_WithSellInBetween10And6_ShouldReturn_True() {
		// Given
		Quality startQuality = new Quality(random.nextInt());
		int startSellIn = random.nextInt(5) + 6;
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasSellInGreaterThan10 = item.hasSellInBetween10And6();

		// Then
		Assertions.assertThat(actualHasSellInGreaterThan10).isTrue();
	}

	@Test
	public void hasSellInBetween10And6_WithSellInLowerThanOrEquals5_ShouldReturn_False() {
		// Given
		Quality startQuality = new Quality(random.nextInt());
		int startSellIn = random.nextInt(6);
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasSellInGreaterThan10 = item.hasSellInBetween10And6();

		// Then
		Assertions.assertThat(actualHasSellInGreaterThan10).isFalse();
	}

	@Test
	public void hasSellInBetween5And1_WithSellInGreaterThan5_ShouldReturn_False() {
		// Given
		Quality startQuality = new Quality(random.nextInt());
		int startSellIn = random.nextInt(30) + 6;
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasSellInBetween5And1 = item.hasSellInBetween5And1();

		// Then
		Assertions.assertThat(actualHasSellInBetween5And1).isFalse();
	}

	@Test
	public void hasSellInBetween5And1_WithSellInBetween5And1_ShouldReturn_True() {
		// Given
		Quality startQuality = new Quality(random.nextInt());
		int startSellIn = random.nextInt(5) + 1;
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasSellInBetween5And1 = item.hasSellInBetween5And1();

		// Then
		Assertions.assertThat(actualHasSellInBetween5And1).isTrue();
	}

	@Test
	public void hasSellInBetween5And1_WithSellInEquals0_ShouldReturn_False() {
		// Given
		Quality startQuality = new Quality(random.nextInt());
		int startSellIn = 0;
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasSellInBetween5And1 = item.hasSellInBetween5And1();

		// Then
		Assertions.assertThat(actualHasSellInBetween5And1).isFalse();
	}

	@Test
	public void hasSellInLowerThanOrEqulas0_WithSellInLowerThanOrEqulas0_ShouldReturn_True() {
		// Given
		Quality startQuality = new Quality(random.nextInt());
		int startSellIn = 0 - random.nextInt(30);
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasSellInLowerThanOrEqulas0 = item
				.hasSellInLowerThanOrEqulas0();

		// Then
		Assertions.assertThat(actualHasSellInLowerThanOrEqulas0).isTrue();
	}

	@Test
	public void hasSellInLowerThanOrEqulas0_WithSellInGreaterThan0_ShouldReturn_False() {
		// Given
		Quality startQuality = new Quality(random.nextInt());
		int startSellIn = random.nextInt(30) + 1;
		Item item = buildItem(startSellIn, startQuality);

		// When
		boolean actualHasSellInLowerThanOrEqulas0 = item
				.hasSellInLowerThanOrEqulas0();

		// Then
		Assertions.assertThat(actualHasSellInLowerThanOrEqulas0).isFalse();
	}

	protected abstract Item buildItem(Quality quality);

	protected abstract Item buildItem(int sellIn, Quality quality);

	protected void repeatUpdateQuality(Item item, int times) {
		for (int i = 0; i < times; i++) {
			item.updateQuality();
		}
	}
}
