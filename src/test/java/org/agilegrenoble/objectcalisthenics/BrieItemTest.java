package org.agilegrenoble.objectcalisthenics;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class BrieItemTest {

	private Random random = null;

	@Before
	public void setup() {
		random = new Random();
	}

	@Test
	public void quality_degrades_twice_as_fast_after_the_sell_date_has_passed() {
		// Given
		int startquality = 10;
		BrieItem brieFreshItem = new BrieItem(2, startquality);
		BrieItem briePassedItem = new BrieItem(0, startquality);

		// When
		brieFreshItem.updateQuality();
		int actualFreshItemQuality = startquality - brieFreshItem.quality;
		briePassedItem.updateQuality();
		int actualPassedItemQuality = startquality - briePassedItem.quality;

		// Then
		assertThat(actualFreshItemQuality).isEqualTo(
				actualPassedItemQuality / 2);
	}

	@Test
	public void quality_is_never_negative() {
		// Given
		int quality = 0;
		BrieItem brie = new BrieItem(2, quality);

		// When
		repeatUpdateQuality(brie, random.nextInt(10));

		// Then
		assertThat(brie.quality).isGreaterThanOrEqualTo(0);
	}

	@Test
	public void brie_quality_increases_with_time() {
		// Given
		int startQuality = 20;
		BrieItem brie = new BrieItem(10, startQuality);

		// When
		brie.updateQuality();

		// Then
		assertThat(brie.quality).isEqualTo(startQuality + 1);
	}

	@Test
	public void quality_never_exceeds_50() {
		// Given
		int maxQuality = 50;
		BrieItem brie = new BrieItem(2, maxQuality);

		// When
		repeatUpdateQuality(brie, random.nextInt(10));

		// Then
		assertThat(brie.quality).isLessThanOrEqualTo(maxQuality);
	}


	private void repeatUpdateQuality(Item item, int times) {
		for (int i = 0; i < times; i++) {
			item.updateQuality();
		}
	}
}
