package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.quality.Quality;


public class SellIn {
    private int sellIn;

    public SellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getSellIn() {
        return sellIn;
    }

    /**
     * Decrease sellIn by the given value
     */
    protected void decrease() {
    	sellIn -= 1;
    }
    
    public void oneDayPassed(Quality quality) {
        quality.update();
        if (sellIn < 1) {
            quality.update();
        }
        decrease();

    }
}