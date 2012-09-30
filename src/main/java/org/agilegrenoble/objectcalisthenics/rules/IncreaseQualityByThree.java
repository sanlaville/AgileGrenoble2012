package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;

/**
 * Business Rule: Increase Quality by 3.
 * 
 */
public class IncreaseQualityByThree implements IBusinessRule {

	protected Quality quality = null;

	/**
	 * Create a new instance for this business rule.
	 * 
	 * @param quality
	 *            the quality to increase by 3. Must be not null.
	 */
	public IncreaseQualityByThree(Quality quality) {
		this.quality = quality;
	}

	@Override
	public void execute() {
		quality.increaseQuality(3);
	}

}
