package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public abstract class Ageing {

    protected int sellIn;

    public Ageing(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getSellIn() {
        return sellIn;
    }

    /**
     * Decrease sellIn by the given value
     */
    protected void advanceOneDay() {
    	sellIn -= 1;
    }

    public abstract void oneDayPassed(Quality quality);

}