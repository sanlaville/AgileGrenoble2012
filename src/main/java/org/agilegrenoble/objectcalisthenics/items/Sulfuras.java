package org.agilegrenoble.objectcalisthenics.items;

import org.agilegrenoble.objectcalisthenics.Ageing.Ageing;
import org.agilegrenoble.objectcalisthenics.Ageing.NoAgeing;
import org.agilegrenoble.objectcalisthenics.quality.Between0and50Quality;

public class Sulfuras extends NormalItem {

    public Sulfuras() {
        this(new NoAgeing(0));
    }
    
    public Sulfuras(int startSellIn) {
        this(new NoAgeing(startSellIn));
    }
    
    private Sulfuras(Ageing sellIn) {
        super("Sulfuras, Hand of Ragnaros", sellIn, new Between0and50Quality(80));
    }
    

}
