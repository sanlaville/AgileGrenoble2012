package org.agilegrenoble.objectcalisthenics;

public class Quality {
    private int quality;

    public Quality(int quality) {
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    /**
     * Decrease quality by the given value
     * 
     * @param value
     *            integer by which the quality should be increased.
     */
    protected void decrease(int value) {
        quality -= value;
    }

    /**
     * Increase quality by the given value
     * 
     * @param value
     *            integer by which the quality should be increased.
     */
    protected void increase(int value) {
        quality += value;
    }

    /**
     * Reset quality to zero
     */
    protected void resetToZero() {
        quality = 0;
    }
}