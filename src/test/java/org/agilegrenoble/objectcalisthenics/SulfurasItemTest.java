package org.agilegrenoble.objectcalisthenics;

import static org.fest.assertions.Assertions.assertThat;

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
		int startQuality = 40;
		Item sulfuras = buildItem(0, startQuality);

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras.quality).isGreaterThanOrEqualTo(startQuality);
	}

	@Test
	public void sulfuras_never_has_to_be_sold() {
		// Given
		int startSellIn = 10;
		Item sulfuras = buildItem(startSellIn, 0);

		// When
		repeatUpdateQuality(sulfuras, random.nextInt(10));

		// Then
		assertThat(sulfuras.sellIn).isEqualTo(startSellIn);
	}

	@Override
	protected Item buildItem(int quality) {
		return buildItem(0, quality);
	}

	@Override
	protected Item buildItem(int sellIn, int quality) {
		return new SulfurasItem(sellIn, quality);
	}

}
