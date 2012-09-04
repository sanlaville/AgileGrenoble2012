package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class NormalItem extends Item {

    public NormalItem(String name, SellIn sellIn, Quality quality) {
        super(name, quality, sellIn);
	}

    public interface SelllIn {
        
    }
    /**
	 * Update quality for the item
	 * 
	 */
    public void updateQuality() {
        sellIn.oneDayPassed(quality);
    }
}
