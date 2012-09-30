package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;

/**
 * Business Rule: Drop Quality to 0.
 * 
 */
public class DropQualityToZero implements IBusinessRule {

	protected Quality quality = null;

	/**
	 * Create a new instance for this business rule.
	 * 
	 * @param quality
	 *            the quality to drop to zero. Must be not null.
	 */
	public DropQualityToZero(Quality quality) {
		this.quality = quality;
	}

	@Override
	public void execute() {
		quality.dropQualityToZero();
	}

}
