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
     * 
     * @param value
     *            integer by which the sellIn should be increased.
     */
    protected void decreaseSellIn(int value) {
    	sellIn -= value;
    }
}