package org.agilegrenoble.objectcalisthenics.quality;

public interface Quality {

    int getQuality();

    /**
     * Decrease quality by the given value
     * 
     * @param value
     *            integer by which the quality should be increased.
     */
    void decrease(int value);

    /**
     * Increase quality by the given value
     * 
     * @param value
     *            integer by which the quality should be increased.
     */
    void increase(int value);

    void increase();

    void decrease();

    /**
     * Reset quality to zero
     */
    void resetToZero();

}