package org.agilegrenoble.objectcalisthenics.items;

import org.agilegrenoble.objectcalisthenics.Ageing.Ageing;
import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class NormalItem extends Item {

    public NormalItem(String name, Ageing ageing, Quality quality) {
        super(name, quality, ageing);
	}

    /**
	 * Update quality for the item
	 * 
	 */
    public void updateQuality() {
        ageing.advanceOneDay(quality);
    }
}
