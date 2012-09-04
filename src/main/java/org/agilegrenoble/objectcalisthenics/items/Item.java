package org.agilegrenoble.objectcalisthenics.items;

import org.agilegrenoble.objectcalisthenics.Ageing.Ageing;
import org.agilegrenoble.objectcalisthenics.quality.Quality;

public abstract class Item {
    protected String name;
    public Ageing sellIn;
    protected Quality quality;

    public Item(String name, Quality quality, Ageing sellIn) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    public abstract void updateQuality();
}