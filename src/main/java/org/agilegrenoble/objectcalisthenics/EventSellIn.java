package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.NormalItem.SelllIn;
import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class EventSellIn extends SellIn implements SelllIn {

    public EventSellIn(int sellIn) {
        super(sellIn);
    }

    public void oneDayPassed(Quality quality) {
        quality.update();
    
        if (getSellIn() < 11) {
            quality.update();
        }
    
        if (getSellIn() < 6) {
            quality.update();
        }
    
    
        if (getSellIn() < 1) {
            quality.resetToZero();
        }
        
        decrease();
    }
}