package org.agilegrenoble.objectcalisthenics.quality;


public class DegradingQuality extends Quality {
    
    public DegradingQuality(int quality) {
        super(quality);
    }

    public void decrease() {
        decrease(1);
    }
    
    public void increase() {
        increase(1);
    }

}