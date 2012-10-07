package org.agilegrenoble.objectcalisthenics.items;

import static java.util.Arrays.asList;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.agilegrenoble.objectcalisthenics.Inn;
import org.agilegrenoble.objectcalisthenics.ItemForge;
import org.agilegrenoble.objectcalisthenics.quality.Between0and50Quality;
import org.agilegrenoble.objectcalisthenics.quality.Quality;
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
		Quality freshItemQuality = quality(10);
		Quality passedItemQuality = quality(10);
        Item freshItem = itemThatDecays("freshItem", 2, freshItemQuality);
		Item passedItem = itemThatDecays("passedItem", 0, passedItemQuality);

		// When
		freshItem.updateQuality();
		passedItem.updateQuality();

		
		// Then
		assertThat(freshItemQuality).isEqualTo(quality(9));
		assertThat(passedItemQuality).isEqualTo(quality(8));
	}

	private Quality quality(int amount) {
        return new Between0and50Quality(amount);
    }

	@Test
	public void brie_quality_increases_with_time() {
		// Given
		int startQuality = 20;
		int daysUntilBestBeforeDate = 10;
        Quality quality = quality(startQuality);
		
        Item brie = anAgedBrie(quality, daysUntilBestBeforeDate);

		// When
		brie.updateQuality();

		// Then
		assertThat(quality).isEqualTo(quality(startQuality + 1));
	}

    @Test
	public void sulfuras_never_decreases_in_quality() {
		// Given
		Item sulfuras = new Sulfuras();

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras).isEqualsToByComparingFields(new Sulfuras());
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
		Quality quality = quality(startQuality);

		int sellIn = 10;
		BackStagePass backstage = aBackstagePass(sellIn, quality);

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
		Quality quality = quality(startQuality);

		int sellIn = 5;
		BackStagePass backstage = aBackstagePass(sellIn, quality);

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
        Quality quality = quality(startQuality);
		int sellIn = 15;
        BackStagePass backstage = aBackstagePass(sellIn, quality);

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
        Quality quality = quality(startQuality);
		int sellIn = 0;
        Item backstage = aBackstagePass(sellIn, quality);

		// When
		backstage.updateQuality();

		// Then
		assertThat(quality).isEqualTo(quality(0));
	}

	@Test
	@Ignore
	// TODO not yet implemented
	public void conjured_degrade_in_quality_twice_as_fast_as_normal_items() {
		// Given
		Quality quality = quality(6);
		Item conjured = itemThatDecays("Conjured Mana Cake", 3, quality);
		Inn inn = new Inn(asList(conjured));

		// When
		inn.updateQuality();

		// Then
		assertThat(quality).isEqualTo(quality(4));
	}
	
	@Test
	public void increaseQuality_ShouldIncreaseQualityByTheGivenValue(){
		// Given
        Quality quality = quality(6);
		Item item = itemThatDecays(null, 0, quality);
		
		int value = random.nextInt();
		
		// When
		item.quality.increase(value);
		
		// Then
		Quality expectedQuality = quality(6 + value);
		Assertions.assertThat(quality).isEqualTo(expectedQuality);
	}
	
	@Test
	public void decreaseQuality_ShouldDecreaseQualityByTheGivenValue(){
		// Given
		int startQuality = random.nextInt(51);
		Quality quality = quality(startQuality);
		Item item = itemThatDecays(null, 0, quality);
		
		int value = random.nextInt();
		
		// When
		item.quality.decrease(value);
		
		// Then
		int expectedQuality = startQuality - value;
		Assertions.assertThat(quality).isEqualTo(quality(expectedQuality));
	}
	
	@Test
	public void decreaseSellIn_IsAlwaysByOne(){
		// Given
		int startSellIn = random.nextInt();
		Item item = itemThatDecays(null, startSellIn, quality(0));
		
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
		Quality quality = quality(startQuality);

		Item item = itemThatDecays(null, 0, quality);
		
		// When
		item.quality.resetToZero();
		
		// Then
		Assertions.assertThat(quality).isEqualTo(quality(0));
	}

	private Item buildRandomItem(Quality quality) {
		Item item = null;

		int ran = random.nextInt(6);
		switch (ran) {
		case 0:
			item = itemThatDecays("+5 Dexterity Vest", 10, quality);
			break;
		case 1:
			item = anAgedBrie(quality(2), 0);
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
			int endOfPeriod, BackStagePass backstage) {
		List<Integer> qualityInThePeriod = new LinkedList<Integer>();

		for (int day = startOfPeriod; day > endOfPeriod; --day) {
			backstage.updateQuality();
			qualityInThePeriod.add(backstage.getQuality());
		}

		return qualityInThePeriod;
	}

	private Item itemThatDecays(String itemName, int startAge, Quality startquality) {
        return forge.anItem_thatDecaysWithTime(itemName, startAge, startquality);
    }

    private BackStagePass aBackstagePass(int sellIn, Quality startQuality) {
        return forge.aBackstagePass_thatImprovesUntilTheConcertDate(sellIn, startQuality);
    }

    private Item anAgedBrie(Quality quality, int daysUntilBestBeforeDate) {
        return forge.anAgedBrie_thatImprovesWithTime(daysUntilBestBeforeDate, quality);
    }

    private Item aSulfuras() {
        return forge.aSulfuras_isAMagicItemThatNeverChanges();
    }

}
