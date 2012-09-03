package org.agilegrenoble.objectcalisthenics;

public final class IncreasingQuality extends Cuality {
    public IncreasingQuality(int quality) {
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
}