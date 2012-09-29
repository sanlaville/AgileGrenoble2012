package org.agilegrenoble.objectcalisthenics;

public class Quality implements Cloneable {

	private int value;

	public Quality(int initialValue) {
		this.value = initialValue;
	}

	/**
	 * Drop quality to zero
	 */
	public void dropQualityToZero() {
		value = 0;
	}

	/**
	 * Increase quality by the given value
	 *
	 * @param value
	 *            integer by which the quality should be increased.
	 */
	public void increaseQuality(int value) {
		this.value += value;

	}

	/**
	 * Decrease quality by the given value
	 *
	 * @param value
	 *            integer by which the quality should be increased.
	 */
	public void decreaseQuality(int value) {
		this.value -= value;
	}

	public boolean hasNegativeQuality() {
		if (value < 0)
			return true;

		return false;
	}

	public boolean hasQualityGreaterThan50() {
		if (value > 50)
			return true;

		return false;
	}

	public void keepQualityTo50() {
		value = 50;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quality other = (Quality) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quality [value=" + value + "]";
	}

	public Quality clone() {
		Quality clone = null;
		try {
			clone = (Quality) super.clone();
		} catch (CloneNotSupportedException cnse) {
			// This is not possible
		}
		return clone;
	}

	/**
	 *
	 * @return the value of the quality
	 */
	public int value() {
		return value;
	}
}
