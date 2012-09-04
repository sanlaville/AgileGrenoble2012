package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class DecayWithAge extends Ageing {
    
    public DecayWithAge(int daysUntilBestBeforeDate) {
        super(daysUntilBestBeforeDate);
    }

    public void advanceOneDay(Quality quality) {
        quality.decrease();
        if (daysBefore < 1) {
            quality.decrease();
        }
        updateDaysBefore(); 

    }
}