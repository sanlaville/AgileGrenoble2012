package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class Item {
	protected String name;
	public SellIn sellIn;
    protected Quality quality;

    public Item(String name, SellIn sellIn, Quality quality) {
		this.name = name;
		this.quality = quality;
		this.sellIn = sellIn;
	}

	/**
	 * Update quality for the item
	 * 
	 */
	public void updateQuality() {
		if (!name.equals("Aged Brie")
				&& !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            	quality.decrease();
            }
		} else {
			quality.increase();

            if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            	if (sellIn.getSellIn() < 11) {
            		quality.increase();
            	}

            	if (sellIn.getSellIn() < 6) {
            		quality.increase();
            	}
            }
		}

		if (!name.equals("Sulfuras, Hand of Ragnaros")) {
			sellIn.decreaseSellIn();
		}

		if (sellIn.getSellIn() < 0) {
			if (!name.equals("Aged Brie")) {
				if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                    	quality.decrease();
                    }
				} else {
					quality.resetToZero();
				}
			} else {
				quality.increase();
			}
		}
	}
}
