package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;

/**
 * Business Rule: Increase Quality by 2.
 * 
 */
public class IncreaseQualityByTwo implements IBusinessRule {

	protected Quality quality = null;

	/**
	 * Create a new instance for this business rule.
	 * 
	 * @param quality
	 *            the quality to increase. Must be not null.
	 */
	public IncreaseQualityByTwo(Quality quality) {
		this.quality = quality;
	}

	@Override
	public void execute() {
		quality.increaseQuality(2);
	}

}
