package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;

public class QualityIsNeverNegative {

	protected Quality quality = null;
	
	public QualityIsNeverNegative(Quality quality) {
		this.quality = quality;
	}

	public void execute() {
		if (quality.hasNegativeQuality())
			quality.dropQualityToZero();
	}

}
