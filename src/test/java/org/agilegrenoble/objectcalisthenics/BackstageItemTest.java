package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.assertions.QualityAssert;
import org.fest.assertions.Assertions;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BackstageItemTest extends ItemTest{


	@Before
	public void setup() {
		super.setup();
	}

	@Test
	public void backstage_passes_increases_by2_from_day_10_to_6_before_the_concert() {
		// Given
		Quality startQuality =  new Quality(20);
		int initialSellInValue = 10;
		SellIn sellIn = new SellIn(initialSellInValue);
		BackstageItem backstage = new BackstageItem(sellIn, startQuality);

		// When
		int startOfPeriod = initialSellInValue;
		int endOfPeriod = 5;
		List<Quality> actualBackstageQualityInThePeriod = backstageQualityInThePeriod(
				startOfPeriod, endOfPeriod, backstage);

		// Then
		int qualityPerDayIncrease = 2;
		Quality[] expectedBackstageQualityInThePeriod = inclusiveRange2(22,
				30, qualityPerDayIncrease);

		Assertions.assertThat(actualBackstageQualityInThePeriod).containsExactly((Object[])expectedBackstageQualityInThePeriod);
	}

	@Test
	public void backstage_passes_increases_by_3_from_day_5_to_0_before_the_concert() {
		// Given
		Quality startQuality =  new Quality(20);
		int initialSellInValue = 5;
		SellIn sellIn = new SellIn(initialSellInValue);
		BackstageItem backstage = new BackstageItem(sellIn, startQuality);

		// Then
		int startOfPeriod = initialSellInValue;
		int endOfPeriod = 0;
		List<Quality> actualBackstageQualityInThePeriod = backstageQualityInThePeriod(
				startOfPeriod, endOfPeriod, backstage);

		// When
		int qualityPerDayIncrease = 3;
		List<Quality> expectedBackstageQualityInThePeriod = inclusiveRange(23,
				35, qualityPerDayIncrease);
		Assertions.assertThat(actualBackstageQualityInThePeriod).isEqualTo(
				expectedBackstageQualityInThePeriod);
	}

	@Test
	public void backstage_passes_increases_by1_from_before_day_10_the_concert() {
		// Given
		Quality startQuality =  new Quality(20);
		int initialSellInValue = 15;
		SellIn sellIn = new SellIn(initialSellInValue);
		BackstageItem backstage = new BackstageItem(sellIn, startQuality);

		// Then
		int startOfPeriod = initialSellInValue;
		int endOfPeriod = 10;
		List<Quality> actualBackstageQualityInThePeriod = backstageQualityInThePeriod(
				startOfPeriod, endOfPeriod, backstage);

		// When
		int qualityPerDayIncrease = 1;
		List<Quality> expectedBackstageQualityInThePeriod = inclusiveRange(21,
				25, qualityPerDayIncrease);
		Assertions.assertThat(actualBackstageQualityInThePeriod).isEqualTo(
				expectedBackstageQualityInThePeriod);
	}

	@Test
	public void backstage_passes_is_0_after_the_concert() {
		// Given
		Quality startQuality =  new Quality(20);
		SellIn sellIn = new SellIn(0);
		BackstageItem backstage = new BackstageItem(sellIn, startQuality);

		// When
		backstage.updateQuality();

		// Then
		QualityAssert.assertThat(backstage.quality()).is(0);
	}

	private List<Quality> inclusiveRange(int min, int max, int step) {
		List<Quality> inclusiveRange = new LinkedList<Quality>();
		for (int i = min; i <= max; i = i + step)
			inclusiveRange.add(new Quality(i));

		return inclusiveRange;
	}
	private Quality[] inclusiveRange2(int min, int max, int step) {
		Quality[] inclusiveRange = new Quality[(max-min)/step + 1];
		int j=0;
		for (int i = min; i <= max; i = i + step)
			{
			inclusiveRange[j] = new Quality(i);
			j++;
			}

		return inclusiveRange;
	}

	private List<Quality> backstageQualityInThePeriod(int startOfPeriod,
			int endOfPeriod, Item backstage) {
		List<Quality> qualityInThePeriod = new LinkedList<Quality>();

		for (int day = startOfPeriod; day > endOfPeriod; --day) {
			backstage.updateQuality();
			qualityInThePeriod.add(backstage.quality());
		}

		return qualityInThePeriod;
	}

	@Override
	protected Item buildItem(Quality quality) {
		return buildItem(new SellIn(15), quality);
	}

	@Override
	protected Item buildItem(SellIn sellIn, Quality quality) {
		return  new BackstageItem(sellIn, quality);
	}
}
