package org.agilegrenoble.objectcalisthenics.items;

import org.agilegrenoble.objectcalisthenics.Ageing.SellIn;
import org.agilegrenoble.objectcalisthenics.quality.DegradingQuality;

public class Sulfuras extends Item {

    public Sulfuras() {
        //TODO could use a ConstantQuality instead
        this(new SellIn(0));
    }
    public Sulfuras(SellIn sellIn) {
        super("Sulfuras, Hand of Ragnaros", new DegradingQuality(80), sellIn);
    }
    @Override
    public void updateQuality() {
        
    }

}
