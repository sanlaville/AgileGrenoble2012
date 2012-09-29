package org.agilegrenoble.objectcalisthenics.assertions;

import org.agilegrenoble.objectcalisthenics.SellIn;
import org.fest.assertions.GenericAssert;

public class SellInAssert extends GenericAssert<SellInAssert, SellIn> {

	public SellInAssert(SellIn actual) {
		super(SellInAssert.class, actual);
	}

	public static SellInAssert assertThat(SellIn actual) {
		return new SellInAssert(actual);
	}

	public SellInAssert is(int value) {
		if (actual.value() != value)
			fail("expected quality:<" + value + "> but was:<" + actual.value() + ">");
		return this;
	}
}