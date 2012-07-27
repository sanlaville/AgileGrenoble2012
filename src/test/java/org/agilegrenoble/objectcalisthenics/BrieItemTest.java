package org.agilegrenoble.objectcalisthenics;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BrieItemTest extends ItemTest {


	@Before
	public void setup() {
		super.setup();
	}

	@Test
	public void brie_quality_increases_with_time() {
		// Given
		int startQuality = 20;
		Item brie = buildItem(startQuality);

		// When
		brie.updateQuality();

		// Then
		assertThat(brie.quality).isEqualTo(startQuality + 1);
	}


	@Override
	protected Item buildItem(int startQuality) {
		return buildItem(10, startQuality);
	}

	@Override
	protected Item buildItem(int startSellIn, int startQuality) {
		return new BrieItem(startSellIn, startQuality);
	}
}
