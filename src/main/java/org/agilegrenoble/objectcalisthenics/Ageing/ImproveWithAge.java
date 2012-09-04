package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class ImproveWithAge extends Ageing {

    public ImproveWithAge(int daysUntilBestAfterDate) {
        super(daysUntilBestAfterDate);
    }

    @Override
    public void oneDayPassed(Quality quality) {
        quality.increase();
        if (sellIn < 1) {
            quality.increase();
        }
        advanceOneDay(); 

    }

}
