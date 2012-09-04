package org.agilegrenoble.objectcalisthenics.Ageing;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class BackStagePassAgeing extends Ageing {

    public BackStagePassAgeing(int sellIn) {
        super(sellIn);
    }

    public void oneDayPassed(Quality quality) {
        quality.update();
    
        if (sellIn < 11) {
            quality.update();
        }
    
        if (sellIn < 6) {
            quality.update();
        }
    
    
        if (sellIn < 1) {
            quality.resetToZero();
        }
        
        advanceOneDay();
    }
}