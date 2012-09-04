package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class ImproveWithAge extends Ageing {

    public ImproveWithAge(int daysUntilBestAfterDate) {
        super(daysUntilBestAfterDate);
    }

    @Override
    public void advanceOneDay(Quality quality) {
        quality.increase();
        if (isPastDaysBefore()) {
            quality.increase();
        }
        updateDaysBefore(); 

    }

}
