package org.agilegrenoble.objectcalisthenics;

import java.util.Random;

import org.agilegrenoble.objectcalisthenics.assertions.QualityAssert;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

public class QualityTest {

	protected Random random = null;

	@Before
	public void setup() {
		random = new Random();
	}

	@Test
	public void increaseQuality_ShouldIncreaseQualityByTheGivenValue() {
		// Given
		int initialValue = random.nextInt();
		Quality quality = new Quality(initialValue);

		int value = random.nextInt();

		// When
		quality.increaseQuality(value);

		// Then
		int expectedValue = initialValue + value;
		QualityAssert.assertThat(quality).is(expectedValue);
	}

	@Test
	public void decreaseQuality_ShouldDecreaseQualityByTheGivenValue() {
		// Given
		int initialValue = random.nextInt();
		Quality quality = new Quality(initialValue);

		int value = random.nextInt();

		// When
		quality.decreaseQuality(value);

		// Then
		int expectedValue = initialValue - value;
		QualityAssert.assertThat(quality).is(expectedValue);
	}

	@Test
	public void dropQualityToZero_ShouldSetQualityToZero() {
		// Given
		int initialValue = random.nextInt();
		Quality quality = new Quality(initialValue);

		// When
		quality.dropQualityToZero();

		// Then
		QualityAssert.assertThat(quality).is(0);
	}

	@Test
	public void hasNegativeQuality_WithNegativeQuality_ShouldReturn_True() {
		// Given
		int initialValue = random.nextInt(5) - 5;
		Quality quality = new Quality(initialValue);

		// When
		boolean actualHasNegativeQuality = quality.hasNegativeQuality();

		// Then
		Assertions.assertThat(actualHasNegativeQuality).isTrue();
	}

	@Test
	public void hasNegativeQuality_WithPositiveQuality_ShouldReturn_False() {
		// Given
		int initialValue = random.nextInt(50);
		Quality quality = new Quality(initialValue);

		// When
		boolean actualHasNegativeQuality = quality.hasNegativeQuality();

		// Then
		Assertions.assertThat(actualHasNegativeQuality).isFalse();
	}

	@Test
	public void hasQualityGreaterThan50_WithQualityGreaterThan50_ShouldReturn_True() {
		// Given
		int initialValue = random.nextInt(30) + 51;
		Quality quality = new Quality(initialValue);

		// When
		boolean actualHasQualityGreaterThan50 = quality
				.hasQualityGreaterThan50();

		// Then
		Assertions.assertThat(actualHasQualityGreaterThan50).isTrue();
	}

	@Test
	public void hasQualityGreaterThan50_WithQualityLowerThanOrEquals50_ShouldReturn_False() {
		// Given
		int initialValue = random.nextInt(51);
		Quality quality = new Quality(initialValue);

		// When
		boolean actualHasQualityGreaterThan50 = quality.hasQualityGreaterThan50();

		// Then
		Assertions.assertThat(actualHasQualityGreaterThan50).isFalse();
	}

	@Test
	public void keepQualityTo50_Should_SetQualityTo50() {
		// Given
		int initialValue = random.nextInt();
		Quality quality = new Quality(initialValue);

		// When
		quality.keepQualityTo50();

		// Then
		QualityAssert.assertThat(quality).is(50);
	}
}
