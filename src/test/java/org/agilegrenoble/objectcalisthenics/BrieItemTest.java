package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.assertions.QualityAssert;
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
		Quality startQuality = new Quality(20);
		Item brie = buildItem(startQuality);

		// When
		brie.updateQuality();

		// Then
		QualityAssert.assertThat(brie.quality()).isGreaterThan( new Quality(20));
	}


	@Override
	protected Item buildItem(Quality startQuality) {
		return buildItem(10, startQuality);
	}

	@Override
	protected Item buildItem(int startSellIn, Quality startQuality) {
		return new BrieItem(startSellIn, startQuality);
	}
}
