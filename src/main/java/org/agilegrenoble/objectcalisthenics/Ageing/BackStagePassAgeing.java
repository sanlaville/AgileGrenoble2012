package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class BackStagePassAgeing extends Ageing {

    private BackStagePassAgeingStrategies strategies = new BackStagePassAgeingStrategies();

    public BackStagePassAgeing(int daysBeforeConcert) {
        super(daysBeforeConcert);
    }

    public void advanceOneDay(Quality quality) {
        strategies.getFor(daysBefore).applyTo(quality);
        updateDaysBefore();
    }
}