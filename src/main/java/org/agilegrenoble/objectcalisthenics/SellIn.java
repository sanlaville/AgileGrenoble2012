package org.agilegrenoble.objectcalisthenics;

public class SellIn {
    private int sellIn;

    public SellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getSellIn() {
        return sellIn;
    }

    /**
     * Decrease sellIn by the given value
     */
    protected void decrease() {
    	sellIn -= 1;
    }
}