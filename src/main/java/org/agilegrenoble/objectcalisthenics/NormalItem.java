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
        if (name.equals("Aged Brie")) {
            quality.increase();
            sellIn.decreaseSellIn();
            if (sellIn.getSellIn() < 0) {
                quality.increase();
            }
        } else if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) { 
            quality.decrease();
            sellIn.decreaseSellIn();
            if (sellIn.getSellIn() < 0) {
                quality.decrease();
            }
        } else { // backstage pass
            
            quality.increase();

            if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (sellIn.getSellIn() < 11) {
                    quality.increase();
                }

                if (sellIn.getSellIn() < 6) {
                    quality.increase();
                }
            }

            sellIn.decreaseSellIn();

            if (sellIn.getSellIn() < 0) {
                quality.resetToZero();
            }
        }
    }
}
