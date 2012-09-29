package org.agilegrenoble.objectcalisthenics.assertions;

import org.agilegrenoble.objectcalisthenics.Quality;
import org.fest.assertions.GenericAssert;

public class QualityAssert extends GenericAssert<QualityAssert, Quality> {

	public QualityAssert(Quality actual) {
		super(QualityAssert.class, actual);
	}

	public static QualityAssert assertThat(Quality actual) {
		return new QualityAssert(actual);
	}

	public QualityAssert is(int value) {
		if (actual.value() != value)
			fail("expected quality:<" + value + "> but was:<" + actual.value() + ">");
		return this;
	}

	public QualityAssert isGreaterThan(Quality quality) {
		if (actual.value() <= quality.value())
			fail(actual.value() + " should be greater than " + quality.value());
		return this;
	}

	public QualityAssert isGreaterThanOrEqualTo(int value) {
		if (actual.value() < value)
			fail(actual.value() + " should be greater than or equal to " + value);
		return this;
	}

	public QualityAssert isGreaterThanOrEqualTo(Quality quality) {
		if (actual.value() < quality.value())
			fail(actual.value() + " should be greater than or equal to "
					+ quality.value());
		return this;
	}

	public QualityAssert isLessThanOrEqualTo(int value) {
		if (actual.value() > value)
			fail(actual.value() + " should be less than or equal to " + value);
		return this;
	}

}