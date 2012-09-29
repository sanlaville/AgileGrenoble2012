package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.assertions.QualityAssert;
import org.fest.assertions.Assertions;

import org.junit.Before;
import org.junit.Test;

public class SulfurasItemTest extends ItemTest {

	@Before
	public void setup() {
		super.setup();
	}

	@Test
	public void sulfuras_never_decreases_in_quality() {
		// Given
		Quality startQuality = new Quality(40);
		Item sulfuras = buildItem(0, startQuality);

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		QualityAssert.assertThat(sulfuras.quality()).isGreaterThanOrEqualTo(startQuality);
	}

	@Test
	public void sulfuras_never_has_to_be_sold() {
		// Given
		int startSellIn = 10;
		Item sulfuras = buildItem(startSellIn, new Quality(0));

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		Assertions.assertThat(sulfuras.sellIn).isEqualTo(startSellIn);
	}

	@Override
	protected Item buildItem(Quality quality) {
		return buildItem(0, quality);
	}

	@Override
	protected Item buildItem(int sellIn, Quality quality) {
		return new SulfurasItem(sellIn, quality);
	}

}
