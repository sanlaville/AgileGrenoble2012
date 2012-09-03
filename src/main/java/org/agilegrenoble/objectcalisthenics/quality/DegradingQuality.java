package org.agilegrenoble.objectcalisthenics.quality;


public class DegradingQuality extends Quality {
    
    public DegradingQuality(int quality) {
        super(quality);
    }

    @Override
    public void update() {
        decrease(1);
        
    }

}