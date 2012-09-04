package org.agilegrenoble.objectcalisthenics.items;

import org.agilegrenoble.objectcalisthenics.Ageing.DecayWithAge;
import org.agilegrenoble.objectcalisthenics.quality.Quality;

public class Sulfuras extends Item {

    public Sulfuras() {
        //TODO could use a ConstantQuality instead
        this(new DecayWithAge(0));
    }
    public Sulfuras(DecayWithAge sellIn) {
        super("Sulfuras, Hand of Ragnaros", new Quality(80), sellIn);
    }
    @Override
    public void updateQuality() {
        
    }

}
