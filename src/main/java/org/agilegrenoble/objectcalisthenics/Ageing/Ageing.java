package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public abstract class Ageing {

    protected int daysBefore;

    public Ageing(int sellIn) {
        this.daysBefore = sellIn;
    }

    public int getDayCountDown() {
        return daysBefore;
    }

    /**
     * Decrease sellIn by the given value
     */
    public void advanceOneDay() {
    	daysBefore -= 1;
    }

    public abstract void oneDayPassed(Quality quality);

}