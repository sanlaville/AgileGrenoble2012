package org.agilegrenoble.objectcalisthenics.items;

import static java.util.Arrays.asList;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.agilegrenoble.objectcalisthenics.Inn;
import org.agilegrenoble.objectcalisthenics.ItemForge;
import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class NormalItemTest {

	private Random random = null;
	private ItemForge forge = new ItemForge();

	@Before
	public void setup() {
		random = new Random();
	}

	@Test
	public void quality_degrades_twice_as_fast_after_the_sell_date_has_passed() {
		// Given
		int startquality = 10;
        Item freshItem = itemThatDecays("freshItem", 2, startquality);
		Item passedItem = itemThatDecays("passedItem", 0, startquality);

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
		int daysUntilBestBeforeDate = 10;
        Item brie = anAgedBrie(startQuality, daysUntilBestBeforeDate);

		// When
		brie.updateQuality();

		// Then
		assertThat(brie.getQuality()).isEqualTo(startQuality + 1);
	}

	@Test
	public void quality_never_exceeds_50_or_is_80_in_the_case_of_sulfuras() {
		// Given
		int maxQuality = 50;
		Item item = buildRandomItem(maxQuality);

		// When
		repeatUpdateQuality(item, random.nextInt(10));

		// Then
		if (item instanceof Sulfuras) 
		    assertThat(item.getQuality()).isLessThanOrEqualTo(80);
		else 
		    assertThat(item.getQuality()).isLessThanOrEqualTo(maxQuality);
	}

    @Test
	public void sulfuras_never_decreases_in_quality() {
		// Given
		int startQuality = 40;
		Item sulfuras = new Sulfuras();

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras.getQuality()).isGreaterThanOrEqualTo(startQuality);
	}

	@Test
	public void sulfuras_never_has_to_be_sold() {
		// Given
		int startSellIn = 10;
		Item sulfuras = new Sulfuras(10);

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras.getDayCountDown()).isEqualTo(startSellIn);
	}

    @Test
	public void backstage_passes_increases_by2_from_day_10_to_6_before_the_concert() {
		// Given
		int startQuality = 20;
		int sellIn = 10;
		Item backstage = aBackstagePass(startQuality, sellIn);

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
		Item backstage = aBackstagePass(startQuality, sellIn);

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
		Item backstage = aBackstagePass(startQuality, sellIn);

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
		Item backstage = aBackstagePass(startQuality, sellIn);

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
		Item conjured = itemThatDecays("Conjured Mana Cake", 3, startQuality);
		Inn inn = new Inn(asList(conjured));

		// When
		inn.updateQuality();

		// Then
		assertThat(conjured.getQuality()).isEqualTo(4);
	}
	
	@Test
	public void increaseQuality_ShouldIncreaseQualityByTheGivenValue(){
		// Given
		int startQuality = random.nextInt(51);
		Item item = itemThatDecays(null, 0, startQuality);
		
		int value = random.nextInt();
		
		// When
		item.quality.increase(value);
		int actualQuality = item.getQuality();
		
		// Then
		int expectedQuality = startQuality + value;
		Assertions.assertThat(actualQuality).isEqualTo(expectedQuality);
	}
	
	@Test
	public void decreaseQuality_ShouldDecreaseQualityByTheGivenValue(){
		// Given
		int startQuality = random.nextInt(51);
		Item item = itemThatDecays(null, 0, startQuality);
		
		int value = random.nextInt();
		
		// When
		item.quality.decrease(value);
		int actualQuality = item.getQuality();
		
		// Then
		int expectedQuality = startQuality - value;
		Assertions.assertThat(actualQuality).isEqualTo(expectedQuality);
	}
	
	@Test
	public void decreaseSellIn_IsAlwaysByOne(){
		// Given
		int startSellIn = random.nextInt();
		Item item = itemThatDecays(null, startSellIn, 0);
		
		// When
		item.ageing.updateDaysBefore();
		int actualSelIn = item.getDayCountDown();
		
		// Then
		int expectedSellIn = startSellIn - 1;
		Assertions.assertThat(actualSelIn).isEqualTo(expectedSellIn);
	}
	
	@Test
	public void resetQualityToZero_ShouldResetQualityToZero()
	{
		// Given
		int startQuality = random.nextInt();
		Item item = itemThatDecays(null, 0, startQuality);
		
		// When
		item.quality.resetToZero();
		int actualQuality = item.getQuality();
		
		// Then
		Assertions.assertThat(actualQuality).isEqualTo(0);
	}

	private Item buildRandomItem(int quality) {
		Item item = null;

		int ran = random.nextInt(6);
		switch (ran) {
		case 0:
			item = itemThatDecays("+5 Dexterity Vest", 10, quality);
			break;
		case 1:
			item = anAgedBrie(2, 0);
			break;
		case 2:
			item = itemThatDecays("Elixir of the Mongoose", 5, quality);
			break;
		case 3:
			item = aSulfuras();
			break;
		case 4:
			item = aBackstagePass(15, quality);
			break;
		case 5:
			item = itemThatDecays("Conjured Mana Cake", 3, quality);
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

	private Item itemThatDecays(String itemName, int startAge, int startquality) {
        return forge.anItem_thatDecaysWithTime(itemName, startAge, startquality);
    }

    private Item aBackstagePass(int startQuality, int sellIn) {
        return forge.aBackstagePass_thatImprovesUntilTheConcertDate(sellIn, startQuality);
    }

    private Item anAgedBrie(int startQuality, int daysUntilBestBeforeDate) {
        return forge.anAgedBrie_thatImprovesWithTime(daysUntilBestBeforeDate, startQuality);
    }

    private Item aSulfuras() {
        return forge.aSulfuras_isAMagicItemThatNeverChanges();
    }

}
