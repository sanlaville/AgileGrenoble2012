package org.agilegrenoble.objectcalisthenics;


import java.util.Random;

import org.agilegrenoble.objectcalisthenics.assertions.QualityAssert;
import org.junit.Before;
import org.junit.Test;

public abstract class ItemTest {

	protected Random random = null;

	@Before
	public void setup() {
		random = new Random();
	}

	@Test
	public void quality_cannot_be_modify() {
		// Given
		int expectedQualityValue = 0;
		Quality quality = new Quality(expectedQualityValue);
		Item item = buildItem(quality);

		// When
		Quality actualQuality = item.quality();
		actualQuality.increaseQuality(5);

		// Then
		QualityAssert.assertThat(item.quality()).is(expectedQualityValue);
	}

	@Test
	public void quality_is_never_negative() {
		// Given
		Quality quality = new Quality(0);
		Item item = buildItem(quality);

		// When
		repeatUpdateQuality(item, random.nextInt(10));

		// Then
		QualityAssert.assertThat(item.quality()).isGreaterThanOrEqualTo(0);
	}



	@Test
	public void quality_never_exceeds_50() {
		// Given
		Quality maxQuality = new Quality(50);
		Item item = buildItem(maxQuality);

		// When
		repeatUpdateQuality(item, random.nextInt(10));

		// Then
		QualityAssert.assertThat(item.quality()).isLessThanOrEqualTo(maxQuality.value());
	}

	protected abstract Item buildItem(Quality quality);

	protected abstract Item buildItem(SellIn sellIn, Quality quality);

	protected void repeatUpdateQuality(Item item, int times) {
		for (int i = 0; i < times; i++) {
			item.updateQuality();
		}
	}
}
