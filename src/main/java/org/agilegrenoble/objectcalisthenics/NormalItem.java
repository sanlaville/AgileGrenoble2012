package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class NormalItem extends Item {

    public NormalItem(String name, SellIn sellIn, Quality quality) {
        super(name, quality, sellIn);
	}

	/**
	 * Update quality for the item
	 * 
	 */
    public void updateQuality() {
        if (name.equals("Backstage passes to a TAFKAL80ETC concert")) { // backstage pass
            
            quality.update();

            if (sellIn.getSellIn() < 11) {
                quality.update();
            }

            if (sellIn.getSellIn() < 6) {
                quality.update();
            }


            if (sellIn.getSellIn() < 1) {
                quality.resetToZero();
            }
            
            sellIn.decrease();
        } else {
            quality.update();
            if (sellIn.getSellIn() < 1) {
                quality.update();
            }
            sellIn.decrease();
        }
    }
}
