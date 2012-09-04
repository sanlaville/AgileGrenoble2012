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
        if (name.equals("Backstage passes to a TAFKAL80ETC concert")) { // backstage pass
            SellIn sellIn = new EventSellIn(this.sellIn.getSellIn());
            
            sellIn.oneDayPassed(quality);
        } else {
            sellIn.oneDayPassed(quality);
        }
    }
}
