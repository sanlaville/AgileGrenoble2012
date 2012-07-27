package org.agilegrenoble.objectcalisthenics;

import static org.fest.assertions.Assertions.assertThat;

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
		int startQuality = 20;
		int sellIn = 10;
		BackstageItem backstage = new BackstageItem(sellIn, startQuality);

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
		BackstageItem backstage = new BackstageItem(sellIn, startQuality);

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
		BackstageItem backstage = new BackstageItem(sellIn, startQuality);

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
		BackstageItem backstage = new BackstageItem(sellIn, startQuality);

		// When
		backstage.updateQuality();

		// Then
		assertThat(backstage.quality).isEqualTo(0);
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
			qualityInThePeriod.add(backstage.quality);
		}

		return qualityInThePeriod;
	}

	@Override
	protected Item buildItem(int quality) {
		return buildItem(15, quality);
	}

	@Override
	protected Item buildItem(int sellIn, int quality) {
		return  new BackstageItem(sellIn, quality);
	}
}
