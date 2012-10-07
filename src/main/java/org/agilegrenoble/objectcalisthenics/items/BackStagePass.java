package org.agilegrenoble.objectcalisthenics.items;

import org.agilegrenoble.objectcalisthenics.Ageing.Ageing;
import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class BackStagePass extends Item{

    public BackStagePass(Quality quality, Ageing sellIn) {
        super("Backstage passes to a TAFKAL80ETC concert", quality, sellIn);
    }


    public int getQuality() {
        return quality.getQuality();
    }

    @Override
    public void updateQuality() {
        ageing.advanceOneDay(quality);
        
    }
}