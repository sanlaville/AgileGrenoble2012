package org.agilegrenoble.objectcalisthenics.Ageing;
 
import org.agilegrenoble.objectcalisthenics.quality.Quality;

public abstract class Ageing {

    protected int daysBefore;

    public Ageing(int daysBefore) {
        this.daysBefore = daysBefore;
    }

    public abstract void advanceOneDay(Quality quality);

    public int getDayCountDown() {
        return daysBefore;
    }
    
    public void updateDaysBefore() {
        daysBefore -= 1;
    }
    
    protected boolean isPastDaysBefore() {
        return daysBefore < 1;
    }

}