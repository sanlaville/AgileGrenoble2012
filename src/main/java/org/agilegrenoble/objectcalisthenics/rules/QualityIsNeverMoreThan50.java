package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;

public class QualityIsNeverMoreThan50 implements IBusinessRule {

	protected Quality quality = null;
	
	/**
	 * Create a new instance for this business rule.
	 * 
	 * @param quality the quality to verify. Must be not null.
	 */
	public QualityIsNeverMoreThan50(Quality quality) {
		this.quality = quality;
	}

	@Override
	public void execute() {
		if (quality.hasQualityGreaterThan50())
			quality.keepQualityTo50();
	}

}
