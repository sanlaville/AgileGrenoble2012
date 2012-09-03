package org.agilegrenoble.objectcalisthenics;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.agilegrenoble.objectcalisthenics.quality.ImprovingQuality;
import org.agilegrenoble.objectcalisthenics.quality.DegradingQuality;
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
		Item freshItem = new Item("freshItem", new SellIn(2), new DegradingQuality(startquality));
		Item passedItem = new Item("passedItem", new SellIn(0), new DegradingQuality(startquality));

		// When
		freshItem.updateQuality();
		int actualFreshItemQuality = startquality - freshItem.quality.getQuality();
		passedItem.updateQuality();
		int actualPassedItemQuality = startquality - passedItem.quality.getQuality();

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
		assertThat(item.quality.getQuality()).isGreaterThanOrEqualTo(0);
	}

	@Test
	public void brie_quality_increases_with_time() {
		// Given
		int startQuality = 20;
		Item brie = new Item("Aged Brie", new SellIn(10), new ImprovingQuality(startQuality));

		// When
		brie.updateQuality();

		// Then
		assertThat(brie.quality.getQuality()).isEqualTo(startQuality + 1);
	}

	@Test
	public void quality_never_exceeds_50() {
		// Given
		int maxQuality = 50;
		Item item = buildRandomItem(maxQuality);

		// When
		repeatUpdateQuality(item, random.nextInt(10));

		// Then
		assertThat(item.quality.getQuality()).isLessThanOrEqualTo(maxQuality);
	}

	@Test
	public void sulfuras_never_decreases_in_quality() {
		// Given
		int startQuality = 40;
		Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", new SellIn(0), new DegradingQuality(startQuality));

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras.quality.getQuality()).isGreaterThanOrEqualTo(startQuality);
	}

	@Test
	public void sulfuras_never_has_to_be_sold() {
		// Given
		int startSellIn = 10;
		Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", new SellIn(startSellIn), new DegradingQuality(0));

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras.sellIn.getSellIn()).isEqualTo(startSellIn);
	}

	@Test
	public void backstage_passes_increases_by2_from_day_10_to_6_before_the_concert() {
		// Given
		int startQuality = 20;
		int sellIn = 10;
		Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert",
				new SellIn(sellIn), new DegradingQuality(startQuality));

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
				new SellIn(sellIn), new DegradingQuality(startQuality));

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
				new SellIn(sellIn), new DegradingQuality(startQuality));

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
				new SellIn(sellIn), new DegradingQuality(startQuality));

		// When
		backstage.updateQuality();

		// Then
		assertThat(backstage.quality.getQuality()).isEqualTo(0);
	}

	@Test
	@Ignore
	// TODO not yet implemented
	public void conjured_degrade_in_quality_twice_as_fast_as_normal_items() {
		// Given
		int startQuality = 6;
		Item conjured = new Item("Conjured Mana Cake", new SellIn(3), new DegradingQuality(startQuality));
		Inn inn = new Inn(asList(conjured));

		// When
		inn.updateQuality();

		// Then
		assertThat(conjured.quality.getQuality()).isEqualTo(4);
	}
	
	@Test
	public void increaseQuality_ShouldIncreaseQualityByTheGivenValue(){
		// Given
		int startQuality = random.nextInt(51);
		Item item = new Item(null, new SellIn(0), new DegradingQuality(startQuality));
		
		int value = random.nextInt();
		
		// When
		item.quality.increase(value);
		int actualQuality = item.quality.getQuality();
		
		// Then
		int expectedQuality = startQuality + value;
		Assertions.assertThat(actualQuality).isEqualTo(expectedQuality);
	}
	
	@Test
	public void decreaseQuality_ShouldDecreaseQualityByTheGivenValue(){
		// Given
		int startQuality = random.nextInt(51);
		Item item = new Item(null, new SellIn(0), new DegradingQuality(startQuality));
		
		int value = random.nextInt();
		
		// When
		item.quality.decrease(value);
		int actualQuality = item.quality.getQuality();
		
		// Then
		int expectedQuality = startQuality - value;
		Assertions.assertThat(actualQuality).isEqualTo(expectedQuality);
	}
	
	@Test
	public void decreaseSellIn_IsAlwaysByOne(){
		// Given
		int startSellIn = random.nextInt();
		Item item = new Item(null, new SellIn(startSellIn), new DegradingQuality(0));
		
		// When
		item.sellIn.decreaseSellIn();
		int actualSelIn = item.sellIn.getSellIn();
		
		// Then
		int expectedSellIn = startSellIn - 1;
		Assertions.assertThat(actualSelIn).isEqualTo(expectedSellIn);
	}
	
	@Test
	public void resetQualityToZero_ShouldResetQualityToZero()
	{
		// Given
		int startQuality = random.nextInt();
		Item item = new Item(null, new SellIn(0), new DegradingQuality(startQuality));
		
		// When
		item.quality.resetToZero();
		int actualQuality = item.quality.getQuality();
		
		// Then
		Assertions.assertThat(actualQuality).isEqualTo(0);
	}

	private Item buildRandomItem(int quality) {
		Item item = null;

		int ran = random.nextInt(6);
		switch (ran) {
		case 0:
			item = new Item("+5 Dexterity Vest", new SellIn(10), new DegradingQuality(quality));
			break;
		case 1:
			item = new Item("Aged Brie", new SellIn(2), new DegradingQuality(quality));
			break;
		case 2:
			item = new Item("Elixir of the Mongoose", new SellIn(5), new DegradingQuality(quality));
			break;
		case 3:
			item = new Item("Sulfuras, Hand of Ragnaros", new SellIn(0), new DegradingQuality(quality));
			break;
		case 4:
			item = new Item("Backstage passes to a TAFKAL80ETC concert", new SellIn(15),
					new DegradingQuality(quality));
			break;
		case 5:
			item = new Item("Conjured Mana Cake", new SellIn(3), new DegradingQuality(quality));
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
			qualityInThePeriod.add(backstage.quality.getQuality());
		}

		return qualityInThePeriod;
	}
}
