package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public abstract class Ageing {

    protected int daysBefore;

    public Ageing(int daysBefore) {
        this.daysBefore = daysBefore;
    }

    public int getDayCountDown() {
        return daysBefore;
    }

    /**
     * Decrease sellIn by the given value
     */
    public void updateDaysBefore() {
    	daysBefore -= 1;
    }

    public abstract void advanceOneDay(Quality quality);

}