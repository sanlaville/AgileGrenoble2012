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
        if (quality > 0)
            quality -= value;
    }

    public void decrease() {
        decrease(1);
    }
    
    /**
     * Increase quality by the given value
     * 
     * @param value
     *            integer by which the quality should be increased.
     */
    protected void increase(int value) {
        if (quality < 50)
            quality += value;
    }
    
    public void increase() {
        increase(1);
    }

    /**
     * Reset quality to zero
     */
    public void resetToZero() {
        quality = 0;
    }

}