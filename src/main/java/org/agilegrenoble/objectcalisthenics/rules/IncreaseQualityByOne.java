package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;

/**
 * Business Rule: Increase Quality by 1.
 * 
 */
public class IncreaseQualityByOne implements IBusinessRule {

	protected Quality quality = null;

	/**
	 * Create a new instance for this business rule.
	 * 
	 * @param quality
	 *            the quality to increase by 1. Must be not null.
	 */
	public IncreaseQualityByOne(Quality quality) {
		this.quality = quality;
	}

	@Override
	public void execute() {
		quality.increaseQuality(1);
	}

}
