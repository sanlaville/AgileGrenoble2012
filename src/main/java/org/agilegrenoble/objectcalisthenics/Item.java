package org.agilegrenoble.objectcalisthenics;

import org.agilegrenoble.objectcalisthenics.quality.Quality;

public abstract class Item {
    protected String name;
    public SellIn sellIn;
    protected Quality quality;

    public Item(String name, Quality quality, SellIn sellIn) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    public abstract void updateQuality();
}