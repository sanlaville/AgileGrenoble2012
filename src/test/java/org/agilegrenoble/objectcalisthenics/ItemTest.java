package org.agilegrenoble.objectcalisthenics;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Random;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ItemTest {

	private Random random = null;

	@Before
	public void setup() {
		random = new Random();
	}

	@Test
	public void quality_degrades_twice_as_fast_after_the_sell_date_has_passed() {
		// Given
		int startquality = 10;
		Item freshItem = buildRandomNormalItem(2, startquality);
		Item passedItem = buildRandomNormalItem(0, startquality);

		// When
		freshItem.updateQuality();
		int actualFreshItemQuality = startquality - freshItem.quality;
		passedItem.updateQuality();
		int actualPassedItemQuality = startquality - passedItem.quality;

		// Then
		assertThat(actualFreshItemQuality).isEqualTo(
				actualPassedItemQuality / 2);
	}

	@Test
	public void quality_is_never_negative() {
		// Given
		int quality = 0;
		Item item = buildRandomNormalItem(quality);

		// When
		repeatUpdateQuality(item, random.nextInt(10));

		// Then
		assertThat(item.quality).isGreaterThanOrEqualTo(0);
	}

	@Test
	public void quality_never_exceeds_50() {
		// Given
		int maxQuality = 50;
		Item item = buildRandomNormalItem(maxQuality);

		// When
		repeatUpdateQuality(item, random.nextInt(10));

		// Then
		assertThat(item.quality).isLessThanOrEqualTo(maxQuality);
	}

	@Test
	@Ignore
	// TODO not yet implemented
	public void conjured_degrade_in_quality_twice_as_fast_as_normal_items() {
		// Given
		int startQuality = 6;
		Item conjured = new Item("Conjured Mana Cake", 3, startQuality);
		Inn inn = new Inn(asList(conjured));

		// When
		inn.updateQuality();

		// Then
		assertThat(conjured.quality).isEqualTo(4);
	}

	@Test
	public void increaseQuality_ShouldIncreaseQualityByTheGivenValue() {
		// Given
		int startQuality = random.nextInt();
		Item item = new Item(null, 0, startQuality);

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
		Item item = new Item(null, 0, startQuality);

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
		int startSellIn = random.nextInt();
		Item item = new Item(null, startSellIn, 0);

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
		Item item = new Item(null, 0, startQuality);

		// When
		item.resetQualityToZero();
		int actualQuality = item.quality;

		// Then
		Assertions.assertThat(actualQuality).isEqualTo(0);
	}

	private Item buildRandomNormalItem(int sellIn, int quality) {
		Item item = null;

		int ran = random.nextInt(2);
		switch (ran) {
		case 0:
			item = new Item("+5 Dexterity Vest", sellIn, quality);
			break;
		case 1:
			item = new Item("Elixir of the Mongoose", sellIn, quality);
			break;
		}

		return item;
	}

	private Item buildRandomNormalItem(int quality) {
		Item item = null;

		int ran = random.nextInt(2);
		switch (ran) {
		case 0:
			item = new Item("+5 Dexterity Vest", 10, quality);
			break;
		case 1:
			item = new Item("Elixir of the Mongoose", 5, quality);
			break;
		}

		return item;
	}

	private void repeatUpdateQuality(Item item, int times) {
		for (int i = 0; i < times; i++) {
			item.updateQuality();
		}
	}
}
