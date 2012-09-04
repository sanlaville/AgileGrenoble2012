package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.quality.Quality;


public class SellIn extends Ageing {
    public SellIn(int sellIn) {
        super(sellIn);
    }

    public void oneDayPassed(Quality quality) {
        quality.update();
        if (sellIn < 1) {
            quality.update();
        }
        advanceOneDay(); 

    }
}