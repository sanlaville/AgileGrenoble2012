package org.agilegrenoble.objectcalisthenics;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
	public void quality_degrades_twice_as_fast_for_normal_items_after_the_sell_date_has_passed() {
		// Given
		int startquality = 10;
		Item freshItem = buildRandomNormalItem(2, startquality);
		Item passedItem = buildRandomNormalItem(0, startquality);

		// When
		freshItem.updateQuality();
		int actualFreshItemQuality = startquality - freshItem.getQuality();
		passedItem.updateQuality();
		int actualPassedItemQuality = startquality - passedItem.getQuality();

		// Then
		assertThat(actualFreshItemQuality).isEqualTo(
				actualPassedItemQuality / 2);
	}

	@Test
	public void quality_is_never_negative() {
		// Given
		int quality = 0;
		Item item = buildRandomItem(quality);

		// When
		repeatUpdateQuality(item, random.nextInt(10));

		// Then
		assertThat(item.getQuality()).isGreaterThanOrEqualTo(0);
	}

	@Test
	public void brie_quality_increases_with_time() {
		// Given
		int startQuality = 20;
		Item brie = new Item("Aged Brie", 10, startQuality);

		// When
		brie.updateQuality();

		// Then
		assertThat(brie.getQuality()).isEqualTo(startQuality + 1);
	}

	@Test
	public void quality_never_exceeds_50() {
		// Given
		int maxQuality = 50;
		Item item = buildRandomItem(maxQuality);

		// When
		repeatUpdateQuality(item, random.nextInt(10));

		// Then
		assertThat(item.getQuality()).isLessThanOrEqualTo(maxQuality);
	}

	@Test
	public void sulfuras_never_decreases_in_quality() {
		// Given
		int startQuality = 40;
		Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, startQuality);

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras.getQuality()).isGreaterThanOrEqualTo(startQuality);
	}

	@Test
	public void sulfuras_never_has_to_be_sold() {
		// Given
		int startSellIn = 10;
		Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", startSellIn, 0);

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras.getSellIn()).isEqualTo(startSellIn);
	}

	@Test
	public void backstage_passes_increases_by2_from_day_10_to_6_before_the_concert() {
		// Given
		int startQuality = 20;
		int sellIn = 10;
		Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert",
				sellIn, startQuality);

		// When
		int startOfPeriod = sellIn;
		int endOfPeriod = 5;
		List<Integer> actualBackstageQualityInThePeriod = backstageQualityInThePeriod(
				startOfPeriod, endOfPeriod, backstage);

		// Then
		int qualityPerDayIncrease = 2;
		List<Integer> expectedBackstageQualityInThePeriod = inclusiveRange(22,
				30, qualityPerDayIncrease);
		assertThat(actualBackstageQualityInThePeriod).isEqualTo(
				expectedBackstageQualityInThePeriod);
	}

	@Test
	public void backstage_passes_increases_by_3_from_day_5_to_0_before_the_concert() {
		// Given
		int startQuality = 20;
		int sellIn = 5;
		Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert",
				sellIn, startQuality);

		// Then
		int startOfPeriod = sellIn;
		int endOfPeriod = 0;
		List<Integer> actualBackstageQualityInThePeriod = backstageQualityInThePeriod(
				startOfPeriod, endOfPeriod, backstage);

		// When
		int qualityPerDayIncrease = 3;
		List<Integer> expectedBackstageQualityInThePeriod = inclusiveRange(23,
				35, qualityPerDayIncrease);
		assertThat(actualBackstageQualityInThePeriod).isEqualTo(
				expectedBackstageQualityInThePeriod);
	}

	@Test
	public void backstage_passes_increases_by1_from_before_day_10_the_concert() {
		// Given
		int startQuality = 20;
		int sellIn = 15;
		Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert",
				sellIn, startQuality);

		// Then
		int startOfPeriod = sellIn;
		int endOfPeriod = 10;
		List<Integer> actualBackstageQualityInThePeriod = backstageQualityInThePeriod(
				startOfPeriod, endOfPeriod, backstage);

		// When
		int qualityPerDayIncrease = 1;
		List<Integer> expectedBackstageQualityInThePeriod = inclusiveRange(21,
				25, qualityPerDayIncrease);
		assertThat(actualBackstageQualityInThePeriod).isEqualTo(
				expectedBackstageQualityInThePeriod);
	}

	@Test
	public void backstage_passes_is_0_after_the_concert() {
		// Given
		int startQuality = 20;
		int sellIn = 0;
		Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert",
				sellIn, startQuality);

		// When
		backstage.updateQuality();

		// Then
		assertThat(backstage.getQuality()).isEqualTo(0);
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
		assertThat(conjured.getQuality()).isEqualTo(4);
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

	private Item buildRandomItem(int quality) {
		Item item = null;

		int ran = random.nextInt(5);
		switch (ran) {
		case 0:
			item = new Item("+5 Dexterity Vest", 10, quality);
			break;
		case 1:
			item = new Item("Elixir of the Mongoose", 5, quality);
			break;
		case 2:
			item = new Item("Aged Brie", 2, quality);
			break;
		case 3:
			item = new Item("Sulfuras, Hand of Ragnaros", 0, quality);
			break;
		case 4:
			item = new Item("Backstage passes to a TAFKAL80ETC concert", 15,
					quality);
			break;
		}

		return item;
	}

	private void repeatUpdateQuality(Item item, int times) {
		for (int i = 0; i < times; i++) {
			item.updateQuality();
		}
	}

	private List<Integer> inclusiveRange(int min, int max, int step) {
		List<Integer> inclusiveRange = new LinkedList<Integer>();
		for (int i = min; i <= max; i = i + step)
			inclusiveRange.add(i);

		return inclusiveRange;
	}

	private List<Integer> backstageQualityInThePeriod(int startOfPeriod,
			int endOfPeriod, Item backstage) {
		List<Integer> qualityInThePeriod = new LinkedList<Integer>();

		for (int day = startOfPeriod; day > endOfPeriod; --day) {
			backstage.updateQuality();
			qualityInThePeriod.add(backstage.getQuality());
		}

		return qualityInThePeriod;
	}
}
