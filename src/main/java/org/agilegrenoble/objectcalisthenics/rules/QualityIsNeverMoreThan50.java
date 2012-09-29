package org.agilegrenoble.objectcalisthenics.rules;

import org.agilegrenoble.objectcalisthenics.Quality;

public class QualityIsNeverMoreThan50 {

	protected Quality quality = null;
	
	public QualityIsNeverMoreThan50(Quality quality) {
		this.quality = quality;
	}

	public void execute() {
		if (quality.hasQualityGreaterThan50())
			quality.keepQualityTo50();
	}

}
