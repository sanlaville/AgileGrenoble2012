package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;


public class DecayWithAge extends Ageing {
    public DecayWithAge(int sellIn) {
        super(sellIn);
    }

    public void oneDayPassed(Quality quality) {
        quality.decrease();
        if (daysBefore < 1) {
            quality.decrease();
        }
        advanceOneDay(); 

    }
}