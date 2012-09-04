package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class BackStagePassAgeing extends Ageing {

    public BackStagePassAgeing(int daysBeforeConcert) {
        super(daysBeforeConcert);
    }

    public void oneDayPassed(Quality quality) {
        quality.increase();
    
        if (daysBefore < 11) {
            quality.increase();
        }
    
        if (daysBefore < 6) {
            quality.increase();
        }
    
    
        if (daysBefore < 1) {
            quality.resetToZero();
        }
        
        advanceOneDay();
    }
}