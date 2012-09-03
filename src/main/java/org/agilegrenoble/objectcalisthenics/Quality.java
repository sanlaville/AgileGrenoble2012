package org.agilegrenoble.objectcalisthenics;

public class Quality extends Cuality {
    
    public Quality(int quality) {
        super(quality);
    }

    public void decrease() {
        decrease(1);
    }
    
    public void increase() {
        increase(1);
    }

}