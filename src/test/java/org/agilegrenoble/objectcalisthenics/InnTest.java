package org.agilegrenoble.objectcalisthenics;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class InnTest {

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
		Inn inn = new Inn(asList(freshItem, passedItem));

		// When
		inn.updateQuality();
		int actualFreshItemQuality = startquality - getQualityOf(freshItem);
		int actualPassedItemQuality = startquality - getQualityOf(passedItem);

		// Then
		assertThat(actualFreshItemQuality).isEqualTo(
				actualPassedItemQuality / 2);
	}


	@Test
	public void quality_is_never_negative() {
		// Given
		int quality = 0;
		ArrayList<Item> items = buildItems(quality);
		Inn inn = new Inn(items);

		// When
		repeatUpdateQuality(inn, random.nextInt(10));

		// Then
		for (Item item : items) {
			assertThat(getQualityOf(item)).isGreaterThanOrEqualTo(0);
		}
	}

	@Test
	public void brie_quality_increases_with_time() {
		// Given
		int startQuality = 20;
		Item brie = buildBrieItem(10, startQuality);
		Inn inn = new Inn(asList(brie));

		// When
		inn.updateQuality();

		// Then
		assertThat(getQualityOf(brie)).isEqualTo(startQuality + 1);
	}

	@Test
	public void quality_never_exceeds_50() {
		// Given
		int maxQuality = 50;
		ArrayList<Item> items = buildItems(maxQuality);
		Inn inn = new Inn(items);

		// When
		repeatUpdateQuality(inn, random.nextInt(10));

		// Then
		for (Item item : items) {
			assertThat(getQualityOf(item)).isLessThanOrEqualTo(maxQuality);
		}
	}

	@Test
	public void sulfuras_never_decreases_in_quality() {
		// Given
		int startQuality = 40;
		Item sulfuras = buildSulfurasItem(0, startQuality);
		Inn inn = new Inn(asList(sulfuras));

		// When
		repeatUpdateQuality(inn, random.nextInt(10));

		// Then
		assertThat(getQualityOf(sulfuras)).isGreaterThanOrEqualTo(startQuality);
	}

	@Test
	public void sulfuras_never_has_to_be_sold() {
		// Given
		int startSellIn = 10;
		Item sulfuras = buildSulfurasItem(startSellIn, 0);
		Inn inn = new Inn(asList(sulfuras));

		// When
		repeatUpdateQuality(inn, random.nextInt(10));

		// Then
		assertThat(getSellInOf(sulfuras)).isEqualTo(startSellIn);
	}


	@Test
	public void backstage_passes_increases_by2_from_day_10_to_6_before_the_concert() {
		// Given
		int startQuality = 20;
		int sellIn = 10;
		Item backstage = buildBackstageItem(sellIn, startQuality);
		Inn inn = new Inn(asList(backstage));

		// When
		int startOfPeriod = sellIn;
		int endOfPeriod = 5;
		List<Integer> actualBackstageQualityInThePeriod = backstageQualityInThePeriod(
				startOfPeriod, endOfPeriod, inn, backstage);

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
		Item backstage = buildBackstageItem(sellIn, startQuality);
		Inn inn = new Inn(asList(backstage));

		// Then
		int startOfPeriod = sellIn;
		int endOfPeriod = 0;
		List<Integer> actualBackstageQualityInThePeriod = backstageQualityInThePeriod(
				startOfPeriod, endOfPeriod, inn, backstage);

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
		Item backstage = buildBackstageItem(sellIn, startQuality);
		Inn inn = new Inn(asList(backstage));

		// Then
		int startOfPeriod = sellIn;
		int endOfPeriod = 10;
		List<Integer> actualBackstageQualityInThePeriod = backstageQualityInThePeriod(
				startOfPeriod, endOfPeriod, inn, backstage);

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
		Item backstage = buildBackstageItem(sellIn, startQuality);
		Inn inn = new Inn(asList(backstage));

		// When
		inn.updateQuality();

		// Then
		assertThat(getQualityOf(backstage)).isEqualTo(0);
	}

	private void repeatUpdateQuality(Inn inn, int times) {
		for (int i = 0; i < times; i++) {
			inn.updateQuality();
		}
	}

	private List<Integer> inclusiveRange(int min, int max, int step) {
		List<Integer> inclusiveRange = new LinkedList<Integer>();
		for (int i = min; i <= max; i = i + step)
			inclusiveRange.add(i);

		return inclusiveRange;
	}

	private List<Integer> backstageQualityInThePeriod(int startOfPeriod,
			int endOfPeriod, Inn inn, Item backstage) {
		List<Integer> qualityInThePeriod = new LinkedList<Integer>();

		for (int day = startOfPeriod; day > endOfPeriod; --day) {
			inn.updateQuality();
			qualityInThePeriod.add(getQualityOf(backstage));
		}

		return qualityInThePeriod;
	}

	/* ================================================================ */
	/* ===               FACTORIES FOR BUILDING ITEMS               === */
	/* ================================================================ */

	private Item buildRandomNormalItem(int sellIn, int quality) {
		Item item = null;

		int ran = random.nextInt(2);
		switch (ran) {
		case 0:
			item = buildDexterityVestItem(sellIn, quality);
			break;
		case 1:
			item = buildMongooseElixirItem(sellIn, quality);
			break;
		}

		return item;
	}

	private ArrayList<Item> buildItems(int quality) {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(buildDexterityVestItem(10, quality));
		items.add(buildBrieItem(2, quality));
		items.add(buildMongooseElixirItem(5, quality));
		items.add(buildSulfurasItem(0, quality));
		items.add(buildBackstageItem(15,quality));
		return items;
	}

	private Item buildBrieItem(int sellIn, int startQuality) {
		return new Item("Aged Brie", sellIn, startQuality);
	}
	
	private Item buildDexterityVestItem(int sellIn, int quality) {
		return  new Item("+5 Dexterity Vest", sellIn, quality);
	}
	
	private Item buildMongooseElixirItem(int sellIn, int quality) {
		return new Item("Elixir of the Mongoose", sellIn, quality);
	}
	
	private Item buildSulfurasItem(int sellIn, int quality) {
		return new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
	}
	
	private Item buildBackstageItem(int sellIn, int quality) {
		return new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
	}
	
	/* ================================================================ */
	/* ===                     GET ITEM QUALITY                     === */
	/* ================================================================ */
	private int getQualityOf(Item item) {
		return item.getQuality();
	}
	

	private int getSellInOf(Item item) {
		return item.getSellIn();
	}
}
