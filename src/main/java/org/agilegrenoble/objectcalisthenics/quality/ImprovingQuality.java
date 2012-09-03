package org.agilegrenoble.objectcalisthenics.quality;


public final class ImprovingQuality extends Quality {
    public ImprovingQuality(int quality) {
        super(quality);
    }

    @Override
    public void decrease() {
        increase(1);
    }

    @Override
    public void increase() {
        increase(1);
    }

    @Override
    public void update() {
        increase(1);
        
    }
}