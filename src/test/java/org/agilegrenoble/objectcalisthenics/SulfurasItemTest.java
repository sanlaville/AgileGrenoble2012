package org.agilegrenoble.objectcalisthenics;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SulfurasItemTest {

	private Random random = null;

	@Before
	public void setup() {
		random = new Random();
	}

	@Test
	public void quality_is_never_negative() {
		// Given
		int quality = 0;
		SulfurasItem sulfuras = new SulfurasItem(0, quality);

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras.quality).isGreaterThanOrEqualTo(0);
	}

	@Test
	public void quality_never_exceeds_50() {
		// Given
		int maxQuality = 50;
		SulfurasItem sulfuras = new SulfurasItem(0, maxQuality);

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras.quality).isLessThanOrEqualTo(maxQuality);
	}

	@Test
	public void sulfuras_never_decreases_in_quality() {
		// Given
		int startQuality = 40;
		SulfurasItem sulfuras = new SulfurasItem(0, startQuality);

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras.quality).isGreaterThanOrEqualTo(startQuality);
	}

	@Test
	public void sulfuras_never_has_to_be_sold() {
		// Given
		int startSellIn = 10;
		SulfurasItem sulfuras = new SulfurasItem(startSellIn, 0);

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras.sellIn).isEqualTo(startSellIn);
	}



	private void repeatUpdateQuality(Item item, int times) {
		for (int i = 0; i < times; i++) {
			item.updateQuality();
		}
	}
}
