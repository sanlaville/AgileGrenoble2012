package org.agilegrenoble.objectcalisthenics;

import static org.fest.assertions.Assertions.assertThat;


import org.junit.Before;
import org.junit.Test;

public class NormalItemTest extends ItemTest {


	@Before
	public void setup() {
		super.setup();
	}

	@Test
	public void quality_degrades_twice_as_fast_after_the_sell_date_has_passed() {
		// Given
		int startquality = 10;
		Item freshItem = buildRandomNormalItem(2, startquality);
		Item passedItem = buildRandomNormalItem(0, startquality);

		// When
		freshItem.updateQuality();
		int actualFreshItemQuality = startquality - freshItem.quality;
		passedItem.updateQuality();
		int actualPassedItemQuality = startquality - passedItem.quality;

		// Then
		assertThat(actualFreshItemQuality).isEqualTo(
				actualPassedItemQuality / 2);
	}


	private Item buildRandomNormalItem(int sellIn, int quality) {
		Item item = null;

		int ran = random.nextInt(2);
		switch (ran) {
		case 0:
			item = new NormalItem("+5 Dexterity Vest", sellIn, quality);
			break;
		case 1:
			item = new NormalItem("Elixir of the Mongoose", sellIn, quality);
			break;
		}

		return item;
	}
	
	private Item buildRandomNormalItem(int quality) {
		Item item = null;
		
		int ran = random.nextInt(2);
		switch (ran) {
		case 0:
			item = new NormalItem("+5 Dexterity Vest", 10, quality);
			break;
		case 1:
			item = new NormalItem("Elixir of the Mongoose", 5, quality);
			break;
		}
		
		return item;
	}

	@Override
	protected Item buildItem(int quality) {
		return buildRandomNormalItem(quality);
	}

	@Override
	protected Item buildItem(int sellIn, int quality) {
		return buildRandomNormalItem(sellIn, quality);
	}
}
